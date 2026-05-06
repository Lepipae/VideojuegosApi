package org.palomafp.apijuegos.api.repositories;

import org.palomafp.apijuegos.api.modelo.Videojuego;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideojuegoRepo extends MongoRepository<Videojuego, String> {
    Videojuego findByMiId(long miId);
    Videojuego findByNombre(String nombre);
    void deleteByMiId(long miId);
}
