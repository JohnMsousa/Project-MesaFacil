package com.example.mesa_facil_api.service;

import com.example.mesa_facil_api.config.security.AuthenticatedUser;
import com.example.mesa_facil_api.model.dto.LoginDtoReq;
import com.example.mesa_facil_api.model.dto.TokenDtoRes;
import com.example.mesa_facil_api.repositorio.UserRepositorio;
import com.example.mesa_facil_api.shared.exception.CredenciaisInvalidasException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserDetailsService userDetailsService;
    private final UserRepositorio usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public TokenDtoRes autenticar(LoginDtoReq Dto) {
        var userDetails = userDetailsService.loadUserByUsername(Dto.email());
        if (!(userDetails instanceof AuthenticatedUser usuario)){
            throw new CredenciaisInvalidasException("Usuário inválido!");
        }

        if (!passwordEncoder.matches(Dto.password(), usuario.getPassword())) {
            throw new CredenciaisInvalidasException("Usuário ou senha inválidos!");
        }

        var autenticacao = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
        return new TokenDtoRes(jwtService.createToken(autenticacao));
    }

    public AuthenticatedUser resgatarUsuarioLogado() {
        var email = SecurityContextHolder.getContext().getAuthentication().getName();
        var user = usuarioRepository.findByEmail(email).orElseThrow(EntityNotFoundException::new);
        return new AuthenticatedUser(user);
    }
}