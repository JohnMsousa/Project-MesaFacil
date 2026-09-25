package com.example.mesa_facil_api.controller;

import com.example.mesa_facil_api.model.dto.UserDtoReq;
import com.example.mesa_facil_api.model.dto.UserDtoRes;
import com.example.mesa_facil_api.model.dto.UserUpdateDtoReq;
import com.example.mesa_facil_api.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public ResponseEntity<UserDtoRes> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDtoRes> criar(@RequestBody UserDtoReq dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDtoRes> atualizar(@PathVariable Long id, @RequestBody UserUpdateDtoReq dto) {
        return ResponseEntity.ok(userService.update(id, dto));
    }

}
