package resolucaoeskillo.com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import resolucaoeskillo.com.demo.model.TipoFormacao;
import resolucaoeskillo.com.demo.repositories.TipoFormacaoRepository;


// aqui ele da visibilidade 
// na classe serviço ,ele vai dispor as inf para o repository que vai dispor para a classe consumidora ,que é a controller 

// as regras de negocio sao implementadas aqui ,nao no repository , o reporsitory é so p buca de dados 
@Service
// aqui nos infromamos que ela respresenta um serviço
public class TipoFormacaoService {

  @Autowired // ele vai instaciar e chmar a classe ,implementação
   TipoFormacaoRepository repository;
    
  public List<TipoFormacao> lista(){


   return repository.findAll();// ele vai buscar e retornar todos os tipos
 // listagem

  }  


  public void adiciona(TipoFormacao tipoFormacao){
  
   
    repository.save(tipoFormacao);
   // .save ()a: i ele vai grava no banco de dados esse dado ai 
 
  }


  public void atualiza(TipoFormacao tipoFormacao){
    repository.save(tipoFormacao);


  }

  /**public void remove(TipoFormacao tipoFormacao){


    repository.delete(tipoFormacao);
  }

  ou 
**/
public void delete(Long id){
   repository.deleteById(id);
}
 

  
  public TipoFormacao busca(Long id){
    Optional<TipoFormacao> tipoFormacao = repository.findById(id);
   // ele vai buscar e localizar o tipo da formacao no banco de dados pelo id!!!!!!!!1

    return tipoFormacao.orElse(null);
    // aqui ele retona o objeto , se ele esxitir ,se nao ,lee retorna nulo
      }
}

