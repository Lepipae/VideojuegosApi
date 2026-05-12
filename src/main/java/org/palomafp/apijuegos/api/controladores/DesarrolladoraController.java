package org.palomafp.apijuegos.api.controladores;

import org.palomafp.apijuegos.api.modelo.Desarrolladora;
import org.palomafp.apijuegos.api.services.DesarrolladoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/desarrolladora")
public class DesarrolladoraController {

    @Autowired
    private DesarrolladoraService desarrolladoraService;

    @GetMapping
    public List<Desarrolladora> obtenerDesarrolladoras() {
        return desarrolladoraService.obtenerDesarrolladoras();
    }

    @GetMapping("/nombre/{nombre}")
    public Desarrolladora obtenerPorNombre(String nombre) {
        return desarrolladoraService.obtenerPorNombre(nombre);
    }

    @GetMapping("/id/{id}")
    public Desarrolladora obtenerPorId(int id) {
        return desarrolladoraService.obtenerPorId(id);
    }

    @PostMapping
    public Desarrolladora guardar(@RequestBody Desarrolladora desarrolladora) {
        return desarrolladoraService.guardar(desarrolladora);
    }

    @DeleteMapping("/{id}")
    public void borrarDesarrolladora(@PathVariable int id) {
        desarrolladoraService.borrarDesarrolladora(id);
    }
}
