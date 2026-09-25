package com.example.mesa_facil_api.repositorio;

import com.example.mesa_facil_api.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepositorio extends JpaRepository<OrderModel, Long> {

    List<OrderModel> findByTableId(Long tableId);
}