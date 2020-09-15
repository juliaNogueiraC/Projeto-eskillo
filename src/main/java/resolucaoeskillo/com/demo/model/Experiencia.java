package resolucaoeskillo.com.demo.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data @AllArgsConstructor @NoArgsConstructor
public class Experiencia {
     private Long id;
     private String cargo;
     private TipoEmprego tipoEmprego;
     private String nomeEmpresa;
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
