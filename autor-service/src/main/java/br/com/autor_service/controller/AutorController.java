package br.com.autor_service.controller;

import br.com.autor_service.dto.request.AutorRequest;
import br.com.autor_service.dto.response.AutorResponse;
import br.com.autor_service.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService service;

    public AutorController (AutorService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<AutorResponse> create(@RequestBody AutorRequest request) {
        AutorResponse response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponse> findById(@PathVariable Long id) {
        AutorResponse response = service.findById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/BuscarNomes/{nome}")
    public ResponseEntity<List<AutorResponse>> findByNomeContainingIgnoreCase(String nome) {
        List<AutorResponse> response = service.findByNomeContainingIgnoreCase(nome);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/findByName/{nome}")
    public ResponseEntity<AutorResponse> findByName(@PathVariable String nome) {
        AutorResponse response = service.findByName(nome);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<AutorResponse>> findAll() {
        List<AutorResponse> response = service.findAll();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponse> update(@PathVariable Long id, AutorRequest request) {
        AutorResponse response = service.update(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AutorResponse> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
