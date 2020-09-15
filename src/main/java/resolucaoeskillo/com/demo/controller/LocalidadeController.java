package resolucaoeskillo.com.demo.controller;

import java.util.List;

import resolucaoeskillo.com.demo.model.Localidade;
import resolucaoeskillo.com.demo.repositories.LocalidadeRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class LocalidadeController {

    private LocalidadeRepository repo = new LocalidadeRepository();

    @GetMapping("/localidades")
    public List<Localidade> list() {
        return repo.lista();
    }

    @GetMapping("/localidades/{id}")
    public Localidade get(@PathVariable Long id) {
        return repo.obtem(id);
    }

    @PostMapping("/localidades")
    public String post(@RequestBody Localidade localidade) {
        repo.adiciona(localidade);
        return "Localidade adicionada com sucesso!";
    }

    @PutMapping("/localidades")
    public String put(@RequestBody Localidade localidade) {
        repo.atualiza(localidade);
        return "Localidade atualizada com sucesso";
    }
    
    @DeleteMapping("/localidades")
    public String delete(@RequestBody Localidade localidade) {
        repo.remove(localidade);
        return "Localidade removida com sucesso";
    }

