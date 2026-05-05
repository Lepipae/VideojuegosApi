package org.palomafp.apijuegos.api.modelo;

import org.palomafp.apijuegos.api.modelo.enums.Rol;

public class Usuario {
    private String nombre;
    private String urlImagen;
    private String contrasenia;
    private Rol rol;

    public Usuario(String nombre, String urlImagen, String contrasenia, Rol rol) {
        setNombre(nombre);
        setUrlImagen(urlImagen);
        setContrasenia(contrasenia);
        setRol(rol);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        if (urlImagen == null || urlImagen.isBlank()) {
            this.urlImagen = "placeholder";
        } else {
            this.urlImagen = urlImagen;
        }
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        if (contrasenia == null || contrasenia.isBlank() || contrasenia.length() < 8) {
            throw new IllegalArgumentException("Contraseña no valida");
        }
        this.contrasenia = contrasenia;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
