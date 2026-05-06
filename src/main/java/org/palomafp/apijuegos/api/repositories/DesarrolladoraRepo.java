package org.palomafp.apijuegos.api.repositories;

import org.palomafp.apijuegos.api.modelo.Desarrolladora;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DesarrolladoraRepo extends MongoRepository<Desarrolladora, String> {
    Desarrolladora findByMiId(int miId);
    Desarrolladora findByNombre(String nombre);
}
