package aula_extra.loja_pedidos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import aula_extra.loja_pedidos.model.Cliente;
import aula_extra.loja_pedidos.services.ClienteService;

@RestController
public class ClienteController {
   
    @Autowired // nao esqueça da injeção
    private ClienteService service;




@GetMapping("/clientes")
public List<Cliente> lista(){
    return service.lista();

    
}


@GetMapping("/clientes")
public Cliente busca(@PathVariable Long id){
     return service.busca(id);
}





@PostMapping("/clientes")
public String adiciona(@RequestBody Cliente cliente){
    service.adiciona(cliente);

    return " cliente add com suceeso";



}


@PutMapping("/clientes")
public String atualiza(@RequestBody Cliente cliente){
  service.atualiza(cliente);
 return "cliente atualizado";

}




@DeleteMapping("/clientes")
public String remove(@PathVariable Long id){
    service.remove(id);

    return " cliente removido";

}
}
//



