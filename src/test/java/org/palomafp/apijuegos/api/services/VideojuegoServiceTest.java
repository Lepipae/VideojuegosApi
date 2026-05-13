package org.palomafp.apijuegos.api.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.palomafp.apijuegos.api.modelo.Videojuego;
import org.palomafp.apijuegos.api.repositories.VideojuegoRepo;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class VideojuegoServiceTest {

    @Mock
    private VideojuegoRepo videojuegoRepo;

    @Mock
    private EntradaListaService entradaListaService;

    @InjectMocks
    private VideojuegoService videojuegoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerTodos() {
        Videojuego v1 = new Videojuego();
        Videojuego v2 = new Videojuego();
        when(videojuegoRepo.findAll()).thenReturn(Arrays.asList(v1, v2));

        List<Videojuego> result = videojuegoService.obtenerTodos();
        assertEquals(2, result.size());
        verify(videojuegoRepo, times(1)).findAll();
    }

    @Test
    void obtenerPorId() {
        Videojuego v = new Videojuego();
        v.setMiId(1L);
        when(videojuegoRepo.findByMiId(1L)).thenReturn(v);

        Videojuego result = videojuegoService.obtenerPorId(1L);
        assertNotNull(result);
        assertEquals(1L, result.getMiId());
    }

    @Test
    void obtenerPorNombre() {
        Videojuego v = new Videojuego();
        v.setNombre("Juego");
        when(videojuegoRepo.findByNombre("Juego")).thenReturn(v);

        Videojuego result = videojuegoService.obtenerPorNombre("Juego");
        assertNotNull(result);
        assertEquals("Juego", result.getNombre());
    }

    @Test
    void obtenerPorTags() {
        Videojuego v = new Videojuego();
        when(videojuegoRepo.findByTags("Accion")).thenReturn(Arrays.asList(v));

        List<Videojuego> result = videojuegoService.obtenerPorTags("Accion");
        assertEquals(1, result.size());
    }

    @Test
    void obtenerPorDesarrolladora() {
        Videojuego v = new Videojuego();
        when(videojuegoRepo.findByIdDesarrolladora(1)).thenReturn(Arrays.asList(v));

        List<Videojuego> result = videojuegoService.obtenerPorDesarrolladora(1);
        assertEquals(1, result.size());
    }

    @Test
    void borrarVideojuego() {
        doNothing().when(entradaListaService).borrarPorVideojuego(1L);
        doNothing().when(videojuegoRepo).deleteByMiId(1L);
        videojuegoService.borrarVideojuego(1L);
        verify(entradaListaService, times(1)).borrarPorVideojuego(1L);
        verify(videojuegoRepo, times(1)).deleteByMiId(1L);
    }

    @Test
    void guardarNuevoExito() {
        Videojuego nuevo = new Videojuego();
        nuevo.setNombre("Nuevo");

        Videojuego ultimo = new Videojuego();
        ultimo.setMiId(5L);

        when(videojuegoRepo.encontrarUltimoId()).thenReturn(ultimo);
        when(videojuegoRepo.findByNombre("Nuevo")).thenReturn(null);
        when(videojuegoRepo.save(any(Videojuego.class))).thenReturn(nuevo);

        Videojuego result = videojuegoService.guardar(nuevo);
        assertEquals(6L, nuevo.getMiId());
        assertNotNull(result);
        verify(videojuegoRepo).save(nuevo);
    }

    @Test
    void guardarNuevoSinUltimo() {
        Videojuego nuevo = new Videojuego();
        nuevo.setNombre("Nuevo");

        when(videojuegoRepo.encontrarUltimoId()).thenReturn(null);
        when(videojuegoRepo.findByNombre("Nuevo")).thenReturn(null);
        when(videojuegoRepo.save(any(Videojuego.class))).thenReturn(nuevo);

        videojuegoService.guardar(nuevo);
        assertEquals(1L, nuevo.getMiId());
        verify(videojuegoRepo).save(nuevo);
    }

    @Test
    void guardarNuevoNombreRepetidoExcepcion() {
        Videojuego nuevo = new Videojuego();
        nuevo.setNombre("Repetido");

        Videojuego repetido = new Videojuego();
        repetido.setNombre("Repetido");

        when(videojuegoRepo.encontrarUltimoId()).thenReturn(null);
        when(videojuegoRepo.findByNombre("Repetido")).thenReturn(repetido);

        assertThrows(IllegalArgumentException.class, () -> videojuegoService.guardar(nuevo));
        verify(videojuegoRepo, never()).save(any());
    }

    @Test
    void guardarExistenteExito() {
        Videojuego existente = new Videojuego();
        existente.setId("1");
        existente.setNombre("Existente");

        when(videojuegoRepo.findByNombre("Existente")).thenReturn(null);
        when(videojuegoRepo.save(any())).thenReturn(existente);

        videojuegoService.guardar(existente);
        verify(videojuegoRepo).save(existente);
    }

    @Test
    void guardarExistenteNombreDeOtroExcepcion() {
        Videojuego aActualizar = new Videojuego();
        aActualizar.setId("1");
        aActualizar.setNombre("Ocupado");

        Videojuego otro = new Videojuego();
        otro.setId("2");
        otro.setNombre("Ocupado");

        when(videojuegoRepo.findByNombre("Ocupado")).thenReturn(otro);

        assertThrows(IllegalArgumentException.class, () -> videojuegoService.guardar(aActualizar));
    }
}
