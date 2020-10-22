package resolucaoeskillo.com.demo.repositories;

import resolucaoeskillo.com.demo.model.Telefone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
    
}

