package org.palomafp.apijuegos.api.controladores;

import org.palomafp.apijuegos.api.modelo.EntradaLista;
import org.palomafp.apijuegos.api.repositories.EntradaListaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lista")
public class EntradaListaController {
    @Autowired
    private EntradaListaRepo entradaListaRepo;

    @GetMapping("/{miId}")
    public List<EntradaLista> findByIdUsuario(@PathVariable("miId") int id) {
        return entradaListaRepo.findByIdUsuario(id);
    }

    @GetMapping("/id/{id}")
    public EntradaLista findById(@PathVariable("id") long id) {
        return entradaListaRepo.findByMiId(id);
    }

    @DeleteMapping("/{miId}")
    public void borrarEntrada(@PathVariable("miId") int id) {
        entradaListaRepo.deleteByMiId(id);
    }

    @PostMapping
    public EntradaLista guardar(@RequestBody EntradaLista entradaLista) {
        return entradaListaRepo.save(entradaLista);
    }


}
