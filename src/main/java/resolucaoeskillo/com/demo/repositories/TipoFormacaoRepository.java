package resolucaoeskillo.com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import resolucaoeskillo.com.demo.model.TipoFormacao;
// no repository ele nao faz validaçoes ,so insere ,apaga ,essas coisas 
@Repository
// preciso informar que ela é um repositorio
public interface TipoFormacaoRepository extends JpaRepository<TipoFormacao, Long > {
    // <TipoFormacao, Long > o 1 é a entidade que ele vai retornar e o 2 é a chave dela


   
    // o jpa repository serve para vc implementar as funcionalidades basicas de um repositorio 
}


