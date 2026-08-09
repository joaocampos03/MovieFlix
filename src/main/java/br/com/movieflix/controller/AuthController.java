package br.com.movieflix.controller;

import br.com.movieflix.controller.request.LoginRequest;
import br.com.movieflix.controller.request.UserRequest;
import br.com.movieflix.controller.response.LoginResponse;
import br.com.movieflix.controller.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Auth", description = "Recurso responsável pela autenticação de usuários.")
public interface AuthController {

    @Operation(summary = "Registrar usuário", description = "Método responsável por registrar um novo usuário.")
    @ApiResponse(responseCode = "201", description = "Usuário registrado com sucesso!", content = @Content(schema = @Schema(implementation = UserResponse.class)))
    ResponseEntity<UserResponse> register(@RequestBody UserRequest request);

    @Operation(summary = "Login", description = "Método responsável por autenticar um usuário e retornar o token de acesso.")
    @ApiResponse(responseCode = "200", description = "Login realizado com sucesso!", content = @Content(schema = @Schema(implementation = LoginResponse.class)))
    @ApiResponse(responseCode = "401", description = "Usuário ou senha inválido.", content = @Content())
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request);
}
