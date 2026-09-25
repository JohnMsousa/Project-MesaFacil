package com.example.mesa_facil_api.repositorio;

import com.example.mesa_facil_api.model.AuditLogModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogRepositorio extends JpaRepository<AuditLogModel, Long> {
}