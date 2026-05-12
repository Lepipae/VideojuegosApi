package org.palomafp.apijuegos.api.services;

import org.palomafp.apijuegos.api.modelo.EntradaLista;
import org.palomafp.apijuegos.api.repositories.EntradaListaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaListaService {

    @Autowired
    private EntradaListaRepo entradaListaRepo;

    public List<EntradaLista> findByIdUsuario(int id) {
        return entradaListaRepo.findByIdUsuario(id);
    }

    public EntradaLista findById(long id) {
        return entradaListaRepo.findByMiId(id);
    }

    public void borrarEntrada(int id) {
        entradaListaRepo.deleteByMiId(id);
    }

    public EntradaLista guardar(EntradaLista entradaLista) {
        return entradaListaRepo.save(entradaLista);
    }
}
