package com.example.mesa_facil_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mesa_facil_api.model.dto.TableDtoReq;
import com.example.mesa_facil_api.model.dto.TableDtoRes;
import com.example.mesa_facil_api.model.mapper.TableMapper;
import com.example.mesa_facil_api.repositorio.TableRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TableService {
    private final TableRepositorio tableRepositorio;
    private final TableMapper mapper;
    
    public TableDtoRes createTable (TableDtoReq dto) {
        var table = mapper.toEntity(dto);
        return mapper.toResponse(tableRepositorio.save(table));
    }

    public List<TableDtoRes> listTable () {
        var listTable = tableRepositorio.findAll();
        return listTable.stream()
            .map(i -> mapper.toResponse(i))
            .toList();
    }

    public TableDtoRes findByidTable(Long id) {
        var table = tableRepositorio.findById(id)
        .orElseThrow();
        return mapper.toResponse(table);
    }
}
