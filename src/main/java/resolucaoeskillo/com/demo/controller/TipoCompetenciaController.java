package resolucaoeskillo.com.demo.controller;

import java.util.List;

import resolucaoeskillo.com.demo.model.TipoCompetencia;
import resolucaoeskillo.com.demo.services.TipoCompetenciaService;

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

@RestController
public class TipoCompetenciaController {

    @Autowired  
    private TipoCompetenciaService service;

    @GetMapping("/tipos-de-competencia")
    public ResponseEntity<?> lista() {
        List<TipoCompetencia> lista = service.lista();
        return ResponseEntity.status(HttpStatus.OK).body(lista);
    }

    @GetMapping("/tipos-de-competencia/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        TipoCompetencia tipoCompetencia = service.busca(id);
        if (tipoCompetencia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(tipoCompetencia);
    }

    @PostMapping("/tipos-de-competencia")
    public ResponseEntity<?> post(@RequestBody TipoCompetencia tipoCompetencia) {
        TipoCompetencia tipo = service.adiciona(tipoCompetencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(tipo);
    }

    @PutMapping("/tipos-de-competencia")
    public ResponseEntity<?> put(@RequestBody TipoCompetencia tipoCompetencia) {
        TipoCompetencia tipo = service.busca(tipoCompetencia.getId());
        if (tipo == null) {
            return ResponseEntity.notFound().build();
        }
        TipoCompetencia retorno = service.atualiza(tipoCompetencia);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(retorno);
    }
    
    @DeleteMapping("/tipos-de-competencia/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        TipoCompetencia tipo = service.busca(id);
        if (tipo == null) {
            return ResponseEntity.notFound().build();
        }
        service.remove(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}