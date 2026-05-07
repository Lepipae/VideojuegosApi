package org.palomafp.apijuegos.api.controladores;

import org.palomafp.apijuegos.api.modelo.Videojuego;
import org.palomafp.apijuegos.api.repositories.VideojuegoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/videojuegos")
public class VideojuegoController {
    @Autowired
    private VideojuegoRepo videojuegoRepo;

    @GetMapping
    public List<Videojuego> obtenerTodos() {
        return videojuegoRepo.findAll();
    }

    @GetMapping("/{miId}")
    public Videojuego obtenerPorId(@PathVariable long miId) {
        return videojuegoRepo.findByMiId(miId);
    }

    @GetMapping("/nombre/{nombre}")
    public Videojuego obtenerPorNombre(@PathVariable String nombre) {
        return videojuegoRepo.findByNombre(nombre);
    }

    @GetMapping("/tag/{tag}")
    public List<Videojuego> obtenerPorTags(@PathVariable String tag) {
        return videojuegoRepo.findByTags(tag);
    }

    @GetMapping("/desarrolladora/{desarrollador}")
    public List<Videojuego> obtenerPorDesarrolladora(@PathVariable int desarrollador) {
        return videojuegoRepo.findByIdDesarrolladora(desarrollador);
    }

    @PostMapping
    public Videojuego crearVideojuego(@RequestBody Videojuego videojuego) {
        return videojuegoRepo.save(videojuego);
    }

    @DeleteMapping("/{miId}")
    public void borrarVideojuego(@RequestBody long miId) {
        videojuegoRepo.deleteByMiId(miId);
    }

}
