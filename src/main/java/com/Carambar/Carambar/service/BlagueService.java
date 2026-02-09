package com.Carambar.Carambar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Carambar.Carambar.entity.Blague;
import com.Carambar.Carambar.exception.BlagueNotFoundException;
import com.Carambar.Carambar.repository.BlagueRepository;

@Service
public class BlagueService {

    @Autowired
    private BlagueRepository blagueRepository;

    // Afficher une blague aléatoire
    public Blague getRandom() {
        return blagueRepository.findRandom();
    }

    // Ajouter une nouvelle blague
    public Blague add(Blague b) {
        return blagueRepository.save(b);
    }

    // Rechercher une blague par id
    public Blague getById(Long id) {
        return blagueRepository.findById(id)
                .orElseThrow(() -> new BlagueNotFoundException(id));
    }

    // Afficher la liste des blagues
    public List<Blague> getAll() {
        return blagueRepository.findAll();
    }

    // Modifier une Blague
    public Blague update(Long id, Blague newBlague) {
        Blague existing = getById(id);

        existing.setQuestion(newBlague.getQuestion());
        existing.setReponse(newBlague.getReponse());

        return blagueRepository.save(existing);
    }

    // Supprimer une blague
    public void delete(Long id) {
        Blague blague = getById(id);
        blagueRepository.delete(blague);
    }

}
