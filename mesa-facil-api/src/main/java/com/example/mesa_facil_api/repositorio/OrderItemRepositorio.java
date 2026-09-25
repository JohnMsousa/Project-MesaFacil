package com.example.mesa_facil_api.repositorio;

import com.example.mesa_facil_api.model.OrderItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OrderItemRepositorio extends JpaRepository<OrderItemModel, Long> {

    List<OrderItemModel> findByStatusIn(Collection<String> statuses);
}