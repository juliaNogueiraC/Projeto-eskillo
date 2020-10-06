package resolucaoeskillo.com.demo.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Experiencia {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String cargo;

     @Enumerated(value = EnumType.STRING)
     private TipoEmprego tipoEmprego;


     private String nomeEmpresa;

     @ManyToOne
    @JoinColumn(name = "idLocalidade")
     private Localidade localidade;

     
     private Date dataInicio;
     private Date dataFim;
     private boolean ocupacaoAtual;
     private String descricao;
 
 
/*  
private List<Experiencia> experiencias = new ArrayList<>()
private List <Telefone> telefone = new ArrayList<>()
Form
curso
comp
 */
}
