package org.palomafp.apijuegos.api.modelo;

import org.palomafp.apijuegos.api.modelo.enums.Rol;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class Usuario {
    @Id
    private String id;

    private int miId;
    private String nombre;
    private String urlImagen;
    private String contrasenia;
    private Rol rol;

    public Usuario() {
    }

    public Usuario(String nombre, String urlImagen, String contrasenia, Rol rol, int miId) {
        setNombre(nombre);
        setUrlImagen(urlImagen);
        setContrasenia(contrasenia);
        setRol(rol);
        setMiId(miId);
    }

    public void setMiId(int miId) {
        this.miId = miId;
    }

    public int getMiId() {
        return miId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
