package com.example.mesa_facil_api.service;

import com.example.mesa_facil_api.config.security.AuthenticatedUser;
import com.example.mesa_facil_api.repositorio.UserRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepositorio usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var usuario = this.usuarioRepository.findByEmail(username).orElseThrow(
                () -> new UsernameNotFoundException("Usuário não cadastrado"));
        return new AuthenticatedUser(usuario);
    }
}