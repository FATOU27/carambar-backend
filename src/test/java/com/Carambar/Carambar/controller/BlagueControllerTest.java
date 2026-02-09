package com.Carambar.Carambar.controller;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import com.Carambar.Carambar.dto.BlagueDTO;
import com.Carambar.Carambar.entity.Blague;
import com.Carambar.Carambar.exception.GlobalExceptionHandler;
import com.Carambar.Carambar.mapper.BlagueMapper;
import com.Carambar.Carambar.security.JwtService;
import com.Carambar.Carambar.service.BlagueService;

@WebMvcTest(BlagueController.class)
@Import(GlobalExceptionHandler.class)
@AutoConfigureMockMvc(addFilters = false)
class BlagueControllerTest {
    @MockBean
    private JwtService jwtService;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BlagueService blagueService;

    @MockBean
    BlagueMapper blagueMapper;

    @Test
    void shouldReturnBlagueById() throws Exception {
        Blague blague = new Blague();
        blague.setId(1L);
        blague.setQuestion("Q");
        blague.setReponse("R");

        BlagueDTO dto = new BlagueDTO("Q", "R");
        dto.setId(1L);

        when(blagueService.getById(1L)).thenReturn(blague);
        when(blagueMapper.toDTO(blague)).thenReturn(dto);

        mockMvc.perform(get("/api/blagues/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.question").value("Q"))
                .andExpect(jsonPath("$.reponse").value("R"));
    }

}