package com.example.projetoEmakers.controller;

import com.example.projetoEmakers.data.entity.Instrutor;
import com.example.projetoEmakers.repository.InstrutorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(InstrutorController.class)
class InstrutorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InstrutorRepository instrutorRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private Instrutor instrutor;

    @BeforeEach
    void setUp() {
        instrutor = new Instrutor();
        instrutor.setIdInst(1L);
        instrutor.setNome("João");
        instrutor.setIdade(30);
        instrutor.setSalario(5000.0);
    }

    @Test
    void testGetAllInstrutores() throws Exception {
        when(instrutorRepository.findAll()).thenReturn(Arrays.asList(instrutor));

        mockMvc.perform(get("/instrutor"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nome").value("João"))
                .andExpect(jsonPath("$[0].idade").value(30))
                .andExpect(jsonPath("$[0].salario").value(5000.0));
    }

    @Test
    void testCreateInstrutor() throws Exception {
        when(instrutorRepository.save(any(Instrutor.class))).thenReturn(instrutor);

        mockMvc.perform(post("/instrutor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(instrutor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João"))
                .andExpect(jsonPath("$.idade").value(30))
                .andExpect(jsonPath("$.salario").value(5000.0));
    }

    @Test
    void testGetInstrutorById_Success() throws Exception {
        when(instrutorRepository.findById(1L)).thenReturn(Optional.of(instrutor));

        mockMvc.perform(get("/instrutor/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("João"))
                .andExpect(jsonPath("$.idade").value(30))
                .andExpect(jsonPath("$.salario").value(5000.0));
    }

    @Test
    void testGetInstrutorById_NotFound() throws Exception {
        when(instrutorRepository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/instrutor/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdateInstrutor_Success() throws Exception {
        Instrutor updatedInstrutor = new Instrutor();
        updatedInstrutor.setNome("Carlos");
        updatedInstrutor.setIdade(35);
        updatedInstrutor.setSalario(6000.0);

        when(instrutorRepository.findById(1L)).thenReturn(Optional.of(instrutor));
        when(instrutorRepository.save(any(Instrutor.class))).thenReturn(updatedInstrutor);

        mockMvc.perform(put("/instrutor/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedInstrutor)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Carlos"))
                .andExpect(jsonPath("$.idade").value(35))
                .andExpect(jsonPath("$.salario").value(6000.0));
    }

    @Test
    void testUpdateInstrutor_NotFound() throws Exception {
        when(instrutorRepository.findById(1L)).thenReturn(Optional.empty());

        Instrutor updatedInstrutor = new Instrutor();
        updatedInstrutor.setNome("Carlos");
        updatedInstrutor.setIdade(35);
        updatedInstrutor.setSalario(6000.0);

        mockMvc.perform(put("/instrutor/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedInstrutor)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteInstrutor_Success() throws Exception {
        when(instrutorRepository.findById(1L)).thenReturn(Optional.of(instrutor));

        mockMvc.perform(delete("/instrutor/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void testDeleteInstrutor_NotFound() throws Exception {
        when(instrutorRepository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/instrutor/1"))
                .andExpect(status().isNotFound());
    }
}
