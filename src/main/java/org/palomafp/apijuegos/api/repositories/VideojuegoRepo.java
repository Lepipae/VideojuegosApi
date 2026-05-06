package org.palomafp.apijuegos.api.repositories;

import org.palomafp.apijuegos.api.modelo.Videojuego;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VideojuegoRepo extends MongoRepository<Videojuego, String> {
    public Videojuego findByMiId(long miId);
    public Videojuego findByNombre(String nombre);
    public void deleteByMiId(long miId);
}
