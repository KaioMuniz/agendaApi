package br.com.cotiinformatica.components;

import java.util.UUID;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtTokenComponent {

	private final String secretKey = "d6532013-ddc6-4dea-89ff-8f961f586a34";

	/*
	 * Método para extrair o "name" do token JWT (normalmente o ID ou nome do usuário)
	 */
	public UUID getUser(HttpServletRequest request) {
		try {
			// Obter o cabeçalho Authorization
			String authorization = request.getHeader("Authorization");
			if (authorization == null || !authorization.startsWith("Bearer ")) {
				return null;
			}

			// Extrair o token (remove o "Bearer ")
			String token = authorization.replace("Bearer ", "");

			// Parse do token
			Claims claims = Jwts.parser()
				.setSigningKey(secretKey.getBytes())
				.parseClaimsJws(token)
				.getBody();

			// Retornar a claim "name" (ou outra, conforme usado no JWT)
			var user = claims.get("name", String.class);
			return UUID.fromString(user);
		} catch (Exception e) {
			// Token inválido ou ausente
			return null;
		}
	}
}
