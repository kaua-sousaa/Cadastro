package aplicacao.login_registro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import aplicacao.login_registro.dto.EnderecoDTO;
import aplicacao.login_registro.services.ViaCepService;
import reactor.core.publisher.Mono;

@RestController
public class CadastroController {
    
    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/cep/{cep}")
    public Mono<ResponseEntity<EnderecoDTO>> getEndereco(@PathVariable String cep){
        return viaCepService.getEnderecoPorCep(cep)
        .map(EnderecoDTO -> ResponseEntity.ok(EnderecoDTO))
        .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    
}
