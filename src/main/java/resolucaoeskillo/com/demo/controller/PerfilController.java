package resolucaoeskillo.com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import resolucaoeskillo.com.demo.dto.PerfilDTO;
import resolucaoeskillo.com.demo.model.Competencia;
import resolucaoeskillo.com.demo.model.Curso;
import resolucaoeskillo.com.demo.model.Experiencia;
import resolucaoeskillo.com.demo.model.Formacao;
import resolucaoeskillo.com.demo.model.Perfil;
import resolucaoeskillo.com.demo.model.Telefone;
import resolucaoeskillo.com.demo.services.PerfilService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerfilController {

    @Autowired
    private PerfilService service;

    // Listar
    @GetMapping("/perfis")
    public ResponseEntity<?> lista() {
        List<PerfilDTO> lista = new ArrayList<>();
        for (Perfil perfil:service.lista()) {
            lista.add(convertePerfilParaDto(perfil));
        }
        return ResponseEntity.ok().body(lista);
    }

    // Buscar
    // http://localhost:8080/perfis/123
    @GetMapping("/perfis/{id}")
    public ResponseEntity<?> busca(@PathVariable Long id) {
        Perfil perfil = service.busca(id);
        // Se não encontrar um perfil com o código informado, ele retornar o status 404 (não encontrado - not found)
        if (perfil == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // daqui ele vai embora
        }
        return ResponseEntity.ok().body(convertePerfilParaDto(perfil));
    }

    // Adicionar
    @PostMapping("/perfis")
    public ResponseEntity<?> adiciona(@RequestBody PerfilDTO dto) {
        Perfil perfil = converteDtoParaPerfil(dto);
        Perfil novoPerfil = service.adiciona(perfil);
        PerfilDTO novoDTO = convertePerfilParaDto(novoPerfil);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoDTO);
    }

    // Atualizar
    @PutMapping("/perfis")
    public ResponseEntity<?> atualiza(@RequestBody PerfilDTO dto) {
        Perfil perfil = converteDtoParaPerfil(dto);
        Perfil perfilEncontrado = service.busca(perfil.getId());
        if (perfilEncontrado == null) {
            return ResponseEntity.notFound().build();
        }
        Perfil registro = service.atualiza(perfil);
        PerfilDTO registroDTO = convertePerfilParaDto(registro);
        return ResponseEntity.ok().body(registroDTO);
    }

    // Remover
    @DeleteMapping("/perfis/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id) {
        Perfil perfil = service.busca(id);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        service.remove(id);
        return ResponseEntity.ok().build();
    }

    /*
     * 
     * IMPLEMENTAR AS OPERAÇÕES SOBRE CURSOS
     * 
    **/

    // Listar cursos de um perfil
    // GET - http://localhost:8080/perfis/123/cursos
    @GetMapping("/perfis/{idPerfil}/cursos")
    public ResponseEntity<?> listaCursos(@PathVariable Long idPerfil) {
        List<Curso> lista = service.listaCursos(idPerfil);
        return ResponseEntity.ok().body(lista);
    }

    // Obter um curso de um perfil
    // GET - http://localhost:8080/perfis/123/cursos/10
    @GetMapping("/perfis/{idPerfil}/cursos/{id}")
    public ResponseEntity<?> buscaCurso(@PathVariable Long idPerfil, @PathVariable Long id) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Curso curso = service.buscaCurso(idPerfil, id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(curso);
    }


    // Adicionar curso a um perfil
    // POST - http://localhost:8080/perfis/123/cursos
    @PostMapping("/perfis/{idPerfil}/cursos")
    public ResponseEntity<?> adicionaCurso(@PathVariable Long idPerfil, @RequestBody Curso curso) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Curso novoCurso = service.adicionaCurso(idPerfil, curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCurso);
    }


    // Atualizar curso de um perfil
    // PUT - http://localhost:8080/perfis/123/cursos
    @PutMapping("/perfis/{idPerfil}/cursos")
    public ResponseEntity<?> atualizaCurso(@PathVariable Long idPerfil, @RequestBody Curso curso) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Curso cursoAtualizado = service.atualizaCurso(idPerfil, curso);
        return ResponseEntity.status(HttpStatus.OK).body(cursoAtualizado);
    }

    // Remover um curso de um perfil
    // DELETE - http://localhost:8080/perfis/123/cursos/10
    @DeleteMapping("/perfis/{idPerfil}/cursos/{id}")
    public ResponseEntity<?> removeCurso(@PathVariable Long idPerfil, @PathVariable Long id) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }

        Curso curso = service.buscaCurso(idPerfil, id);
        if (curso == null) {
            return ResponseEntity.notFound().build();
        }
        service.removeCurso(idPerfil, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*
     * 
     * IMPLEMENTAR AS OPERAÇÕES SOBRE EXPERIÊNCIAS
     * 
    **/

    // GET - http://localhost:8080/perfis/123/experiencias
    @GetMapping("/perfis/{idPerfil}/experiencias")
    public ResponseEntity<?> listaExperiencias(@PathVariable Long idPerfil) {
        List<Experiencia> lista = service.listaExperiencias(idPerfil);
        return ResponseEntity.ok().body(lista);
    }

    // GET - http://localhost:8080/perfis/123/experiencias/10
    @GetMapping("/perfis/{idPerfil}/experiencias/{id}")
    public ResponseEntity<?> buscaExperiencia(@PathVariable Long idPerfil, @PathVariable Long id) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Experiencia experiencia = service.buscaExperiencia(idPerfil, id);
        if (experiencia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(experiencia);
    }

    // POST - http://localhost:8080/perfis/123/experiencias
    @PostMapping("/perfis/{idPerfil}/experiencias")
    public ResponseEntity<?> adicionaExperiencia(@PathVariable Long idPerfil, @RequestBody Experiencia experiencia) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Experiencia novo = service.adicionaExperiencia(idPerfil, experiencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // PUT - http://localhost:8080/perfis/123/experiencias
    @PutMapping("/perfis/{idPerfil}/experiencias")
    public ResponseEntity<?> atualizaExperiencia(@PathVariable Long idPerfil, @RequestBody Experiencia experiencia) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Experiencia experienciaAtualizada = service.atualizaExperiencia(idPerfil, experiencia);
        return ResponseEntity.status(HttpStatus.OK).body(experienciaAtualizada);
    }

    // DELETE - http://localhost:8080/perfis/123/experiencias/10
    @DeleteMapping("/perfis/{idPerfil}/experiencias/{id}")
    public ResponseEntity<?> removeExperiencia(@PathVariable Long idPerfil, @PathVariable Long id) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }

        Experiencia experiencia = service.buscaExperiencia(idPerfil, id);
        if (experiencia == null) {
            return ResponseEntity.notFound().build();
        }
        service.removeExperiencia(idPerfil, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*
     * 
     * IMPLEMENTAR AS OPERAÇÕES SOBRE FORMAÇÕES
     * 
    **/

    // GET - http://localhost:8080/perfis/123/formacoes
    @GetMapping("/perfis/{idPerfil}/formacoes")
    public ResponseEntity<?> listaFormacoes(@PathVariable Long idPerfil) {
        List<Formacao> lista = service.listaFormacoes(idPerfil);
        return ResponseEntity.ok().body(lista);
    }

    // GET - http://localhost:8080/perfis/123/formacoes/10
    @GetMapping("/perfis/{idPerfil}/formacoes/{id}")
    public ResponseEntity<?> buscaFormacao(@PathVariable Long idPerfil, @PathVariable Long id) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Formacao formacao = service.buscaFormacao(idPerfil, id);
        if (formacao == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(formacao);
    }

    // POST - http://localhost:8080/perfis/123/formacoes
    @PostMapping("/perfis/{idPerfil}/formacoes")
    public ResponseEntity<?> adicionaFormacao(@PathVariable Long idPerfil, @RequestBody Formacao formacao) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Formacao novo = service.adicionaFormacao(idPerfil, formacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // PUT - http://localhost:8080/perfis/123/formacoes
    @PutMapping("/perfis/{idPerfil}/formacoes")
    public ResponseEntity<?> atualizaFormacao(@PathVariable Long idPerfil, @RequestBody Formacao formacao) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Formacao atualizada = service.atualizaFormacao(idPerfil, formacao);
        return ResponseEntity.status(HttpStatus.OK).body(atualizada);
    }

    // DELETE - http://localhost:8080/perfis/123/formacoes/10
    @DeleteMapping("/perfis/{idPerfil}/formacoes/{id}")
    public ResponseEntity<?> removeFormacao(@PathVariable Long idPerfil, @PathVariable Long id) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }

        Formacao formacao = service.buscaFormacao(idPerfil, id);
        if (formacao == null) {
            return ResponseEntity.notFound().build();
        }
        service.removeFormacao(idPerfil, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*
     * 
     * IMPLEMENTAR AS OPERAÇÕES SOBRE COMPETÊNCIAS
     * 
    **/

    // GET - http://localhost:8080/perfis/123/competencias
    @GetMapping("/perfis/{idPerfil}/competencias")
    public ResponseEntity<?> listaCompetencias(@PathVariable Long idPerfil) {
        List<Competencia> lista = service.listaCompetencias(idPerfil);
        return ResponseEntity.ok().body(lista);
    }

    // GET - http://localhost:8080/perfis/123/competencias/10
    @GetMapping("/perfis/{idPerfil}/competencias/{id}")
    public ResponseEntity<?> buscaCompetencia(@PathVariable Long idPerfil, @PathVariable Long id) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Competencia competencia = service.buscaCompetencia(idPerfil, id);
        if (competencia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(competencia);
    }

    // POST - http://localhost:8080/perfis/123/competencias
    @PostMapping("/perfis/{idPerfil}/competencias")
    public ResponseEntity<?> adicionaCompetencia(@PathVariable Long idPerfil, @RequestBody Competencia competencia) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Competencia nova = service.adicionaCompetencia(idPerfil, competencia);
        return ResponseEntity.status(HttpStatus.CREATED).body(nova);
    }

    // PUT - http://localhost:8080/perfis/123/competencias
    @PutMapping("/perfis/{idPerfil}/competencias")
    public ResponseEntity<?> atualizaCompetencia(@PathVariable Long idPerfil, @RequestBody Competencia competencia) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Competencia atualizada = service.atualizaCompetencia(idPerfil, competencia);
        return ResponseEntity.status(HttpStatus.OK).body(atualizada);
    }

    // DELETE - http://localhost:8080/perfis/123/competencias/10
    @DeleteMapping("/perfis/{idPerfil}/competencias/{id}")
    public ResponseEntity<?> removeCompetencia(@PathVariable Long idPerfil, @PathVariable Long id) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }

        Competencia competencia = service.buscaCompetencia(idPerfil, id);
        if (competencia == null) {
            return ResponseEntity.notFound().build();
        }
        service.removeCompetencia(idPerfil, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*
     * 
     * IMPLEMENTAR AS OPERAÇÕES SOBRE TELEFONES
     * 
    **/

    // GET - http://localhost:8080/perfis/123/telefones
    @GetMapping("/perfis/{idPerfil}/telefones")
    public ResponseEntity<?> listaTelefones(@PathVariable Long idPerfil) {
        List<Telefone> lista = service.listaTelefones(idPerfil);
        return ResponseEntity.ok().body(lista);
    }

    // GET - http://localhost:8080/perfis/123/telefones/10
    @GetMapping("/perfis/{idPerfil}/telefones/{id}")
    public ResponseEntity<?> buscaTelefone(@PathVariable Long idPerfil, @PathVariable Long id) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Telefone telefone = service.buscaTelefone(idPerfil, id);
        if (telefone == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(telefone);
    }

    // POST - http://localhost:8080/perfis/123/telefones
    @PostMapping("/perfis/{idPerfil}/telefones")
    public ResponseEntity<?> adicionaTelefone(@PathVariable Long idPerfil, @RequestBody Telefone telefone) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Telefone novo = service.adicionaTelefone(idPerfil, telefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }

    // PUT - http://localhost:8080/perfis/123/telefones
    @PutMapping("/perfis/{idPerfil}/telefones")
    public ResponseEntity<?> atualizaTelefone(@PathVariable Long idPerfil, @RequestBody Telefone telefone) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }
        Telefone atualizado = service.atualizaTelefone(idPerfil, telefone);
        return ResponseEntity.status(HttpStatus.OK).body(atualizado);
    }

    // DELETE - http://localhost:8080/perfis/123/telefones/10
    @DeleteMapping("/perfis/{idPerfil}/telefones/{id}")
    public ResponseEntity<?> removeTelefone(@PathVariable Long idPerfil, @PathVariable Long id) {
        Perfil perfil = service.busca(idPerfil);
        if (perfil == null) {
            return ResponseEntity.notFound().build();
        }

        Telefone telefone = service.buscaTelefone(idPerfil, id);
        if (telefone == null) {
            return ResponseEntity.notFound().build();
        }
        service.removeTelefone(idPerfil, id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    private Perfil converteDtoParaPerfil(PerfilDTO dto) {
        Perfil perfil = new Perfil();
        perfil.setId(dto.getId());
        perfil.setNome(dto.getNome());
        perfil.setSobre(dto.getSobre());
        perfil.setCargoAtual(dto.getCargoAtual());
        perfil.setEmail(dto.getEmail());
        perfil.setLocalidade(dto.getLocalidade());
        perfil.setEndereco(dto.getEndereco());
        perfil.setComplemento(dto.getComplemento());
        perfil.setBairro(dto.getBairro());
        perfil.setCidade(dto.getCidade());
        perfil.setUf(dto.getUf());
        perfil.setDataNascimento(dto.getDataNascimento());
        return perfil;
    }

    private PerfilDTO convertePerfilParaDto(Perfil perfil) {
        PerfilDTO dto = new PerfilDTO();
        dto.setId(perfil.getId());
        dto.setNome(perfil.getNome());
        dto.setSobre(perfil.getSobre());
        dto.setCargoAtual(perfil.getCargoAtual());
        dto.setEmail(perfil.getEmail());
        dto.setLocalidade(perfil.getLocalidade());
        dto.setEndereco(perfil.getEndereco());
        dto.setComplemento(perfil.getComplemento());
        dto.setBairro(perfil.getBairro());
        dto.setCidade(perfil.getCidade());
        dto.setUf(perfil.getUf());
        dto.setDataNascimento(perfil.getDataNascimento());
        return dto;
    }

}