package resolucaoeskillo.com.demo.repositories;
import resolucaoeskillo.com.demo.model.Perfil;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PerfilRepository extends JpaRepository<Perfil, Long>{
    
}
