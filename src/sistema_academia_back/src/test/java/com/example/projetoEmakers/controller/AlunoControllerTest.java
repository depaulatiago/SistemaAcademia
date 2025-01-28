package com.example.projetoEmakers.controller;

import com.example.projetoEmakers.data.entity.Aluno;
import com.example.projetoEmakers.repository.AlunoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AlunoController.class)
public class AlunoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlunoRepository alunoRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllAlunos() throws Exception {
        Aluno aluno1 = new Aluno("João", 70, 25, "Masculino");
        Aluno aluno2 = new Aluno("Maria", 60, 22, "Feminino");

        when(alunoRepository.findAll()).thenReturn(Arrays.asList(aluno1, aluno2));

        mockMvc.perform(get("/aluno"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nome", is("João")))
                .andExpect(jsonPath("$[1].nome", is("Maria")));
    }

    @Test
    public void testCreateAluno() throws Exception {
        Aluno aluno = new Aluno("Carlos", 75, 30, "Masculino");
        when(alunoRepository.save(Mockito.any(Aluno.class))).thenReturn(aluno);

        mockMvc.perform(post("/aluno")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(aluno)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("Carlos")))
                .andExpect(jsonPath("$.peso", is(75)))
                .andExpect(jsonPath("$.idade", is(30)))
                .andExpect(jsonPath("$.genero", is("Masculino")));
    }

    @Test
    void testGetAlunoById() throws Exception {
        Aluno aluno = new Aluno();
        aluno.setIdAluno(1L);
        aluno.setNome("Ana");
        aluno.setPeso(65); // ou 65.0 dependendo do modelo
        aluno.setIdade(28);
        aluno.setGenero("Feminino");

        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        mockMvc.perform(get("/aluno/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idAluno").value(aluno.getIdAluno()))
                .andExpect(jsonPath("$.nome").value(aluno.getNome()))
                .andExpect(jsonPath("$.peso").value((int) aluno.getPeso())) // Força a comparação como decimal
                .andExpect(jsonPath("$.idade").value(aluno.getIdade()))
                .andExpect(jsonPath("$.genero").value(aluno.getGenero()));
    }

    @Test
    public void testGetAlunoById_NotFound() throws Exception {
        when(alunoRepository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/aluno/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdateAluno() throws Exception {
        Aluno existingAluno = new Aluno("João", 70, 25, "Masculino");
        Aluno updatedAluno = new Aluno("João Carlos", 75, 26, "Masculino");

        when(alunoRepository.findById(1L)).thenReturn(Optional.of(existingAluno));
        when(alunoRepository.save(Mockito.any(Aluno.class))).thenReturn(updatedAluno);

        mockMvc.perform(put("/aluno/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedAluno)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("João Carlos")))
                .andExpect(jsonPath("$.peso", is(75)))
                .andExpect(jsonPath("$.idade", is(26)));
    }

    @Test
    public void testDeleteAluno() throws Exception {
        Aluno aluno = new Aluno("João", 70, 25, "Masculino");
        when(alunoRepository.findById(1L)).thenReturn(Optional.of(aluno));

        mockMvc.perform(delete("/aluno/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteAluno_NotFound() throws Exception {
        when(alunoRepository.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/aluno/1"))
                .andExpect(status().isNotFound());
    }
}
