package aplicacao.login_registro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import aplicacao.login_registro.dto.EnderecoDTO;
import aplicacao.login_registro.infra.security.SecurityConfig;
import aplicacao.login_registro.services.ViaCepService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = SecurityConfig.SECURITY)
public class CepController {
    
    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public ResponseEntity<EnderecoDTO> getEndereco(@PathVariable String cep) {
        return ResponseEntity.ok(viaCepService.getEnderecoCep(cep));
    }
    
}
