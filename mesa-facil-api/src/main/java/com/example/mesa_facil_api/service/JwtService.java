package com.example.mesa_facil_api.service;

import com.example.mesa_facil_api.config.security.AuthenticatedUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtEncoder jwtEncoder;

    @Value("${jwt.time.minutes.exp}")
    private int jwtTimeMinutes;

    public String createToken(Authentication authentication) {
        Instant now = Instant.now();
        Instant expiresAt = now.plusSeconds(60L * jwtTimeMinutes);

        String scope = authentication
                .getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        var authenticatedUser = (AuthenticatedUser) authentication.getPrincipal();

        assert authenticatedUser != null;
        var claims = JwtClaimsSet.builder()
                .issuedAt(now)
                .expiresAt(expiresAt)
                .issuer("com.example.mesa_facil_api")
                .subject(authenticatedUser.getUsername())
                .claims(createClaims(authenticatedUser, scope))
                .build();

        return jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }

    private Consumer<Map<String, Object>> createClaims(AuthenticatedUser authenticatedUser, String scope) {
        var usuario = authenticatedUser.usuario();

        return claims -> {
            claims.put("user", usuario.getId());
            claims.put("name", usuario.getName());
            claims.put("email", usuario.getEmail());
            claims.put("scope", scope);
        };
    }
}
