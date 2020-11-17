package resolucaoeskillo.com.demo.repositories;
import resolucaoeskillo.com.demo.model.Perfil;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    
    @Transactional(readOnly = true)
    List<Perfil> findByEmail(String email);
    
}
