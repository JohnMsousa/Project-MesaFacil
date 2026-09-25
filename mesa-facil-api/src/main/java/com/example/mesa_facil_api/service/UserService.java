package com.example.mesa_facil_api.service;

import com.example.mesa_facil_api.model.UserModel;
import com.example.mesa_facil_api.model.dto.UserDtoReq;
import com.example.mesa_facil_api.model.dto.UserDtoRes;
import com.example.mesa_facil_api.model.dto.UserUpdateDtoReq;
import com.example.mesa_facil_api.model.mapper.UserMapper;
import com.example.mesa_facil_api.repositorio.UserRepositorio;
import com.example.mesa_facil_api.shared.exception.EmailJaCadastradoException;
import com.example.mesa_facil_api.shared.exception.UsuarioNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {

    private final UserRepositorio userRepository;
    private final UserMapper usuarioMapper;
    private final AuthenticationService authenticationService;

    public UserDtoRes createUser(UserDtoReq dto) {
        validarEmailUnico(dto.email(), null);

        var entity = usuarioMapper.toEntity(dto);

        var savedEntity = userRepository.save(entity);

        return usuarioMapper.toResponseDTO(savedEntity);
    }

    public UserDtoRes update(Long id, UserUpdateDtoReq dto) {

        var entity = buscarPorIdOuLancarExcecao(id);
        validarEmailUnico(dto.email(), id);

        usuarioMapper.updateEntityFromDTO(entity, dto);
        var updatedEntity = userRepository.save(entity);

        return usuarioMapper.toResponseDTO(updatedEntity);
    }

    public UserDtoRes findById(Long id) {
        var entity = buscarPorIdOuLancarExcecao(id);
        return usuarioMapper.toResponseDTO(entity);
    }


    private UserModel buscarPorIdOuLancarExcecao(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException("Usuário não encontrado com ID: " + id));
    }

    private void validarEmailUnico(String email, Long idUsuarioAtual) {
        userRepository.findByEmail(email).ifPresent(usuario -> {
            if (!usuario.getId().equals(idUsuarioAtual)) {
                throw new EmailJaCadastradoException("Email já cadastrado: " + email);
            }
        });
    }
}
