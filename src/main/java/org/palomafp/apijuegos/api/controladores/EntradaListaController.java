package org.palomafp.apijuegos.api.controladores;

import org.palomafp.apijuegos.api.modelo.EntradaLista;
import org.palomafp.apijuegos.api.services.EntradaListaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lista")
public class EntradaListaController {
    @Autowired
    private EntradaListaService entradaListaService;

    @GetMapping("/{miId}")
    public List<EntradaLista> findByIdUsuario(@PathVariable("miId") int id) {
        return entradaListaService.findByIdUsuario(id);
    }

    @GetMapping("/id/{id}")
    public EntradaLista findById(@PathVariable("id") long id) {
        return entradaListaService.findById(id);
    }

    @DeleteMapping("/{miId}")
    public void borrarEntrada(@PathVariable("miId") int id) {
        entradaListaService.borrarEntrada(id);
    }

    @PostMapping
    public EntradaLista guardar(@RequestBody EntradaLista entradaLista) {
        return entradaListaService.guardar(entradaLista);
    }


}
