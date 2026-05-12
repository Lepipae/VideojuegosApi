package org.palomafp.apijuegos.api.controladores;

import org.palomafp.apijuegos.api.modelo.Videojuego;
import org.palomafp.apijuegos.api.services.VideojuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/videojuegos")
public class VideojuegoController {
    @Autowired
    private VideojuegoService videojuegoService;

    @GetMapping
    public List<Videojuego> obtenerTodos() {
        return videojuegoService.obtenerTodos();
    }

    @GetMapping("/{miId}")
    public Videojuego obtenerPorId(@PathVariable long miId) {
        return videojuegoService.obtenerPorId(miId);
    }

    @GetMapping("/nombre/{nombre}")
    public Videojuego obtenerPorNombre(@PathVariable String nombre) {
        return videojuegoService.obtenerPorNombre(nombre);
    }

    @GetMapping("/tag/{tag}")
    public List<Videojuego> obtenerPorTags(@PathVariable String tag) {
        return videojuegoService.obtenerPorTags(tag);
    }

    @GetMapping("/desarrolladora/{desarrollador}")
    public List<Videojuego> obtenerPorDesarrolladora(@PathVariable int desarrollador) {
        return videojuegoService.obtenerPorDesarrolladora(desarrollador);
    }

    @PostMapping
    public Videojuego guardar(@RequestBody Videojuego videojuego) {
        return videojuegoService.guardar(videojuego);
    }

    @DeleteMapping("/{miId}")
    public void borrarVideojuego(@RequestBody long miId) {
        videojuegoService.borrarVideojuego(miId);
    }

}
