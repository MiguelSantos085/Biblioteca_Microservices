package br.com.livro_service.controller;

import br.com.livro_service.dto.request.LivroRequest;
import br.com.livro_service.dto.response.LivroResponse;
import br.com.livro_service.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<LivroResponse> create(@RequestBody LivroRequest request) {
        LivroResponse response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/disponibilidade")
    public ResponseEntity<List<LivroResponse>> findByDisponivel(@RequestParam Boolean disponivel) {
        List<LivroResponse> response = service.findByDisponivel(disponivel);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> findById(@PathVariable Long id) {
        LivroResponse response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<List<LivroResponse>> findByTituloContainingIgnoreCase(@PathVariable String titulo) {
        List<LivroResponse> response = service.findByTituloContainingIgnoreCase(titulo);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByTitulo/{titulo}")
    public ResponseEntity<LivroResponse> findByTitulo(@PathVariable String titulo) {
        LivroResponse response = service.findByTituloIgnoreCase(titulo);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<LivroResponse>> findByAll() {
        List<LivroResponse> response = service.findAll();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponse> update(@PathVariable Long id, LivroRequest request) {
        LivroResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LivroResponse> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
