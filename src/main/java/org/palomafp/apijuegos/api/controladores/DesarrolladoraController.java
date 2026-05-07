package org.palomafp.apijuegos.api.controladores;

import org.palomafp.apijuegos.api.modelo.Desarrolladora;
import org.palomafp.apijuegos.api.repositories.DesarrolladoraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/desarrolladora")
public class DesarrolladoraController {

    @Autowired
    private DesarrolladoraRepo desarrolladoraRepo;

    @GetMapping
    public List<Desarrolladora> obtenerDesarrolladoras() {
        return desarrolladoraRepo.findAll();
    }

    @GetMapping("/nombre/{nombre}")
    public Desarrolladora obtenerPorNombre(String nombre) {
        return desarrolladoraRepo.findByNombre(nombre);
    }

    @GetMapping("/id/{id}")
    public Desarrolladora obtenerPorId(int id) {
        return desarrolladoraRepo.findByMiId(id);
    }

    @PostMapping
    public Desarrolladora guardar(@RequestBody Desarrolladora desarrolladora) {
        return desarrolladoraRepo.save(desarrolladora);
    }

    @DeleteMapping("/{id}")
    public void borrarDesarrolladora(@PathVariable int id) {
        desarrolladoraRepo.deleteByMiId(id);
    }
}
