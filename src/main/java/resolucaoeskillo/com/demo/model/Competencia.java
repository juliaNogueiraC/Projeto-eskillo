package resolucaoeskillo.com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Competencia {

    private Long id;
    private TipoCompetencia tipoCompetencia;
    
}