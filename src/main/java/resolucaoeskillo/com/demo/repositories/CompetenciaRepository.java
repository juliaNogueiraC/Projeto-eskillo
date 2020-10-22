package resolucaoeskillo.com.demo.repositories;


import resolucaoeskillo.com.demo.model.Competencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Long> {
    
}
