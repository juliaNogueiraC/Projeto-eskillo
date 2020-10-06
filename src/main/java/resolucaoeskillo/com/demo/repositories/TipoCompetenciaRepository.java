package resolucaoeskillo.com.demo.repositories;

import resolucaoeskillo.com.demo.model.TipoCompetencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCompetenciaRepository extends JpaRepository<TipoCompetencia, Long> {
    
}
