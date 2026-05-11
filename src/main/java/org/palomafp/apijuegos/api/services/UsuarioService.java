package org.palomafp.apijuegos.api.services;

import org.palomafp.apijuegos.api.modelo.Usuario;
import org.palomafp.apijuegos.api.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    public List<Usuario> obtenerTodos() {
        return usuarioRepo.findAll();
    }

    public Usuario obtenerPorMiId(int id) {
        return usuarioRepo.findByMiId(id);
    }

    public Usuario obtenerPorId(String id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    public Usuario obtenerPorNombre(String nombre) {
        return usuarioRepo.findByNombre(nombre);
    }

    public Usuario guardarUsuario(Usuario usuario) {
        Usuario viejo1 = usuarioRepo.findByNombre(usuario.getNombre());
        Usuario viejo2 = usuarioRepo.findByMiId(usuario.getMiId());

        if (viejo1 != null || viejo2 != null) {
            throw new IllegalArgumentException("Usuario existente");
        } else {
            return usuarioRepo.save(usuario);
        }
    }

    public void borrarPorMiId(int id) {
        //TODO: Asegurarse de que se borran todos los juegos de la lista de este usuario

    }
}
