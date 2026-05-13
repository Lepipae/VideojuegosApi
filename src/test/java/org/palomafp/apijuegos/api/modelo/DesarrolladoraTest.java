package org.palomafp.apijuegos.api.modelo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DesarrolladoraTest {

    @Test
    void testConstructorVacioYSetters() {
        Desarrolladora dev = new Desarrolladora();
        dev.setId("1");
        dev.setMiId(10);
        dev.setNombre("DevTest");
        dev.setPais("España");
        dev.setUrlImagen("img.png");

        assertEquals("1", dev.getId());
        assertEquals(10, dev.getMiId());
        assertEquals("DevTest", dev.getNombre());
        assertEquals("España", dev.getPais());
        assertEquals("img.png", dev.getUrlImagen());
    }

    @Test
    void testConstructorConParametros() {
        Desarrolladora dev = new Desarrolladora();
        dev.setMiId(20);
        dev.setNombre("Dev2");
        dev.setPais("Francia");
        dev.setUrlImagen("img2.png");

        assertEquals(20, dev.getMiId());
        assertEquals("Dev2", dev.getNombre());
        assertEquals("Francia", dev.getPais());
        assertEquals("img2.png", dev.getUrlImagen());
    }

    @Test
    void testSetNombreInvalido() {
        Desarrolladora dev = new Desarrolladora();
        assertThrows(IllegalArgumentException.class, () -> dev.setNombre(null));
        assertThrows(IllegalArgumentException.class, () -> dev.setNombre("   "));
    }

    @Test
    void testSetPaisInvalido() {
        Desarrolladora dev = new Desarrolladora();
        assertThrows(IllegalArgumentException.class, () -> dev.setPais(null));
        assertThrows(IllegalArgumentException.class, () -> dev.setPais("   "));
    }

    @Test
    void testSetUrlImagenInvalidaAsignaPlaceholder() {
        Desarrolladora dev = new Desarrolladora();
        dev.setUrlImagen(null);
        assertEquals("placeholder", dev.getUrlImagen());

        dev.setUrlImagen("   ");
        assertEquals("placeholder", dev.getUrlImagen());
    }
}
