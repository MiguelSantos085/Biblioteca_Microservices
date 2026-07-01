package br.com.autor_service.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class LivroClient {

    private final RestClient restClient;

    @Value("${livro.service.url}")
    private String livroServiceUrl;

    @Value("${livro.service.endpoint}")
    private String livroEndpoint;

    public LivroClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public boolean existsByAutor(Long autorId) {
        return restClient
                .get()
                .uri(livroServiceUrl + livroEndpoint + "/existe-autor/" + autorId)
                .retrieve()
                .body(boolean.class);
    }
}
