package com.example.mesa_facil_api.repositorio;

import com.example.mesa_facil_api.model.ShiftModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShiftRepositorio extends JpaRepository<ShiftModel, Long> {

    Optional<ShiftModel> findByStatus(String status);
}