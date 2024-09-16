package aplicacao.login_registro.services;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import aplicacao.login_registro.dto.EnderecoDTO;

@Service
public class ViaCepService {
    
    private final CloseableHttpClient httpClient = HttpClients.createDefault();
    private final Gson gson = new Gson();

    public EnderecoDTO getEnderecoCep(String cep){
        String url = "http://viacep.com.br/ws/"+ cep+ "/json/";
        HttpGet request = new HttpGet(url);

        try (CloseableHttpResponse response = httpClient.execute(request)){
            if (response.getStatusLine().getStatusCode() == 200){
                String json = EntityUtils.toString(response.getEntity());
                EnderecoDTO enderecoDTO = gson.fromJson(json, EnderecoDTO.class);
                return enderecoDTO;
            }else{
                throw new RuntimeException("erro: "+ response.getStatusLine().getStatusCode());
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na requisicao http");
        }
    }
}