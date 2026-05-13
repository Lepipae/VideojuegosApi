package org.palomafp.apijuegos.api.modelo.dto;

/**
 * Data Transfer Object (DTO) para manejar las peticiones de inicio de sesión (Login).
 * Contiene las credenciales enviadas por el usuario.
 * @author Andrés López
 */
public class AuthRequest {
    private String nombre;
    private String contrasenia;

    /**
     * Constructor vacío necesario para la serialización/deserialización de JSON.
     */
    public AuthRequest() {
    }

    /**
     * Constructor con parámetros.
     * @param nombre      Nombre de usuario proporcionado para el inicio de sesión.
     * @param contrasenia Contraseña proporcionada para el inicio de sesión.
     */
    public AuthRequest(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    /**
     * Obtiene el nombre de usuario.
     * @return Nombre de usuario.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de usuario.
     * @param nombre Nombre a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la contraseña.
     * @return Contraseña del usuario.
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * Establece la contraseña.
     * @param contrasenia Contraseña a establecer.
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
