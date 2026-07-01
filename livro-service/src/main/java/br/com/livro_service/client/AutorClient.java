package br.com.livro_service.client;

import br.com.livro_service.dto.response.AutorResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

@Service
public class AutorClient {

    private final RestClient restClient;

    @Value("${autor.service.url}")
    private String autorServiceUrl;

    @Value("${autor.service.endpoint}")
    private String autorEndpoint;

    public AutorClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public AutorResponse findById(Long id) {
        try {
            return restClient
                    .get()
                    .uri(autorServiceUrl + autorEndpoint + "/" + id)
                    .retrieve()
                    .body(AutorResponse.class);
        } catch (RestClientException e) {
            return null;
        }
    }
}
