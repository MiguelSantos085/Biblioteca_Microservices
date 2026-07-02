package br.com.front_service.controller;

import br.com.front_service.client.AutorClient;
import br.com.front_service.client.LivroClient;
import br.com.front_service.dto.request.LivroRequest;
import br.com.front_service.dto.response.LivroResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LivroController {

    private final LivroClient livroClient;
    private final AutorClient autorClient;

    public LivroController(LivroClient livroClient, AutorClient autorClient) {
        this.livroClient = livroClient;
        this.autorClient = autorClient;
    }

    @GetMapping("/livros")
    public String listar(
            @RequestParam(required = false) String titulo,
            @RequestParam(required = false) Boolean disponivel,
            @RequestParam(required = false) String success,
            @RequestParam(required = false) String error,
            Model model) {

        if (success != null)
            model.addAttribute("success", success);

        if (error != null)
            model.addAttribute("error", error);

        List<LivroResponse> livros;

        if (titulo != null && !titulo.isBlank()) {
            livros = livroClient.findByTitulo(titulo);

        } else if (disponivel != null) {

            livros = livroClient.findByDisponivel(disponivel);

        } else {

            livros = livroClient.findAll();

        }

        model.addAttribute("livros", livros);
        model.addAttribute("titulo", titulo);
        model.addAttribute("disponivel", disponivel);

        return "livros/lista";
    }

    @GetMapping("/livros/novo")
    public String novo(Model model) {

        model.addAttribute("livro", new LivroRequest());
        model.addAttribute("autores", autorClient.findAll());
        model.addAttribute("formAction", "/livros");

        return "livros/form";
    }

    @PostMapping("/livros")
    public String salvar(@ModelAttribute("livro") LivroRequest request) {
        livroClient.create(request);
        return "redirect:/livros?success=Livro cadastrado com sucesso";
    }

    @GetMapping("/livros/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {

        LivroResponse response = livroClient.findById(id);

        LivroRequest request = new LivroRequest();
        request.setTitulo(response.getTitulo());
        request.setGenero(response.getGenero());
        request.setAnoPublicado(response.getAnoPublicado());
        request.setAutorId(response.getAutorId());

        model.addAttribute("livro", request);
        model.addAttribute("autores", autorClient.findAll());
        model.addAttribute("id", id);
        model.addAttribute("formAction", "/livros/" + id);

        return "livros/form";
    }

    @PostMapping("/livros/{id}")
    public String atualizar(@PathVariable Long id,
                            @ModelAttribute LivroRequest request) {

        livroClient.update(id, request);

        return "redirect:/livros?success=Livro atualizado com sucesso";
    }

    @PostMapping("/livros/{id}/excluir")
    public String excluir(@PathVariable Long id) {

        livroClient.delete(id);

        return "redirect:/livros?success=Livro excluido com sucesso";
    }





}
