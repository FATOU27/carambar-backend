package com.Carambar.Carambar.mapper;

import org.springframework.stereotype.Component;

import com.Carambar.Carambar.dto.BlagueDTO;
import com.Carambar.Carambar.entity.Blague;

@Component
public class BlagueMapper {

    public BlagueDTO toDTO(Blague blague) {
        if (blague == null)
            return null;

        BlagueDTO dto = new BlagueDTO(
                blague.getQuestion(),
                blague.getReponse());
        dto.setId(blague.getId());
        return dto;
    }

    public Blague toEntity(BlagueDTO dto) {
        if (dto == null)
            return null;

        Blague blague = new Blague();
        blague.setQuestion(dto.getQuestion());
        blague.setReponse(dto.getReponse());
        return blague;
    }
}
