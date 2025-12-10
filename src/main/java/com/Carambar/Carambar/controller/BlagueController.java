package com.Carambar.Carambar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Carambar.Carambar.entity.Blague;
import com.Carambar.Carambar.service.BlagueService;

@RestController
@RequestMapping("/api/blagues")
@CrossOrigin("*")
public class BlagueController {
    @Autowired
    private BlagueService blagueService;

    // GET: consulter une blague
    @GetMapping("/{id}")
    public Blague getById(@PathVariable Long id) {
        return blagueService.getById(id);
    }

    // GET : récupérer toutes les blagues
    @GetMapping
    public List<Blague> getAll() {
        return blagueService.getAll();
    }

    // GET: consulter une blague aleatoire
    @GetMapping("/random")
    public Blague random() {
        return blagueService.getRandom();
    }

    // POST: Ajouter une blague
    @PostMapping
    public Blague add(@RequestBody Blague blague) {
        return blagueService.add(blague);
    }
}