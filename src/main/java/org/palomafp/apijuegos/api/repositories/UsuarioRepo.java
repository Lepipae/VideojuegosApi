package org.palomafp.apijuegos.api.repositories;

import org.palomafp.apijuegos.api.modelo.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepo extends MongoRepository<Usuario, String> {
    Usuario findByMiId(int miId);
    Usuario findByNombre(String nombre);
    void deleteByMiId(int miId);

    Usuario findTopByOrderByMiIdDesc();
    
    default Usuario encontrarUltimoId() {
        return findTopByOrderByMiIdDesc();
    }
}
