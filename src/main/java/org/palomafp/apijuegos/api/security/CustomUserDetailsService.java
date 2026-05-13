package org.palomafp.apijuegos.api.security;

import org.palomafp.apijuegos.api.modelo.Usuario;
import org.palomafp.apijuegos.api.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Servicio encargado de proveer a Spring Security la información del usuario 
 * cargándola desde nuestra propia base de datos de MongoDB.
 * Implementa la interfaz UserDetailsService requerida por el entorno de Spring.
 * @author Andrés López
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepo usuarioRepo;

    /**
     * Este método es llamado automáticamente por Spring Security durante el proceso
     * de autenticación para comprobar si el usuario existe.
     * @param username Nombre del usuario ingresado.
     * @return Objeto UserDetails que usa Spring internamente.
     * @throws UsernameNotFoundException Si el usuario no existe en la base de datos.
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscamos el usuario en nuestro repositorio usando su nombre
        Usuario usuario = usuarioRepo.findByNombre(username);
        
        if (usuario == null) {
            // Lanzamos error si no lo encontramos
            throw new UsernameNotFoundException("Usuario no encontrado con el nombre: " + username);
        }

        // Devolvemos una instancia de "User" de Spring Security, pasando nombre, contraseña y permisos vacíos (o los roles si existen).
        // Si tienes roles en `Usuario` puedes inyectarlos aquí. Por defecto agregamos un ArrayList vacío de authorities.
        return new User(usuario.getNombre(), usuario.getContrasenia(), new ArrayList<>());
    }
}
