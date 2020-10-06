package resolucaoeskillo.com.demo.services;

import java.util.List;
import java.util.Optional;

import resolucaoeskillo.com.demo.TipoCompetencia;
import resolucaoeskillo.com.demo.repositories.TipoCompetenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoCompetenciaService {

    @Autowired
    private TipoCompetenciaRepository repository;

    public List<TipoCompetencia> lista() {
        return repository.findAll();
    }

    public TipoCompetencia busca(Long id) {
        Optional<TipoCompetencia> tipo = repository.findById(id);
        return tipo.orElse(null);
    }

    public TipoCompetencia adiciona(TipoCompetencia tipoCompetencia) {
        tipoCompetencia.setId(null);
        return repository.save(tipoCompetencia);
    }
    
    public TipoCompetencia atualiza(TipoCompetencia tipoCompetencia) {
        return repository.save(tipoCompetencia);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

}
