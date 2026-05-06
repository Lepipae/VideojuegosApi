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
    private int idDesarrolladora;
    private ArrayList<String> tags;

    public  Videojuego(){}

    public Videojuego(String id, long miId, String nombre, String descripcion, String urlImagen, double notaMedia, ArrayList<String> tags, int idDesarrolladora) {
        this.id = id;
        setMiId(miId);
        setNombre(nombre);
        setDescripcion(descripcion);
        setUrlImagen(urlImagen);
        setNotaMedia(notaMedia);
        setTags(tags);
        setIdDesarrolladora(idDesarrolladora);
    }

    public void setIdDesarrolladora(int idDesarrolladora) {
        this.idDesarrolladora = idDesarrolladora;
    }

    public int getIdDesarrolladora() {
        return idDesarrolladora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getMiId() {
        return miId;
    }

    public void setMiId(long miId) {
        this.miId = miId;
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
