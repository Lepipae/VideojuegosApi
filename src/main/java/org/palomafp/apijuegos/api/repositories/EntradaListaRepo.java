package org.palomafp.apijuegos.api.repositories;

import org.palomafp.apijuegos.api.modelo.EntradaLista;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntradaListaRepo extends MongoRepository<EntradaLista, String> {
    EntradaLista findByIdUsuario(long id);
}
