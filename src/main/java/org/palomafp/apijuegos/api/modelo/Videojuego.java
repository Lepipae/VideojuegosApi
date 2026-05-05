package org.palomafp.apijuegos.api.modelo;

import java.util.ArrayList;

public class Videojuego {
    private long id;
    private String nombre;
    private String descripcion;
    private String urlImagen;
    private double notaMedia;
    private ArrayList<String> tags;

    public Videojuego(long id, String nombre, String descripcion, String urlImagen, double notaMedia, ArrayList<String> tags) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.notaMedia = notaMedia;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es requerido");
        }
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    public void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
