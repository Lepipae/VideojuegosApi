package org.palomafp.apijuegos.api.modelo;

import org.springframework.data.annotation.Id;

public class Desarrolladora {
    @Id
    private String id;

    private int miId;
    private String urlImagen;
    private String nombre;
    private String pais;

    public Desarrolladora() {}

    public Desarrolladora(String id, String pais, String nombre, String urlImagen, int miId) {
        this.id = id;
        setPais(pais);
        setNombre(nombre);
        setUrlImagen(urlImagen);
        setMiId(miId);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getMiId() {
        return miId;
    }

    public void setMiId(int miId) {
        this.miId = miId;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        if (urlImagen == null || urlImagen.isBlank()) {
            this.urlImagen = "placeholder";
        }
        this.urlImagen = urlImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre no valido");
        }
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        if (pais == null || pais.isBlank()) {
            throw new IllegalArgumentException("El pais es necesario");
        }
        this.pais = pais;
    }
}
