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

    public Usuario guardar(Usuario usuario) {
        if (usuario.getId() == null) {
            Usuario ultimo = usuarioRepo.encontrarUltimoId();
            int nuevoId = (ultimo != null) ? ultimo.getMiId() + 1 : 1;
            usuario.setMiId(nuevoId);

            Usuario viejo1 = usuarioRepo.findByNombre(usuario.getNombre());
            if (viejo1 != null) {
                throw new IllegalArgumentException("Usuario existente");
            }
        } else {
            Usuario viejo1 = usuarioRepo.findByNombre(usuario.getNombre());
            if (viejo1 != null && !viejo1.getId().equals(usuario.getId())) {
                throw new IllegalArgumentException("Usuario existente");
            }
        }
        return usuarioRepo.save(usuario);
    }

    public void borrarPorMiId(int id) {
        //TODO: Asegurarse de que se borran todos los juegos de la lista de este usuario
        usuarioRepo.deleteByMiId(id);
    }
}
