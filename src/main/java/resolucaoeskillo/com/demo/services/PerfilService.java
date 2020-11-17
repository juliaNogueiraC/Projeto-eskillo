package resolucaoeskillo.com.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import resolucaoeskillo.com.demo.model.Competencia;
import resolucaoeskillo.com.demo.model.Curso;
import resolucaoeskillo.com.demo.model.Experiencia;
import resolucaoeskillo.com.demo.model.Formacao;
import resolucaoeskillo.com.demo.model.Perfil;
import resolucaoeskillo.com.demo.model.Telefone;
import resolucaoeskillo.com.demo.repositories.CompetenciaRepository;
import resolucaoeskillo.com.demo.repositories.CursoRepository;
import resolucaoeskillo.com.demo.repositories.ExperienciaRepository;
import resolucaoeskillo.com.demo.repositories.FormacaoRepository;
import resolucaoeskillo.com.demo.repositories.PerfilRepository;
import resolucaoeskillo.com.demo.repositories.TelefoneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Autowired
    private FormacaoRepository formacaoRepository;

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private TelefoneRepository telefoneRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    public List<Perfil> lista() {
        return repository.findAll();
    }

    public Perfil busca(Long id) {
        Optional<Perfil> perfil = repository.findById(id);
        return perfil.orElse(null);
    }

    public Perfil adiciona(Perfil perfil) {
        perfil.setId(null);
        return repository.save(perfil);
    }

    public Perfil atualiza(Perfil perfil) {
        return repository.save(perfil);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    /* ------------------------ *
    *   Métodos sobre Cursos
    * ------------------------- */
    public List<Curso> listaCursos(Long idPerfil) {
        Optional<Perfil> opt = repository.findById(idPerfil);
        if (opt.isPresent()) {
            Perfil perfil = opt.get();
            return perfil.getCursos();
        }
        return null;
    }

    public Curso buscaCurso(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            for (Curso curso : perfil.getCursos()) {
                if (curso.getId().equals(id)) {
                    return curso;
                }
            }
        }
        return null;
    }

    @Transactional
    public Curso adicionaCurso(Long idPerfil, Curso curso) {
        Curso novoCurso = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            curso.setId(null);
            novoCurso = cursoRepository.save(curso);
            perfil.getCursos().add(novoCurso);
            repository.save(perfil);
        }
        return novoCurso;
    }

    @Transactional
    public Curso atualizaCurso(Long idPerfil, Curso curso) {
        Curso cursoAtualizado = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            int pos = perfil.getCursos().indexOf(curso);
            if (pos >= 0) {
                cursoAtualizado = cursoRepository.save(curso);
                perfil.getCursos().set(pos, curso);
                repository.save(perfil);
            }
        }
        return cursoAtualizado;
    }

    @Transactional
    public void removeCurso(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            Curso cursoEncontrado = null;
            for (Curso curso : perfil.getCursos()) {
                if (curso.getId().equals(id)) {
                    cursoEncontrado = curso;
                }
            }
            if (cursoEncontrado != null) {
                perfil.getCursos().remove(cursoEncontrado);
                repository.save(perfil);
                cursoRepository.deleteById(id);
            }
        }
    }

    /* ----------------------------------------- *
    *   Métodos sobre Experiências Profissionais
    * ------------------------------------------ */
    public List<Experiencia> listaExperiencias(Long idPerfil) {
        Optional<Perfil> opt = repository.findById(idPerfil);
        if (opt.isPresent()) {
            Perfil perfil = opt.get();
            return perfil.getExperiencias();
        }
        return null;
    }

    public Experiencia buscaExperiencia(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            for (Experiencia experiencia : perfil.getExperiencias()) {
                if (experiencia.getId().equals(id)) {
                    return experiencia;
                }
            }
        }
        return null;
    }

    @Transactional
    public Experiencia adicionaExperiencia(Long idPerfil, Experiencia experiencia) {
        Experiencia novaExperiencia = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            experiencia.setId(null);
            novaExperiencia = experienciaRepository.save(experiencia);
            perfil.getExperiencias().add(novaExperiencia);
            repository.save(perfil);
        }
        return novaExperiencia;
    }

    @Transactional
    public Experiencia atualizaExperiencia(Long idPerfil, Experiencia experiencia) {
        Experiencia experienciaAtualizada = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            int pos = perfil.getExperiencias().indexOf(experiencia);
            if (pos >= 0) {
                experienciaAtualizada = experienciaRepository.save(experiencia);
                perfil.getExperiencias().set(pos, experiencia);
                repository.save(perfil);
            }
        }
        return experienciaAtualizada;
    }

    @Transactional
    public void removeExperiencia(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            Experiencia experienciaEncontrada = null;
            for (Experiencia experiencia : perfil.getExperiencias()) {
                if (experiencia.getId().equals(id)) {
                    experienciaEncontrada = experiencia;
                }
            }
            if (experienciaEncontrada != null) {
                perfil.getExperiencias().remove(experienciaEncontrada);
                repository.save(perfil);
                experienciaRepository.deleteById(id);
            }
        }
    }

    public List<Formacao> listaFormacoes(Long idPerfil) {
        Optional<Perfil> opt = repository.findById(idPerfil);
        if (opt.isPresent()) {
            Perfil perfil = opt.get();
            return perfil.getFormacoes();
        }
        return null;
    }

    public Formacao buscaFormacao(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            for (Formacao formacao : perfil.getFormacoes()) {
                if (formacao.getId().equals(id)) {
                    return formacao;
                }
            }
        }
        return null;
    }

    @Transactional
    public Formacao adicionaFormacao(Long idPerfil, Formacao formacao) {
        Formacao nova = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            formacao.setId(null);
            nova = formacaoRepository.save(formacao);
            perfil.getFormacoes().add(nova);
            repository.save(perfil);
        }
        return nova;
    }

    @Transactional
    public Formacao atualizaFormacao(Long idPerfil, Formacao formacao) {
        Formacao formacaoAtualizada = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            int pos = perfil.getFormacoes().indexOf(formacao);
            if (pos >= 0) {
                formacaoAtualizada = formacaoRepository.save(formacao);
                perfil.getFormacoes().set(pos, formacao);
                repository.save(perfil);
            }
        }
        return formacaoAtualizada;
    }

    @Transactional
    public void removeFormacao(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            Formacao encontrada = null;
            for (Formacao formacao : perfil.getFormacoes()) {
                if (formacao.getId().equals(id)) {
                    encontrada = formacao;
                }
            }
            if (encontrada != null) {
                perfil.getFormacoes().remove(encontrada);
                repository.save(perfil);
                formacaoRepository.deleteById(id);
            }
        }
    }

    public List<Competencia> listaCompetencias(Long idPerfil) {
        Optional<Perfil> opt = repository.findById(idPerfil);
        if (opt.isPresent()) {
            Perfil perfil = opt.get();
            return perfil.getCompetencias();
        }
        return null;
    }

    public Competencia buscaCompetencia(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            for (Competencia competencia : perfil.getCompetencias()) {
                if (competencia.getId().equals(id)) {
                    return competencia;
                }
            }
        }
        return null;
    }

    @Transactional
    public Competencia adicionaCompetencia(Long idPerfil, Competencia competencia) {
        Competencia nova = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            competencia.setId(null);
            nova = competenciaRepository.save(competencia);
            perfil.getCompetencias().add(nova);
            repository.save(perfil);
        }
        return nova;
    }

    @Transactional
    public Competencia atualizaCompetencia(Long idPerfil, Competencia competencia) {
        Competencia atualizada = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            int pos = perfil.getCompetencias().indexOf(competencia);
            if (pos >= 0) {
                atualizada = competenciaRepository.save(competencia);
                perfil.getCompetencias().set(pos, competencia);
                repository.save(perfil);
            }
        }
        return atualizada;
    }

    @Transactional
    public void removeCompetencia(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            Competencia encontrada = null;
            for (Competencia competencia : perfil.getCompetencias()) {
                if (competencia.getId().equals(id)) {
                    encontrada = competencia;
                }
            }
            if (encontrada != null) {
                perfil.getCompetencias().remove(encontrada);
                repository.save(perfil);
                competenciaRepository.deleteById(id);
            }
        }
    }

    public List<Telefone> listaTelefones(Long idPerfil) {
        Optional<Perfil> opt = repository.findById(idPerfil);
        if (opt.isPresent()) {
            Perfil perfil = opt.get();
            return perfil.getTelefones();
        }
        return null;
    }

    public Telefone buscaTelefone(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            for (Telefone telefone : perfil.getTelefones()) {
                if (telefone.getId().equals(id)) {
                    return telefone;
                }
            }
        }
        return null;
    }

    @Transactional
    public Telefone adicionaTelefone(Long idPerfil, Telefone telefone) {
        Telefone novo = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            telefone.setId(null);
            novo = telefoneRepository.save(telefone);
            perfil.getTelefones().add(novo);
            repository.save(perfil);
        }
        return novo;
    }

    @Transactional
    public Telefone atualizaTelefone(Long idPerfil, Telefone telefone) {
        Telefone atualizado = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            int pos = perfil.getTelefones().indexOf(telefone);
            if (pos >= 0) {
                atualizado = telefoneRepository.save(telefone);
                perfil.getTelefones().set(pos, telefone);
                repository.save(perfil);
            }
        }
        return atualizado;
    }

    @Transactional
    public void removeTelefone(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (idPerfil != null) {
            Telefone encontrado = null;
            for (Telefone telefone : perfil.getTelefones()) {
                if (telefone.getId().equals(id)) {
                    encontrado = telefone;
                }
            }
            if (encontrado != null) {
                perfil.getTelefones().remove(encontrado);
                repository.save(perfil);
                telefoneRepository.deleteById(id);
            }
        }
    }

}




 /*
    public List<Perfil> lista() {
        return repository.findAll();
    }

    public Perfil busca(Long id) {
        Optional<Perfil> perfil = repository.findById(id);
        return perfil.orElse(null);
    }

    public Perfil adiciona(Perfil perfil) {
        perfil.setId(null);
        return repository.save(perfil);
    }

    public Perfil atualiza(Perfil perfil) {
        return repository.save(perfil);
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }

    public List<Curso> listaCursos(Long idPerfil) {
        Optional<Perfil> opt = repository.findById(idPerfil);
        if (opt.isPresent()) {
            Perfil perfil = opt.get();
            return perfil.getCursos();
        }
        return null;
    }

    public Curso buscaCurso(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            for (Curso curso : perfil.getCursos()) {
                if (curso.getId().equals(id)) {
                    return curso;
                }
            }
        }
        return null;
    }

    @Transactional
    public Curso adicionaCurso(Long idPerfil, Curso curso) {
        Curso novoCurso = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            curso.setId(null);
            novoCurso = cursoRepository.save(curso);
            perfil.getCursos().add(novoCurso);
            repository.save(perfil);
        }
        return novoCurso;
    }

    @Transactional
    public Curso atualizaCurso(Long idPerfil, Curso curso) {
        Curso cursoAtualizado = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            int pos = perfil.getCursos().indexOf(curso);
            if (pos >= 0) {
                cursoAtualizado = cursoRepository.save(curso);
                perfil.getCursos().set(pos, curso);
                repository.save(perfil);
            }
        }
        return cursoAtualizado;
    }

    @Transactional
    public void removeCurso(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            Curso cursoEncontrado = null;
            for (Curso curso : perfil.getCursos()) {
                if (curso.getId().equals(id)) {
                    cursoEncontrado = curso;
                }
            }
            if (cursoEncontrado != null) {
                perfil.getCursos().remove(cursoEncontrado);
                repository.save(perfil);
                cursoRepository.deleteById(id);
            }
        }
    }

    public List<Experiencia> listaExperiencias(Long idPerfil) {
        Optional<Perfil> opt = repository.findById(idPerfil);
        if (opt.isPresent()) {
            Perfil perfil = opt.get();
            return perfil.getExperiencias();
        }
        return null;
    }

    public Experiencia buscaExperiencia(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            for (Experiencia experiencia : perfil.getExperiencias()) {
                if (experiencia.getId().equals(id)) {
                    return experiencia;
                }
            }
        }
        return null;
    }

    @Transactional
    public Experiencia adicionaExperiencia(Long idPerfil, Experiencia experiencia) {
        Experiencia novaExperiencia = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            experiencia.setId(null);
            novaExperiencia = experienciaRepository.save(experiencia);
            perfil.getExperiencias().add(novaExperiencia);
            repository.save(perfil);
        }
        return novaExperiencia;
    }

    @Transactional
    public Experiencia atualizaExperiencia(Long idPerfil, Experiencia experiencia) {
        Experiencia experienciaAtualizada = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            int pos = perfil.getExperiencias().indexOf(experiencia);
            if (pos >= 0) {
                experienciaAtualizada = experienciaRepository.save(experiencia);
                perfil.getExperiencias().set(pos, experiencia);
                repository.save(perfil);
            }
        }
        return experienciaAtualizada;
    }

    @Transactional
    public void removeExperiencia(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            Experiencia experienciaEncontrada = null;
            for (Experiencia experiencia : perfil.getExperiencias()) {
                if (experiencia.getId().equals(id)) {
                    experienciaEncontrada = experiencia;
                }
            }
            if (experienciaEncontrada != null) {
                perfil.getExperiencias().remove(experienciaEncontrada);
                repository.save(perfil);
                experienciaRepository.deleteById(id);
            }
        }
    }

    public List<Formacao> listaFormacoes(Long idPerfil) {
        Optional<Perfil> opt = repository.findById(idPerfil);
        if (opt.isPresent()) {
            Perfil perfil = opt.get();
            return perfil.getFormacoes();
        }
        return null;
    }

    public Formacao buscaFormacao(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            for (Formacao formacao : perfil.getFormacoes()) {
                if (formacao.getId().equals(id)) {
                    return formacao;
                }
            }
        }
        return null;
    }

    @Transactional
    public Formacao adicionaFormacao(Long idPerfil, Formacao formacao) {
        Formacao nova = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            formacao.setId(null);
            nova = formacaoRepository.save(formacao);
            perfil.getFormacoes().add(nova);
            repository.save(perfil);
        }
        return nova;
    }

    @Transactional
    public Formacao atualizaFormacao(Long idPerfil, Formacao formacao) {
        Formacao formacaoAtualizada = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            int pos = perfil.getFormacoes().indexOf(formacao);
            if (pos >= 0) {
                formacaoAtualizada = formacaoRepository.save(formacao);
                perfil.getFormacoes().set(pos, formacao);
                repository.save(perfil);
            }
        }
        return formacaoAtualizada;
    }

    @Transactional
    public void removeFormacao(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            Formacao encontrada = null;
            for (Formacao formacao : perfil.getFormacoes()) {
                if (formacao.getId().equals(id)) {
                    encontrada = formacao;
                }
            }
            if (encontrada != null) {
                perfil.getFormacoes().remove(encontrada);
                repository.save(perfil);
                formacaoRepository.deleteById(id);
            }
        }
    }

    public List<Competencia> listaCompetencias(Long idPerfil) {
        Optional<Perfil> opt = repository.findById(idPerfil);
        if (opt.isPresent()) {
            Perfil perfil = opt.get();
            return perfil.getCompetencias();
        }
        return null;
    }

    public Competencia buscaCompetencia(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            for (Competencia competencia : perfil.getCompetencias()) {
                if (competencia.getId().equals(id)) {
                    return competencia;
                }
            }
        }
        return null;
    }

    @Transactional
    public Competencia adicionaCompetencia(Long idPerfil, Competencia competencia) {
        Competencia nova = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            competencia.setId(null);
            nova = competenciaRepository.save(competencia);
            perfil.getCompetencias().add(nova);
            repository.save(perfil);
        }
        return nova;
    }

    @Transactional
    public Competencia atualizaCompetencia(Long idPerfil, Competencia competencia) {
        Competencia atualizada = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            int pos = perfil.getCompetencias().indexOf(competencia);
            if (pos >= 0) {
                atualizada = competenciaRepository.save(competencia);
                perfil.getCompetencias().set(pos, competencia);
                repository.save(perfil);
            }
        }
        return atualizada;
    }

    @Transactional
    public void removeCompetencia(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            Competencia encontrada = null;
            for (Competencia competencia : perfil.getCompetencias()) {
                if (competencia.getId().equals(id)) {
                    encontrada = competencia;
                }
            }
            if (encontrada != null) {
                perfil.getCompetencias().remove(encontrada);
                repository.save(perfil);
                competenciaRepository.deleteById(id);
            }
        }
    }

    public List<Telefone> listaTelefones(Long idPerfil) {
        Optional<Perfil> opt = repository.findById(idPerfil);
        if (opt.isPresent()) {
            Perfil perfil = opt.get();
            return perfil.getTelefones();
        }
        return null;
    }

    public Telefone buscaTelefone(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            for (Telefone telefone : perfil.getTelefones()) {
                if (telefone.getId().equals(id)) {
                    return telefone;
                }
            }
        }
        return null;
    }

    @Transactional
    public Telefone adicionaTelefone(Long idPerfil, Telefone telefone) {
        Telefone novo = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            telefone.setId(null);
            novo = telefoneRepository.save(telefone);
            perfil.getTelefones().add(novo);
            repository.save(perfil);
        }
        return novo;
    }

    @Transactional
    public Telefone atualizaTelefone(Long idPerfil, Telefone telefone) {
        Telefone atualizado = null;
        Perfil perfil = busca(idPerfil);
        if (perfil != null) {
            int pos = perfil.getTelefones().indexOf(telefone);
            if (pos >= 0) {
                atualizado = telefoneRepository.save(telefone);
                perfil.getTelefones().set(pos, telefone);
                repository.save(perfil);
            }
        }
        return atualizado;
    }

    @Transactional
    public void removeTelefone(Long idPerfil, Long id) {
        Perfil perfil = busca(idPerfil);
        if (idPerfil != null) {
            Telefone encontrado = null;
            for (Telefone telefone : perfil.getTelefones()) {
                if (telefone.getId().equals(id)) {
                    encontrado = telefone;
                }
            }
            if (encontrado != null) {
                perfil.getTelefones().remove(encontrado);
                repository.save(perfil);
                telefoneRepository.deleteById(id);
            }
        }
    }




/**
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
**/