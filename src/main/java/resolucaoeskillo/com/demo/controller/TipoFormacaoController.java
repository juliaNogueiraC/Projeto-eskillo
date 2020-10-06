package resolucaoeskillo.com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import resolucaoeskillo.com.demo.model.TipoFormacao;
import resolucaoeskillo.com.demo.services.TipoFormacaoService;


// aqui ele vai executar as coisas do service 
@RestController
public class TipoFormacaoController {


    @Autowired
    private TipoFormacaoService service;



@GetMapping("/tipos-de-formacao")
public ResponseEntity<?> lista() {
    List<TipoFormacao> lista = service.lista();
    return ResponseEntity.status(HttpStatus.OK).body(lista);
}


@GetMapping("/tipos-de-formacao/{id}")
public ResponseEntity<?> get(@PathVariable Long id) {
    TipoFormacao tipoFormacao = service.busca(id);
    if (tipoFormacao == null) {
        return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(tipoFormacao);
}



@PostMapping("/tipos-de-formacao")
public ResponseEntity<?> post(@RequestBody TipoFormacao tipoFormacao) {
    TipoFormacao tipo = service.adiciona(tipoFormacao);
    return ResponseEntity.status(HttpStatus.CREATED).body(tipo);
}















/** 
  @GetMapping("/tipos-formacao")
 Notação para mapeamento de 
solicitações HTTP GET em métodos
 manipuladores específicos.

public List<TipoFormacao> lista(){
  return service.lista();
  
  // esse metodo retorna para o cliente essa lista do service
}


@PostMapping("/tipos-formcacao")
public String post(@RequestBody TipoFormacao tipoFormacao){
   


    // chama o metoso adiciona do service 
    service.adiciona(tipoFormacao); // ele adicona la do repository pra cá
    return "registro adicionada com sucesso!";
}

@PutMapping("/tipos-formacao")
public String put(@RequestBody  TipoFormacao tipoFormacao) {
   


    // ele chama o metodo atualiza do service 
  // ele atualiza la do repository pra cá
    service.atualiza(tipoFormacao);
    return "registro atualizada com sucesso";
}

@DeleteMapping("/tipos-formacao")
public String delete(@RequestBody TipoFormacao tipoFormacao) {
    


     // ele chama o metodo remove do service 
  // ele remove la no repository e traz pra cá
     service.remove(tipoFormacao);
    return " rewgistro removida com sucesso";
}

}
**/

@PutMapping("/tipos-de-formacao")
public ResponseEntity<?> put(@RequestBody TipoFormacao tipoFormacao) {
    TipoFormacao tipo = service.busca(tipoFormacao.getId());
    if (tipo == null) {
        return ResponseEntity.notFound().build();
    }
    TipoFormacao retorno = service.atualiza(tipoFormacao);
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(retorno);
}

@DeleteMapping("/tipos-de-formacao/{id}")
public ResponseEntity<?> delete(@PathVariable Long id) {
    TipoFormacao tipo = service.busca(id);
    if (tipo == null) {
        return ResponseEntity.notFound().build();
    }
    service.remove(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}

}
