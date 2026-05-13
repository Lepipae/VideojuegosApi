package org.palomafp.apijuegos.api.modelo.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EstadoTest {

    @Test
    void testValores() {
        assertEquals(3, Estado.values().length);
        assertEquals(Estado.noEmpezado, Estado.valueOf("noEmpezado"));
        assertEquals(Estado.empezado, Estado.valueOf("empezado"));
        assertEquals(Estado.terminado, Estado.valueOf("terminado"));
    }
}
