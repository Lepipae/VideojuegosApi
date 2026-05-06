package org.palomafp.apijuegos.api.modelo;

import org.palomafp.apijuegos.api.modelo.enums.Estado;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "EntradaLista")
public class EntradaLista {
    @Id
    private String id;

    private long miId;
    private int horasJugadas;
    private double nota;
    private String resenya;
    private Estado estado;
    private long idVideojuego;
    private int idUsuario;


    public EntradaLista(long miId, int horasJugadas, double nota, String resenya, Estado estado, int idVideojuego, int idUsuario) {
        setMiId(miId);
        setHorasJugadas(horasJugadas);
        setNota(nota);
        setResenya(resenya);
        setEstado(estado);
        setIdVideojuego(idVideojuego);
        setIdUsuario(idUsuario);
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public long getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(long idVideojuego) {
        this.idVideojuego = idVideojuego;
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

    public int getHorasJugadas() {
        return horasJugadas;
    }

    public void setHorasJugadas(int horasJugadas) {
        if (horasJugadas < 0) {
            throw new IllegalArgumentException("Horas jugadas negativas");
        }
        this.horasJugadas = horasJugadas;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        if (nota < 0 || nota > 5) {
            throw new IllegalArgumentException("La nota debe de estar entre 0 y 5");
        }
        this.nota = nota;
    }

    public String getResenya() {
        return resenya;
    }

    public void setResenya(String resenya) {
        this.resenya = resenya;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }




}
