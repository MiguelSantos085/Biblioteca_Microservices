package br.com.front_service.controller;

import br.com.front_service.client.AutorClient;
import br.com.front_service.dto.request.AutorRequest;
import br.com.front_service.dto.response.AutorResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AutorController {

    private final AutorClient autorClient;

    public AutorController(AutorClient autorClient) {
        this.autorClient = autorClient;
    }

    @GetMapping("/autores")
    public String listar(@RequestParam(required = false) String nome,
                         @RequestParam(required = false) String success,
                         @RequestParam(required = false) String error,
                         Model model) {

        if (success != null) {
            model.addAttribute("success", success);
        }

        if (error != null) {
            model.addAttribute("error", error);
        }

        List<AutorResponse> autores;

        if (nome != null && !nome.isBlank()) {
            autores = autorClient.findByNome(nome);
        } else {
            autores = autorClient.findAll();
        }

        model.addAttribute("autores", autores);
        model.addAttribute("nome", nome);

        return "autores/lista";
    }

    @GetMapping("/autores/novo")
    public String novoAutor(Model model){
        model.addAttribute("autor", new AutorRequest());

        return "autores/form";
    }

    @PostMapping("/autores")
    public String salvar(@ModelAttribute AutorRequest autor){
        autorClient.create(autor);

        return "redirect:/autores?success=Autor cadastrado com sucesso";    }

    @GetMapping("/autores/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        AutorResponse response = autorClient.findById(id);

        AutorRequest request = new AutorRequest();
        request.setNome(response.getNome());
        request.setNacionalidade(response.getNacionalidade());
        request.setAnoNascimento(response.getAnoNascimento());

        model.addAttribute("autor", request);
        model.addAttribute("id", id);

        return "autores/form";
    }

    @PostMapping("/autores/{id}")
    public String atualizar(@PathVariable Long id, @ModelAttribute("autor") AutorRequest request) {
        autorClient.update(id, request);

        return "redirect:/autores?success=Autor atualizado com sucesso";    }


    @PostMapping("/autores/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        try {
            autorClient.delete(id);
            return "redirect:/autores?success=Autor excluido com sucesso!";
        } catch (Exception e) {
            return "redirect:/autores?error=Nao foi possivel excluir o autor. Verifique se existem livros vinculados.";
        }
    }

}
