package com.Carambar.Carambar.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.Carambar.Carambar.dto.BlagueDTO;
import com.Carambar.Carambar.entity.Blague;
import com.Carambar.Carambar.mapper.BlagueMapper;
import com.Carambar.Carambar.service.BlagueService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/blagues")
@CrossOrigin("*")
public class BlagueController {
    private BlagueService blagueService;
    private BlagueMapper blagueMapper;

    public BlagueController(BlagueService blagueService, BlagueMapper blagueMapper) {
        this.blagueService = blagueService;
        this.blagueMapper = blagueMapper;
    }

    // GET: consulter une blague

    @GetMapping("/{id}")
    public BlagueDTO getById(@PathVariable Long id) {
        Blague blague = blagueService.getById(id);
        return blagueMapper.toDTO(blague);
    }

    // GET : récupérer toutes les blagues
    @GetMapping
    public List<BlagueDTO> getAll() {
        return blagueService.getAll()
                .stream()
                .map(blagueMapper::toDTO)
                .toList();
    }

    // GET: consulter une blague aleatoire
    @GetMapping("/random")
    public BlagueDTO getRandom() {
        return blagueMapper.toDTO(blagueService.getRandom());
    }

    // POST: Ajouter une blague
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BlagueDTO create(@Valid @RequestBody BlagueDTO dto) {
        Blague blague = blagueMapper.toEntity(dto);
        return blagueMapper.toDTO(blagueService.add(blague));
    }

    @PutMapping("/{id}")
    public BlagueDTO update(
            @PathVariable Long id,
            @Valid @RequestBody BlagueDTO dto) {

        Blague blague = blagueMapper.toEntity(dto);
        return blagueMapper.toDTO(blagueService.update(id, blague));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        blagueService.delete(id);
    }

}