package com.example.mesa_facil_api.repositorio;

import com.example.mesa_facil_api.model.TableModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepositorio extends JpaRepository<TableModel, Long> {
}