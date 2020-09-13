package resolucaoeskillo.com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Localidade {
    
    private Long id;
    
    @EqualsAndHashCode.Exclude
    private String nome;
    
    @EqualsAndHashCode.Exclude
    private String uf;
    
}