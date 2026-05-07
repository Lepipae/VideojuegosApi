package org.palomafp.apijuegos.api.controladores;

import org.palomafp.apijuegos.api.modelo.Usuario;
import org.palomafp.apijuegos.api.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepo usuarioRepo;

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioRepo.findAll();
    }

    @GetMapping("/{miI}")
    public Usuario obtenerUsuarioPorId(@PathVariable int miId) {
        return usuarioRepo.findByMiId(miId);
    }

    @GetMapping("/nombre/{nombre}")
    public Usuario obtenerUsuarioPorNombre(@PathVariable String nombre) {
        return usuarioRepo.findByNombre(nombre);
    }

    @DeleteMapping
    public void borrarUsuarioPorMiId(@RequestBody int miId) {
        usuarioRepo.deleteByMiId(miId);
    }

    @PostMapping
    public void guardarUsuario(@RequestBody Usuario usuario) {
        usuarioRepo.save(usuario);
    }


}
