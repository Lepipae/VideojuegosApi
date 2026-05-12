package org.palomafp.apijuegos.api.repositories;

import org.palomafp.apijuegos.api.modelo.Videojuego;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideojuegoRepo extends MongoRepository<Videojuego, String> {
    Videojuego findByMiId(long miId);
    Videojuego findByNombre(String nombre);
    List<Videojuego> findByTags(String tags);
    List<Videojuego> findByIdDesarrolladora(int idDesarrolladora);
    void deleteByMiId(long miId);
    
    Videojuego findTopByOrderByMiIdDesc();
    
    default Videojuego encontrarUltimoId() {
        return findTopByOrderByMiIdDesc();
    }
}
