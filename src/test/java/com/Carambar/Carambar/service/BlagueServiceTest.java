package com.Carambar.Carambar.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Carambar.Carambar.entity.Blague;
import com.Carambar.Carambar.exception.BlagueNotFoundException;
import com.Carambar.Carambar.repository.BlagueRepository;

@ExtendWith(MockitoExtension.class)

class BlagueServiceTest {

    @Mock
    private BlagueRepository blagueRepository;

    @InjectMocks
    private BlagueService blagueService;

    @Test
    void shouldReturnBlagueWhenIdExists() {
        // GIVEN
        Blague blague = new Blague();
        blague.setId(1L);
        blague.setQuestion("Question ?");
        blague.setReponse("Réponse");

        when(blagueRepository.findById(1L))
                .thenReturn(Optional.of(blague));

        // WHEN
        Blague result = blagueService.getById(1L);

        // THEN
        assertNotNull(result);
        assertEquals("Question ?", result.getQuestion());
    }

    @Test
    void shouldThrowExceptionWhenBlagueNotFound() {
        // GIVEN
        when(blagueRepository.findById(99L))
                .thenReturn(Optional.empty());

        // THEN
        assertThrows(
                BlagueNotFoundException.class,
                () -> blagueService.getById(99L));
    }

    @Test
    void shouldSaveBlague() {
        // GIVEN
        Blague blague = new Blague();
        blague.setQuestion("Q");
        blague.setReponse("R");

        when(blagueRepository.save(any(Blague.class)))
                .thenReturn(blague);

        // WHEN
        Blague saved = blagueService.add(blague);

        // THEN
        assertNotNull(saved);
        verify(blagueRepository, times(1)).save(blague);
    }

}
