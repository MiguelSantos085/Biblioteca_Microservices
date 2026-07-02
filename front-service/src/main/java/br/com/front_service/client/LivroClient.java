package br.com.front_service.client;

import br.com.front_service.dto.request.LivroRequest;
import br.com.front_service.dto.response.LivroResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class LivroClient {

    private final RestClient restClient;

    @Value("${livro.service.url}")
    private String livroServiceUrl;

    public LivroClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<LivroResponse> findAll() {
        return restClient
                .get()
                .uri(livroServiceUrl + "/livros")
                .retrieve()
                .body(new ParameterizedTypeReference<List<LivroResponse>>() {});
    }

    public void create(LivroRequest request) {
        restClient
                .post()
                .uri(livroServiceUrl + "/livros/create")
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }

    public LivroResponse findById(Long id) {
        return restClient
                .get()
                .uri(livroServiceUrl + "/livros/" + id)
                .retrieve()
                .body(LivroResponse.class);
    }

    public void update(Long id, LivroRequest request) {
        restClient
                .put()
                .uri(livroServiceUrl + "/livros/" + id)
                .body(request)
                .retrieve()
                .toBodilessEntity();
    }

    public void delete(Long id) {
        restClient
                .delete()
                .uri(livroServiceUrl + "/livros/" + id)
                .retrieve()
                .toBodilessEntity();
    }

    public List<LivroResponse> findByTitulo(String titulo) {
        return restClient
                .get()
                .uri(livroServiceUrl + "/livros/titulo/" + titulo)
                .retrieve()
                .body(new ParameterizedTypeReference<List<LivroResponse>>() {});
    }

    public List<LivroResponse> findByDisponivel(Boolean disponivel) {
        return restClient
                .get()
                .uri(livroServiceUrl + "/livros/disponibilidade?disponivel=" + disponivel)
                .retrieve()
                .body(new ParameterizedTypeReference<List<LivroResponse>>() {});
    }

}
