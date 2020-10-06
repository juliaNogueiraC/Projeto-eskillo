package resolucaoeskillo.com.demo.services;

import java.util.List;

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

    public Perfil add(Perfil perfil){
        perfil.setId(null);
      return  repository.save(perfil);
    }
    
}
