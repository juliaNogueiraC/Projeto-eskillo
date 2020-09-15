package resolucaoeskillo.com.demo.model;


import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Formacao {
    private Long id;
    private TipoFormacao tipoFormacao;
    private AreaDeEstudo areaDeEstudo;
    private int anoInicio;
    private int anoFim;
    private boolean emAndamento;
    private String descricao;
    




    private List<Experiencia> = new Experiencia<>();
    
    
}
