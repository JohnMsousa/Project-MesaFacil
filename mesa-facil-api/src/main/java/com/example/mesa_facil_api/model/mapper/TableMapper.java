package com.example.mesa_facil_api.model.mapper;

import org.springframework.stereotype.Component;

import com.example.mesa_facil_api.model.TableModel;
import com.example.mesa_facil_api.model.dto.TableDtoReq;
import com.example.mesa_facil_api.model.dto.TableDtoRes;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TableMapper {

    public TableModel toEntity (TableDtoReq dto) {
        return TableModel.builder()
        .number(dto.number())
        .capacity(dto.capacity())
        .build();
    }

    public TableDtoRes toResponse (TableModel model) {
        return TableDtoRes.builder()
        .id(model.getId())
        .number(model.getNumber())
        .capacity(model.getCapacity())
        .build();

    }
    
}
