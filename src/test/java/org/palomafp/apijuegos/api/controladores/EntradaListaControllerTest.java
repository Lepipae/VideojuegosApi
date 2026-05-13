package org.palomafp.apijuegos.api.controladores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.palomafp.apijuegos.api.modelo.EntradaLista;
import org.palomafp.apijuegos.api.services.EntradaListaService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class EntradaListaControllerTest {

    @Mock
    private EntradaListaService entradaListaService;

    @InjectMocks
    private EntradaListaController entradaListaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findByIdUsuario() {
        EntradaLista e = new EntradaLista();
        when(entradaListaService.findByIdUsuario(1)).thenReturn(Arrays.asList(e));

        List<EntradaLista> result = entradaListaController.findByIdUsuario(1);
        assertEquals(1, result.size());
        verify(entradaListaService, times(1)).findByIdUsuario(1);
    }

    @Test
    void findById() {
        EntradaLista e = new EntradaLista();
        when(entradaListaService.findById(1L)).thenReturn(e);

        EntradaLista result = entradaListaController.findById(1L);
        assertNotNull(result);
        verify(entradaListaService, times(1)).findById(1L);
    }

    @Test
    void borrarEntrada() {
        doNothing().when(entradaListaService).borrarEntrada(1);
        entradaListaController.borrarEntrada(1);
        verify(entradaListaService, times(1)).borrarEntrada(1);
    }

    @Test
    void guardar() {
        EntradaLista e = new EntradaLista();
        when(entradaListaService.guardar(e)).thenReturn(e);

        EntradaLista result = entradaListaController.guardar(e);
        assertNotNull(result);
        verify(entradaListaService, times(1)).guardar(e);
    }
}
