package com.Carambar.Carambar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Carambar.Carambar.entity.Blague;
import com.Carambar.Carambar.repository.BlagueRepository;

@Service
public class BlagueService {

    @Autowired
    private BlagueRepository blagueRepository;

    public Blague getRandom() {
        return blagueRepository.findRandom();
    }

    public Blague add(Blague b) {
        return blagueRepository.save(b);
    }

    public Blague getById(Long id) {
        return blagueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Blague introuvable"));
    }

    public List<Blague> getAll() {
        return blagueRepository.findAll();
    }
}
