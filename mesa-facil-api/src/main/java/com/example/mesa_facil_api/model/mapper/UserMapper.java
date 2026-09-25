package com.example.mesa_facil_api.model.mapper;


import com.example.mesa_facil_api.model.UserModel;
import com.example.mesa_facil_api.model.dto.UserDtoReq;
import com.example.mesa_facil_api.model.dto.UserDtoRes;
import com.example.mesa_facil_api.model.dto.UserUpdateDtoReq;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final PasswordEncoder passwordEncoder;

    public UserModel toEntity(UserDtoReq dto) {
        return UserModel.builder()
                .name(dto.name())
                .email(dto.email())
                .passwordHash(passwordEncoder.encode(dto.password()))
                .build();
    }

    public UserDtoRes toResponseDTO(UserModel entity) {
        return UserDtoRes.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .role(String.valueOf(entity.getRole()))
                .createdAt(entity.getCreated_at())
                .updatedAt(entity.getUpdated_at())
                .build();
    }

    public void updateEntityFromDTO(UserModel entity, UserUpdateDtoReq dto) {
        entity.setName(dto.name());
        entity.setEmail(dto.email());
        if (dto.password() != null && !dto.password().isEmpty()) {
            entity.setPasswordHash(passwordEncoder.encode(dto.password()));
        }
    }
}
