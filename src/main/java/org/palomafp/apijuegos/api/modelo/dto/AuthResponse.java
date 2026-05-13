package org.palomafp.apijuegos.api.modelo.dto;

/**
 * Data Transfer Object (DTO) para manejar las respuestas de inicio de sesión exitoso.
 * Contiene el token JWT generado para que el cliente lo utilice en futuras peticiones.
 * @author Andrés López
 */
public class AuthResponse {
    private String jwt;

    /**
     * Constructor con parámetros.
     * @param jwt Token JWT generado tras una autenticación exitosa.
     */
    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    /**
     * Obtiene el token JWT.
     * @return Token JWT.
     */
    public String getJwt() {
        return jwt;
    }

    /**
     * Establece el token JWT.
     * @param jwt Token a establecer.
     */
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
