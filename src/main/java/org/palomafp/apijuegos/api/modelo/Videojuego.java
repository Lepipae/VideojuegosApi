package org.palomafp.apijuegos.api.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
@Document(collection = "Videojuegos")
public class Videojuego {
    @Id
    private String id;

    private long miId;
    private String nombre;
    private String descripcion;
    private String urlImagen;
    private double notaMedia;
    private ArrayList<String> tags;

    public  Videojuego(){}

    public Videojuego(String id, long MiId, String nombre, String descripcion, String urlImagen, double notaMedia, ArrayList<String> tags) {
        this.id = id;
        setMiId(MiId);
        setNombre(nombre);
        setDescripcion(descripcion);
        setUrlImagen(urlImagen);
        setNotaMedia(notaMedia);
        setTags(tags);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getMiId() {
        return MiId;
    }

    public void setMiId(long miId) {
        this.MiId = miId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
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
