package com.example.mesa_facil_api.controller;

import com.example.mesa_facil_api.model.dto.LoginDtoReq;
import com.example.mesa_facil_api.model.dto.TokenDtoRes;
import com.example.mesa_facil_api.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthenticationControllerImpl{
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<TokenDtoRes> autenticar(@RequestBody LoginDtoReq dto) {
        return ResponseEntity.ok(authenticationService.autenticar(dto));
    }
}

