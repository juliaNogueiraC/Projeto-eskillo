package resolucaoeskillo.com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import resolucaoeskillo.com.demo.model.TipoFormacao;

@Repository
// preciso informar que ela é um repositorio
public interface TipoFormacaoRepository extends JpaRepository<TipoFormacao, Long > {
    
}
