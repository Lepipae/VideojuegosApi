package org.palomafp.apijuegos.api.repositories;

import org.palomafp.apijuegos.api.modelo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repositorio para la clase Usuario
 * @author Andrés López de la Vía
 */
public interface UsuarioRepo extends MongoRepository<Usuario, String> {
    /**
     * Busca un usuario por su id interno
     * @param miId Id interno
     * @return Usuario encontrado o null
     */
    Usuario findByMiId(int miId);

    /**
     * Busca un usuario por su nombre
     * @param nombre Nombre del usuario
     * @return Usuario encontrado o null
     */
    Usuario findByNombre(String nombre);

    /**
     * Elimina un usuario por su id interno
     * @param miId Id interno
     */
    void deleteByMiId(int miId);

    /**
     * Encuentra el usuario con el id interno mas alto
     * @return Usuario con el id mas alto
     */
    Usuario findTopByOrderByMiIdDesc();
    
    /**
     * Devuelve el ultimo id utilizado
     * @return Usuario con el ultimo id
     */
    default Usuario encontrarUltimoId() {
        return findTopByOrderByMiIdDesc();
    }
}
