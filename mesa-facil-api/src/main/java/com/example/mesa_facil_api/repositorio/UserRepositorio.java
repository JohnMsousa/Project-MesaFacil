package com.example.mesa_facil_api.repositorio;

import com.example.mesa_facil_api.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositorio extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByEmail(String email);
}