package org.palomafp.apijuegos.api.modelo;

import org.palomafp.apijuegos.api.modelo.enums.Estado;

public class EntradaLista {
    private long id;
    private int horasJugadas;
    private double nota;
    private String resenya;
    private Estado estado;
    private Videojuego videojuego;
    private Usuario usuario;

    public EntradaLista(long id, int horasJugadas, double nota, String resenya, Estado estado, long idVideojuego, int usuario) {
        setId(id);
        setHorasJugadas(horasJugadas);
        setNota(nota);
        setResenya(resenya);
        setEstado(estado);
        setVideojuego(idVideojuego);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {

    }



}
