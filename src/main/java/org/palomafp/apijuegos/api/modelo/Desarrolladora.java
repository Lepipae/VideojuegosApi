package org.palomafp.apijuegos.api.modelo;

public class Desarrolladora {
    private int id;
    private String urlImagen;
    private String nombre;
    private String pais;

    public Desarrolladora(String pais, String nombre, String urlImagen, int id) {
        this.pais = pais;
        this.nombre = nombre;
        this.urlImagen = urlImagen;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
