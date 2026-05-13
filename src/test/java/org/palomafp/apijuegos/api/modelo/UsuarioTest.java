package org.palomafp.apijuegos.api.modelo;

import org.junit.jupiter.api.Test;
import org.palomafp.apijuegos.api.modelo.enums.Rol;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void testConstructorVacioYSetters() {
        Usuario usuario = new Usuario();
        usuario.setId("123");
        usuario.setMiId(1);
        usuario.setNombre("TestUser");
        usuario.setUrlImagen("http://imagen.com");
        usuario.setContrasenia("12345678");
        usuario.setRol(Rol.usuarioNormal);

        assertEquals("123", usuario.getId());
        assertEquals(1, usuario.getMiId());
        assertEquals("TestUser", usuario.getNombre());
        assertEquals("http://imagen.com", usuario.getUrlImagen());
        assertEquals("12345678", usuario.getContrasenia());
        assertEquals(Rol.usuarioNormal, usuario.getRol());
    }

    @Test
    void testConstructorConParametros() {
        Usuario usuario = new Usuario("TestUser", "http://imagen.com", "12345678", Rol.administrador, 2);

        assertEquals("TestUser", usuario.getNombre());
        assertEquals("http://imagen.com", usuario.getUrlImagen());
        assertEquals("12345678", usuario.getContrasenia());
        assertEquals(Rol.administrador, usuario.getRol());
        assertEquals(2, usuario.getMiId());
    }

    @Test
    void testSetNombreInvalido() {
        Usuario usuario = new Usuario();
        assertThrows(IllegalArgumentException.class, () -> usuario.setNombre(null));
        assertThrows(IllegalArgumentException.class, () -> usuario.setNombre("   "));
    }

    @Test
    void testSetUrlImagenVaciaAsignaPlaceholder() {
        Usuario usuario = new Usuario();
        usuario.setUrlImagen(null);
        assertEquals("placeholder", usuario.getUrlImagen());

        usuario.setUrlImagen("  ");
        assertEquals("placeholder", usuario.getUrlImagen());
    }

    @Test
    void testSetContraseniaInvalida() {
        Usuario usuario = new Usuario();
        assertThrows(IllegalArgumentException.class, () -> usuario.setContrasenia(null));
        assertThrows(IllegalArgumentException.class, () -> usuario.setContrasenia("   "));
        assertThrows(IllegalArgumentException.class, () -> usuario.setContrasenia("1234567")); // longitud < 8
    }
}
