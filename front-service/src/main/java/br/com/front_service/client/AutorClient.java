package br.com.front_service.client;

import br.com.front_service.dto.request.AutorRequest;
import br.com.front_service.dto.response.AutorResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class AutorClient {

    private final RestClient restClient;

    @Value("${autor.service.url}")
    private String autorServiceUrl;

    public AutorClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<AutorResponse> findAll() {
        return restClient
                .get()
                .uri(autorServiceUrl + "/autores")
                .retrieve()
                .body(new ParameterizedTypeReference<List<AutorResponse>>() {});
    }

    public void create(AutorRequest request) {
        restClient.post()
                .uri(autorServiceUrl + "/autores/create")
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }

    public AutorResponse findById(Long id) {
        return restClient
                .get()
                .uri(autorServiceUrl + "/autores/" + id)
                .retrieve()
                .body(AutorResponse.class);
    }

    public void update(Long id, AutorRequest request) {
        restClient
                .put()
                .uri(autorServiceUrl + "/autores/" + id)
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }

    public void delete(Long id) {
        restClient
                .delete()
                .uri(autorServiceUrl + "/autores/" + id)
                .retrieve()
                .toBodilessEntity();
    }

    public List<AutorResponse> findByNome(String nome) {
        return restClient
                .get()
                .uri(autorServiceUrl + "/autores/BuscarNomes/" + nome)
                .retrieve()
                .body(new ParameterizedTypeReference<List<AutorResponse>>() {});
    }
}
