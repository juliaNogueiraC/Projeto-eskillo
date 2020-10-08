package resolucaoeskillo.com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import resolucaoeskillo.com.demo.model.AreaDeEstudo;
import resolucaoeskillo.com.demo.services.AreaDeEstudoService;

@RestController
public class AreaDeEstudoController {

    @Autowired  
    private AreaDeEstudoService service;

    @GetMapping("/areas-de-estudo")
    public ResponseEntity<?> lista() {
        List<AreaDeEstudo> lista = service.lista();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/areas-de-estudo/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        AreaDeEstudo areaDeEstudo = service.busca(id);
        if (areaDeEstudo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(areaDeEstudo);
    }

    @PostMapping("/areas-de-estudo")
    public ResponseEntity<?> post(@RequestBody AreaDeEstudo areaDeEstudo) {
        AreaDeEstudo area = service.adiciona(areaDeEstudo);
        return ResponseEntity.status(HttpStatus.CREATED).body(area);
    }

    @PutMapping("/areas-de-estudo")
    public ResponseEntity<?> put(@RequestBody AreaDeEstudo areaDeEstudo) {
        AreaDeEstudo area = service.busca(areaDeEstudo.getId());
        if (area == null) {
            return ResponseEntity.notFound().build();
        }
        AreaDeEstudo retorno = service.atualiza(areaDeEstudo);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(retorno);
    }
    
    @DeleteMapping("/areas-de-estudo/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        AreaDeEstudo area = service.busca(id);
        if (area == null) {
            return ResponseEntity.notFound().build();
        }
        service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
