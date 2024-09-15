package aplicacao.login_registro.services;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import aplicacao.login_registro.dto.EnderecoDTO;
import reactor.core.publisher.Mono;

@Service
public class ViaCepService {
    
    private final WebClient webClient = WebClient.create("viacep.com.br/ws/");

    public Mono<EnderecoDTO> getEnderecoPorCep(String cep){
        return webClient.get()
            .uri("/{cep}/json/", cep)
            .retrieve()
            .bodyToMono(EnderecoDTO.class);
    }
}
