package org.palomafp.apijuegos.api.services;

import org.palomafp.apijuegos.api.modelo.Videojuego;
import org.palomafp.apijuegos.api.repositories.VideojuegoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideojuegoService {

    @Autowired
    private VideojuegoRepo videojuegoRepo;

    public List<Videojuego> obtenerTodos() {
        return videojuegoRepo.findAll();
    }

    public Videojuego obtenerPorId(long idVideojuego) {
        return videojuegoRepo.findByMiId(idVideojuego);
    }

    public Videojuego obtenerPorNombre(String nombreVideojuego) {
        return videojuegoRepo.findByNombre(nombreVideojuego);
    }

    public List<Videojuego> obtenerPorTags(String tag) {
        return videojuegoRepo.findByTags(tag);
    }

    public List<Videojuego> obtenerPorDesarrolladora(int desarrolladora) {
        return videojuegoRepo.findByIdDesarrolladora(desarrolladora);
    }

    public Videojuego crearVideojuego(Videojuego videojuego) {
        Videojuego videojuegoViejo1 = videojuegoRepo.findById(videojuego.getId()).orElse(null);
        Videojuego videojuegoViejo2 = videojuegoRepo.findByNombre(videojuego.getNombre());
        if (videojuegoViejo1 != null || videojuegoViejo2 != null) {
            throw new IllegalArgumentException("Videojuego existente");
        } else {
            return videojuegoRepo.save(videojuego);
        }
    }

    public void borrarVideojuego(long id) {
        // TODO: asegurarse de que el juego se borra de las listas en las que esta
        videojuegoRepo.deleteByMiId(id);
    }
}
