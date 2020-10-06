package resolucaoeskillo.com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.EqualsAndHashCode;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = {"numero", "tipo"})
public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numero;

    @Enumerated(value = EnumType.STRING)
    private TipoTelefone tipo;
    
}
