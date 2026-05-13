package org.palomafp.apijuegos.api.repositories;

import org.palomafp.apijuegos.api.modelo.Videojuego;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la clase Videojuego
 * @author Andrés López
 */
@Repository
public interface VideojuegoRepo extends MongoRepository<Videojuego, String> {
    /**
     * Busca un videojuego por su id interno
     * @param miId Id interno
     * @return Videojuego encontrado o null
     */
    Videojuego findByMiId(long miId);

    /**
     * Busca un videojuego por su nombre
     * @param nombre Nombre del videojuego
     * @return Videojuego encontrado o null
     */
    Videojuego findByNombre(String nombre);

    /**
     * Busca videojuegos por un tag o categoria
     * @param tags Tag a buscar
     * @return Lista de videojuegos con el tag
     */
    List<Videojuego> findByTags(String tags);

    /**
     * Busca videojuegos creados por una desarrolladora
     * @param idDesarrolladora Id interno de la desarrolladora
     * @return Lista de videojuegos
     */
    List<Videojuego> findByIdDesarrolladora(int idDesarrolladora);

    /**
     * Elimina un videojuego por su id interno
     * @param miId Id interno
     */
    void deleteByMiId(long miId);
    
    /**
     * Encuentra el videojuego con el id interno mas alto
     * @return Videojuego con el id mas alto
     */
    Videojuego findTopByOrderByMiIdDesc();
    
    /**
     * Devuelve el ultimo id utilizado
     * @return Videojuego con el ultimo id
     */
    default Videojuego encontrarUltimoId() {
        return findTopByOrderByMiIdDesc();
    }
}
