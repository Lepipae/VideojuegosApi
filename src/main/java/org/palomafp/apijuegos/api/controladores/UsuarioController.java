package org.palomafp.apijuegos.api.controladores;

import org.palomafp.apijuegos.api.modelo.Usuario;
import org.palomafp.apijuegos.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return usuarioService.obtenerTodos();
    }

    @GetMapping("/{miId}")
    public Usuario obtenerUsuarioPorId(@PathVariable int miId) {
        return usuarioService.obtenerPorMiId(miId);
    }

    @GetMapping("/nombre/{nombre}")
    public Usuario obtenerUsuarioPorNombre(@PathVariable String nombre) {
        return usuarioService.obtenerPorNombre(nombre);
    }

    @DeleteMapping
    public void borrarUsuarioPorMiId(@RequestBody int miId) {
        usuarioService.borrarPorMiId(miId);
    }

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.guardarUsuario(usuario);
    }


}
