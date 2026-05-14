package org.palomafp.apijuegos.api.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.NullMarked;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filtro que se ejecuta una vez por cada petición HTTP que entra a nuestra API.
 * Su objetivo es interceptar la petición, buscar el token JWT en la cabecera (Header),
 * validarlo y si está correcto, iniciar la sesión en el contexto de Spring Security.
 * @author Andrés López
 */
@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    @NullMarked
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        // Obtenemos la cabecera llamada "Authorization"
        final String authorizationHeader = request.getHeader("Authorization");

        String username = null;
        String jwt = null;

        // Comprobamos que la cabecera existe y que su contenido empiece por "Bearer " (estándar de JWT)
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7); // Extraemos solo el token (quitamos la palabra Bearer)
            try {
                // Sacamos el nombre de usuario de dentro del token
                username = jwtUtil.extractUsername(jwt);
            } catch (Exception e) {
                System.out.println("No se ha podido extraer el token JWT");
            }
        }

        // Si tenemos un usuario pero todavía no está validado en el contexto de seguridad...
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            // Cargamos los datos del usuario usando su nombre
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

            // Verificamos matemáticamente que el token concuerda con este usuario y que no haya caducado
            if (jwtUtil.validateToken(jwt, userDetails)) {

                // Si es válido, creamos un token interno de Spring Security para autorizar al usuario en este momento
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                
                // Añadimos detalles de la petición HTTP a este token de autenticación
                usernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                
                // Registramos al usuario como "Autenticado" para esta petición en particular.
                // Como es Stateless, esto se borrará tras devolver la respuesta al cliente.
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        
        // Continuamos con la cadena de filtros permitiendo que la petición siga su curso (hacia el controlador)
        chain.doFilter(request, response);
    }
}
