package resolucaoeskillo.com.demo.repositories;

import resolucaoeskillo.com.demo.model.Formacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormacaoRepository extends JpaRepository<Formacao, Long> {
    
}

