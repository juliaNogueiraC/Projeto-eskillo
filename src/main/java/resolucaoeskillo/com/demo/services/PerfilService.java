package resolucaoeskillo.com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import resolucaoeskillo.com.demo.model.Perfil;
import resolucaoeskillo.com.demo.repositories.PerfilRepository;

@Service
public class PerfilService {
    
@Autowired
    private PerfilRepository repository;

    public List<Perfil>lista(){
        return repository.findAll();

    }



    public Perfil busca(Long id){
     Optional<Perfil> perfil  = repository.findById(id);
     return perfil.orElse(null);


    }



    public Perfil adiciona(Perfil perfil){
        perfil.setId(null);
      return  repository.save(perfil);
    }
    

    public Perfil atualiza(Perfil perfil){
        return repository.save(perfil);

    }

    public void remove(Long id){
            repository.deleteById(id);

    }
}
