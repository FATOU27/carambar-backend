package com.Carambar.Carambar.config;

import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.Carambar.Carambar.entity.Blague;
import com.Carambar.Carambar.repository.BlagueRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class DataLoader {
    @Bean
    public CommandLineRunner loadBlagues(BlagueRepository blagueRepository) {
        return arg -> {
            if (blagueRepository.count() == 0) {
                ObjectMapper mapper = new ObjectMapper();
                InputStream inputStream = new ClassPathResource("data/blagues.json").getInputStream();

                List<Blague> blagues = mapper.readValue(inputStream, new TypeReference<List<Blague>>() {
                });
                blagueRepository.saveAll(blagues);
                System.out.println("Blagues chargées:" + blagues.size());

            }
        };
    }

}
