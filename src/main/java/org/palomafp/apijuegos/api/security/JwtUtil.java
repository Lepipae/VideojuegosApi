package org.palomafp.apijuegos.api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Clase utilitaria para manejar la creación y validación de tokens JWT.
 * Se encarga de generar el token cuando un usuario hace login y de verificar
 * si un token es válido cuando hace una petición.
 * @author Andrés López
 */
@Component
public class JwtUtil {

    // Clave secreta para firmar el token JWT. En un entorno de producción, esto debería estar en variables de entorno o application.properties.
    // Esta cadena debe tener al menos 256 bits (32 caracteres).
    private final String SECRET_KEY = "EstaEsUnaClaveSecretaMuyLargaYSeguraParaNuestraApiDeVideojuegos123!";

    /**
     * Obtiene la clave secreta generada a partir de la cadena de texto para firmar o validar tokens.
     * @return La clave criptográfica para JWT.
     */
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(java.util.Base64.getEncoder().encodeToString(SECRET_KEY.getBytes()));
        return Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Extrae el nombre de usuario (subject) contenido dentro del token JWT.
     * @param token Token proporcionado por el usuario.
     * @return Nombre de usuario que está dentro del token.
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extrae la fecha de expiración contenida dentro del token JWT.
     * @param token Token proporcionado por el usuario.
     * @return Fecha en la que caduca el token.
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Método genérico para extraer información específica (claim) del token.
     * @param token El token JWT a procesar.
     * @param claimsResolver Función para procesar y extraer un claim en concreto.
     * @param <T> Tipo del dato devuelto.
     * @return Valor del claim solicitado.
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Descifra el token y obtiene toda la información (claims) en su interior usando la clave secreta.
     * @param token Token proporcionado.
     * @return Objeto Claims con todos los datos del token.
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    /**
     * Verifica si el token ha caducado.
     * @param token Token a comprobar.
     * @return true si la fecha de expiración es anterior al momento actual.
     */
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Genera un nuevo token JWT a partir de los detalles de un usuario.
     * @param userDetails Objeto con la información del usuario autenticado.
     * @return Una cadena de texto que representa el token firmado.
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        // Puedes agregar más información al token aquí si lo deseas
        return createToken(claims, userDetails.getUsername());
    }

    /**
     * Método auxiliar encargado de la construcción interna del token con la librería JJWT.
     * @param claims Información adicional a inyectar.
     * @param subject El nombre de usuario que será el sujeto del token.
     * @return El token JWT en formato String.
     */
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .issuedAt(new Date(System.currentTimeMillis()))
                // El token expira en 10 horas desde su creación
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(getSigningKey())
                .compact();
    }

    /**
     * Verifica que el token pertenece al usuario y que además no ha expirado.
     * @param token Token de la petición.
     * @param userDetails Datos del usuario encontrados en la base de datos.
     * @return true si el token es totalmente válido para ese usuario.
     */
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
