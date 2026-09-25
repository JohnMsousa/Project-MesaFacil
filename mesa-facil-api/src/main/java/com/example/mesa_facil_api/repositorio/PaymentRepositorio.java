package com.example.mesa_facil_api.repositorio;

import com.example.mesa_facil_api.model.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepositorio extends JpaRepository<PaymentModel, Long> {

    List<PaymentModel> findByOrderId(Long orderId);
}