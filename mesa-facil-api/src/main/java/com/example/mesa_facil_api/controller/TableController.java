package com.example.mesa_facil_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mesa_facil_api.model.dto.TableDtoReq;
import com.example.mesa_facil_api.model.dto.TableDtoRes;
import com.example.mesa_facil_api.service.TableService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/api/tables")
@RequiredArgsConstructor
public class TableController {

    private final TableService tableService;
    
    @PostMapping
    public ResponseEntity<TableDtoRes> createTable (@RequestBody TableDtoReq dto) {
        return ResponseEntity.ok(tableService.createTable(dto));
    }

    @GetMapping 
    public ResponseEntity<List<TableDtoRes>> listTable () {
        return ResponseEntity.ok(tableService.listTable());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TableDtoRes> listTable (@PathVariable Long id) {
        return ResponseEntity.ok(tableService.findByidTable(id));
    }

    
}
