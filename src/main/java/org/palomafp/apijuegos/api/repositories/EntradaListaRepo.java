package org.palomafp.apijuegos.api.repositories;

import org.palomafp.apijuegos.api.modelo.EntradaLista;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EntradaListaRepo extends MongoRepository<EntradaLista, String> {
    List<EntradaLista> findByIdUsuario(int id);

    EntradaLista findByMiId(long id);
}
