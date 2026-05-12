package org.palomafp.apijuegos.api.services;

import org.palomafp.apijuegos.api.modelo.Desarrolladora;
import org.palomafp.apijuegos.api.repositories.DesarrolladoraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesarrolladoraService {

    @Autowired
    private DesarrolladoraRepo desarrolladoraRepo;

    public List<Desarrolladora> obtenerDesarrolladoras() {
        return desarrolladoraRepo.findAll();
    }

    public Desarrolladora obtenerPorNombre(String nombre) {
        return desarrolladoraRepo.findByNombre(nombre);
    }

    public Desarrolladora obtenerPorId(int id) {
        return desarrolladoraRepo.findByMiId(id);
    }

    public Desarrolladora guardar(Desarrolladora desarrolladora) {
        if (desarrolladora.getId() == null) {
            Desarrolladora ultimo = desarrolladoraRepo.encontrarUltimoId();
            int nuevoId = (ultimo != null) ? ultimo.getMiId() + 1 : 1;
            desarrolladora.setMiId(nuevoId);
        }
        return desarrolladoraRepo.save(desarrolladora);
    }

    public void borrarDesarrolladora(int id) {
        desarrolladoraRepo.deleteByMiId(id);
    }
}
