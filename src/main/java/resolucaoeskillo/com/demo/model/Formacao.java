package resolucaoeskillo.com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Formacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idTipoFormacao")
    private TipoFormacao tipoFormacao;

    @ManyToOne
    @JoinColumn(name = "idAreaEstudo")
    private AreaDeEstudo areaDeEstudo;

    
    private int anoInicio;
    private int anoFim;
    private boolean emAndamento;
    private String descricao;
    




    private List<Experiencia> = new Experiencia<>();
    
    
}
