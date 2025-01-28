package com.example.projetoEmakers.controller;

import com.example.projetoEmakers.data.entity.Maquina;
import com.example.projetoEmakers.repository.MaquinaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MaquinaControllerTest {

    @Mock
    private MaquinaRepository maquinaRepository;

    @InjectMocks
    private MaquinaController maquinaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllMaquinas() {
        Maquina maquina1 = new Maquina("Maquina A", "Categoria A", 100, new Date());
        Maquina maquina2 = new Maquina("Maquina B", "Categoria B", 200, new Date());

        when(maquinaRepository.findAll()).thenReturn(Arrays.asList(maquina1, maquina2));

        var maquinas = maquinaController.getAllMaquinas();

        assertNotNull(maquinas);
        assertEquals(2, maquinas.size());
        assertEquals("Maquina A", maquinas.get(0).getNome());
        verify(maquinaRepository, times(1)).findAll();
    }

    @Test
    void testCreateMaquina() {
        Maquina maquina = new Maquina("Maquina Nova", "Categoria Nova", 150, new Date());
        Maquina savedMaquina = new Maquina("Maquina Nova", "Categoria Nova", 150, new Date());
        savedMaquina.setIdMaq(1L);

        when(maquinaRepository.save(maquina)).thenReturn(savedMaquina);

        var result = maquinaController.createMaquina(maquina);

        assertNotNull(result);
        assertEquals(1L, result.getIdMaq());
        assertEquals("Maquina Nova", result.getNome());
        verify(maquinaRepository, times(1)).save(maquina);
    }

    @Test
    void testGetMaquinaById_Success() {
        Maquina maquina = new Maquina("Maquina A", "Categoria A", 100, new Date());
        maquina.setIdMaq(1L);

        when(maquinaRepository.findById(1L)).thenReturn(Optional.of(maquina));

        var response = maquinaController.getMaquinaById(1L);

        assertNotNull(response);
        assertEquals(ResponseEntity.ok(maquina), response);
        verify(maquinaRepository, times(1)).findById(1L);
    }

    @Test
    void testGetMaquinaById_NotFound() {
        when(maquinaRepository.findById(1L)).thenReturn(Optional.empty());

        var response = maquinaController.getMaquinaById(1L);

        assertNotNull(response);
        assertEquals(ResponseEntity.notFound().build(), response);
        verify(maquinaRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateMaquina_Success() {
        Maquina existingMaquina = new Maquina("Maquina Antiga", "Categoria Antiga", 100, new Date());
        existingMaquina.setIdMaq(1L);

        Maquina updatedMaquina = new Maquina("Maquina Atualizada", "Categoria Atualizada", 150, new Date());

        when(maquinaRepository.findById(1L)).thenReturn(Optional.of(existingMaquina));
        when(maquinaRepository.save(existingMaquina)).thenReturn(existingMaquina);

        var response = maquinaController.updateMaquina(1L, updatedMaquina);

        assertNotNull(response);
        assertEquals(ResponseEntity.ok(existingMaquina), response);
        assertEquals("Maquina Atualizada", existingMaquina.getNome());
        verify(maquinaRepository, times(1)).findById(1L);
        verify(maquinaRepository, times(1)).save(existingMaquina);
    }

    @Test
    void testUpdateMaquina_NotFound() {
        Maquina updatedMaquina = new Maquina("Maquina Atualizada", "Categoria Atualizada", 150, new Date());

        when(maquinaRepository.findById(1L)).thenReturn(Optional.empty());

        var response = maquinaController.updateMaquina(1L, updatedMaquina);

        assertNotNull(response);
        assertEquals(ResponseEntity.notFound().build(), response);
        verify(maquinaRepository, times(1)).findById(1L);
        verify(maquinaRepository, never()).save(any());
    }

    @Test
    void testDeleteMaquina_Success() {
        Maquina maquina = new Maquina("Maquina A", "Categoria A", 100, new Date());
        maquina.setIdMaq(1L);

        when(maquinaRepository.findById(1L)).thenReturn(Optional.of(maquina));
        doNothing().when(maquinaRepository).delete(maquina);

        var response = maquinaController.deleteMaquina(1L);

        assertNotNull(response);
        assertEquals(ResponseEntity.noContent().build(), response);
        verify(maquinaRepository, times(1)).findById(1L);
        verify(maquinaRepository, times(1)).delete(maquina);
    }

    @Test
    void testDeleteMaquina_NotFound() {
        when(maquinaRepository.findById(1L)).thenReturn(Optional.empty());

        var response = maquinaController.deleteMaquina(1L);

        assertNotNull(response);
        assertEquals(ResponseEntity.notFound().build(), response);
        verify(maquinaRepository, times(1)).findById(1L);
        verify(maquinaRepository, never()).delete(any());
    }
}

