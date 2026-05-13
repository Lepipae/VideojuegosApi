package org.palomafp.apijuegos.api.modelo.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RolTest {

    @Test
    void testValores() {
        assertEquals(2, Rol.values().length);
        assertEquals(Rol.administrador, Rol.valueOf("administrador"));
        assertEquals(Rol.usuarioNormal, Rol.valueOf("usuarioNormal"));
    }
}
