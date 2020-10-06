package resolucaoeskillo.com.demo.repositories;

import resolucaoeskillo.com.demo.model.AreaDeEstudo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaDeEstudoRepository extends JpaRepository<AreaDeEstudo, Long> {
    
}
