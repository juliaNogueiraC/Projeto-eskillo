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



@GetMapping("/tipos-formacao")
/* Notação para mapeamento de 
solicitações HTTP GET em métodos
 manipuladores específicos.
*/
public List<TipoFormacao> lista(){
  return service.lista();
  
  // esse metodo retorna para o cliente essa lista do service
}


@GetMapping("/tipos-formacao/{id}")
public TipoFormacao get(@PathVariable Long id){
// ele chamda o metodo busca do service 
 return  service.busca(id);



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
