package resolucaoeskillo.com.demo.services;

import java.util.List;
import java.util.Optional;

import resolucaoeskillo.com.demo.model.AreaDeEstudo;
import resolucaoeskillo.com.demo.repositories.AreaDeEstudoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaDeEstudoService {

    @Autowired
    private AreaDeEstudoRepository repository;

    public List<AreaDeEstudo> lista() {
        return repository.findAll();
    }

    public AreaDeEstudo busca(Long id) {
        Optional<AreaDeEstudo> tipo = repository.findById(id);
        return tipo.orElse(null);
    }

    public AreaDeEstudo adiciona(AreaDeEstudo areaDeEstudo) {
        areaDeEstudo.setId(null);
        return repository.save(areaDeEstudo);
    }
    
    public AreaDeEstudo atualiza(AreaDeEstudo areaDeEstudo) {
        return repository.save(areaDeEstudo);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

}