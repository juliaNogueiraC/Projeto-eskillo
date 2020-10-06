package resolucaoeskillo.com.demo.services;

import java.util.List;
import java.util.Optional;

import resolucaoeskillo.com.demo.model.Localidade;
import resolucaoeskillo.com.demo.repositories.LocalidadeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalidadeService {

    @Autowired
    private LocalidadeRepository repository;

    public List<Localidade> lista() {
        return repository.findAll();
    }

    public Localidade busca(Long id) {
        Optional<Localidade> tipo = repository.findById(id);
        return tipo.orElse(null);
    }

    public Localidade adiciona(Localidade localidade) {
        localidade.setId(null);
        return repository.save(localidade);
    }
    
    public Localidade atualiza(Localidade localidade) {
        return repository.save(localidade);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

}
