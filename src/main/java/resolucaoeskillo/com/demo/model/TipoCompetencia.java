package resolucaoeskillo.com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @NoArgsConstructor @AllArgsConstructor
public class TipoCompetencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoCompetencia")
    private Long id;

    @EqualsAndHashCode.Exclude
    private String descricao;
    
    
}
