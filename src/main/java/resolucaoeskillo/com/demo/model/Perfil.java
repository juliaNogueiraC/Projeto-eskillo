package resolucaoeskillo.com.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Perfil {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobre;
    private String cargoAtual;


    @ManyToOne
    @JoinColumn(name="idLocalidade")
    private Localidade localidade;


    private String email;
    private String endereco;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private Date dataNascimento;
    private boolean visibilidadePerfil;

    @OneToOne(mappedBy = "perfil")
    private Fotografia fotografia;



    // array das classes de negocio:
    @OneToMany
    @JoinColumn(name = "idPerfil")
    private List<Experiencia> experiencias = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "idPerfil")
    private List<Telefone> telefones = new ArrayList<>();


    @OneToMany
    @JoinColumn(name = "idPerfil")
    private List<Formacao> formacoes = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "idPerfil")
    private List<Curso> cursos = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "idPerfil")
    private List<Competencia> competencias = new ArrayList<>();
}
