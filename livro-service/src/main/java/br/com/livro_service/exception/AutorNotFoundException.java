package br.com.livro_service.exception;

public class AutorNotFoundException extends RuntimeException {

    public AutorNotFoundException(Long id) {
        super("Autor com ID " + id + " não encontrado.");
    }
}
