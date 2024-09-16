package aplicacao.login_registro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aplicacao.login_registro.dto.LoginRequestDTO;
import aplicacao.login_registro.dto.RegistrarRequestDTO;
import aplicacao.login_registro.dto.ResponseDTO;
import aplicacao.login_registro.services.AuthService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO){
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }

    @PostMapping("/registrar")
    public ResponseEntity<ResponseDTO> registrar(@RequestBody RegistrarRequestDTO registrarRequestDTO){
        return ResponseEntity.ok(authService.criarUsuario(registrarRequestDTO));
    }
    
}
