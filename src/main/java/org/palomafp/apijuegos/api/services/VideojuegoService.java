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

    public Videojuego guardar(Videojuego videojuego) {
        if (videojuego.getId() == null) {
            Videojuego ultimo = videojuegoRepo.encontrarUltimoId();
            long nuevoId = (ultimo != null) ? ultimo.getMiId() + 1 : 1;
            videojuego.setMiId(nuevoId);

            Videojuego videojuegoViejo = videojuegoRepo.findByNombre(videojuego.getNombre());
            if (videojuegoViejo != null) {
                throw new IllegalArgumentException("Videojuego existente");
            }
        } else {
            Videojuego videojuegoViejo = videojuegoRepo.findByNombre(videojuego.getNombre());
            if (videojuegoViejo != null && !videojuegoViejo.getId().equals(videojuego.getId())) {
                throw new IllegalArgumentException("Videojuego existente");
            }
        }
        return videojuegoRepo.save(videojuego);
    }

    @Autowired
    private EntradaListaService entradaListaService;

    public void borrarVideojuego(long id) {
        entradaListaService.borrarPorVideojuego(id);
        videojuegoRepo.deleteByMiId(id);
    }
}
