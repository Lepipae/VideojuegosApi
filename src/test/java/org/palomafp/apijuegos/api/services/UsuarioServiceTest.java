package org.palomafp.apijuegos.api.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.palomafp.apijuegos.api.modelo.Usuario;
import org.palomafp.apijuegos.api.repositories.UsuarioRepo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepo usuarioRepo;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerTodos() {
        Usuario u1 = new Usuario();
        Usuario u2 = new Usuario();
        when(usuarioRepo.findAll()).thenReturn(Arrays.asList(u1, u2));

        List<Usuario> resultado = usuarioService.obtenerTodos();
        assertEquals(2, resultado.size());
        verify(usuarioRepo, times(1)).findAll();
    }

    @Test
    void obtenerPorMiId() {
        Usuario u = new Usuario();
        u.setMiId(1);
        when(usuarioRepo.findByMiId(1)).thenReturn(u);

        Usuario resultado = usuarioService.obtenerPorMiId(1);
        assertNotNull(resultado);
        assertEquals(1, resultado.getMiId());
        verify(usuarioRepo, times(1)).findByMiId(1);
    }

    @Test
    void obtenerPorId() {
        Usuario u = new Usuario();
        u.setId("abc");
        when(usuarioRepo.findById("abc")).thenReturn(Optional.of(u));

        Usuario resultado = usuarioService.obtenerPorId("abc");
        assertNotNull(resultado);
        assertEquals("abc", resultado.getId());

        when(usuarioRepo.findById("def")).thenReturn(Optional.empty());
        assertNull(usuarioService.obtenerPorId("def"));
    }

    @Test
    void obtenerPorNombre() {
        Usuario u = new Usuario();
        u.setNombre("Test");
        when(usuarioRepo.findByNombre("Test")).thenReturn(u);

        Usuario resultado = usuarioService.obtenerPorNombre("Test");
        assertNotNull(resultado);
        assertEquals("Test", resultado.getNombre());
    }

    @Test
    void borrarPorMiId() {
        doNothing().when(usuarioRepo).deleteByMiId(1);
        usuarioService.borrarPorMiId(1);
        verify(usuarioRepo, times(1)).deleteByMiId(1);
    }

    @Test
    void guardarNuevoUsuarioExito() {
        Usuario nuevo = new Usuario();
        nuevo.setNombre("Nuevo");

        Usuario ultimo = new Usuario();
        ultimo.setMiId(5);

        when(usuarioRepo.encontrarUltimoId()).thenReturn(ultimo);
        when(usuarioRepo.findByNombre("Nuevo")).thenReturn(null);
        when(usuarioRepo.save(any(Usuario.class))).thenReturn(nuevo);

        Usuario resultado = usuarioService.guardar(nuevo);
        assertEquals(6, nuevo.getMiId());
        assertNotNull(resultado);
        verify(usuarioRepo).save(nuevo);
    }

    @Test
    void guardarNuevoUsuarioSinUltimo() {
        Usuario nuevo = new Usuario();
        nuevo.setNombre("Nuevo");

        when(usuarioRepo.encontrarUltimoId()).thenReturn(null);
        when(usuarioRepo.findByNombre("Nuevo")).thenReturn(null);
        when(usuarioRepo.save(any(Usuario.class))).thenReturn(nuevo);

        Usuario resultado = usuarioService.guardar(nuevo);
        assertEquals(1, nuevo.getMiId());
        assertNotNull(resultado);
        verify(usuarioRepo).save(nuevo);
    }

    @Test
    void guardarNuevoUsuarioNombreExistenteLanzaExcepcion() {
        Usuario nuevo = new Usuario();
        nuevo.setNombre("Existente");

        Usuario existente = new Usuario();
        existente.setNombre("Existente");

        when(usuarioRepo.encontrarUltimoId()).thenReturn(null);
        when(usuarioRepo.findByNombre("Existente")).thenReturn(existente);

        assertThrows(IllegalArgumentException.class, () -> usuarioService.guardar(nuevo));
        verify(usuarioRepo, never()).save(any(Usuario.class));
    }

    @Test
    void actualizarUsuarioExistenteExito() {
        Usuario aActualizar = new Usuario();
        aActualizar.setId("1");
        aActualizar.setNombre("Actualizado");

        when(usuarioRepo.findByNombre("Actualizado")).thenReturn(null);
        when(usuarioRepo.save(any(Usuario.class))).thenReturn(aActualizar);

        Usuario resultado = usuarioService.guardar(aActualizar);
        assertNotNull(resultado);
        verify(usuarioRepo).save(aActualizar);
    }

    @Test
    void actualizarUsuarioConNombreDeOtroLanzaExcepcion() {
        Usuario aActualizar = new Usuario();
        aActualizar.setId("1");
        aActualizar.setNombre("Ocupado");

        Usuario otro = new Usuario();
        otro.setId("2");
        otro.setNombre("Ocupado");

        when(usuarioRepo.findByNombre("Ocupado")).thenReturn(otro);

        assertThrows(IllegalArgumentException.class, () -> usuarioService.guardar(aActualizar));
        verify(usuarioRepo, never()).save(any(Usuario.class));
    }

    @Test
    void actualizarUsuarioConSuMismoNombreExito() {
        Usuario aActualizar = new Usuario();
        aActualizar.setId("1");
        aActualizar.setNombre("Mismo");

        Usuario mismo = new Usuario();
        mismo.setId("1");
        mismo.setNombre("Mismo");

        when(usuarioRepo.findByNombre("Mismo")).thenReturn(mismo);
        when(usuarioRepo.save(any(Usuario.class))).thenReturn(aActualizar);

        Usuario resultado = usuarioService.guardar(aActualizar);
        assertNotNull(resultado);
        verify(usuarioRepo).save(aActualizar);
    }
}
