package aula_extra.loja_pedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import aula_extra.loja_pedidos.model.Cliente;
import aula_extra.loja_pedidos.repositories.ClienteRepository;

@service
public class ClienteService {
  // implemetdar metodos  e regras de negocio para o consumidor (controlador ne ) 
  


  @Autowired // ele procura essa classe e injeta aqui dentro !
  private ClienteRepository repository;



  public void adiciona(Cliente cliente){

    cliente.setId(null);
     repository.save(cliente);
     //qvoce faz isso por csauda do autowired que inejtou a classea qui


  }




  public void atualiza(Cliente cliente){
    repository.save(cliente);
    
}


public void remove(Long id){
 repository.deleteById(id);
    
}

public Cliente busca(Long id){


// se existir 
    Optional<Cliente> cliente = repository.findById(id);

    // se nao
  return cliente.orElse(null);
    
}

public List<Cliente> lista(){

    return repository.findAll();
    // busca todos !

    
}


}
