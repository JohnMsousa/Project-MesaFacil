package com.example.mesa_facil_api.repositorio;

import com.example.mesa_facil_api.model.MenuItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepositorio extends JpaRepository<MenuItemModel, Long> {
}