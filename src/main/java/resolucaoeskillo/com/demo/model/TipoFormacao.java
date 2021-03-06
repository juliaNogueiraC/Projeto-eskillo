package resolucaoeskillo.com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
//@Table(name ="TipoFormacao")  // cria uma tabela no database com esse nome
@Data @AllArgsConstructor @NoArgsConstructor
public class TipoFormacao {
    

    @Id// define que aqui será a indetificação do tipoFormacao(da classe ne) no databse
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // aqui ele cirar e gerencia esses atributos da entidade mapeado no database 
    @Column(name = "idTipoFormacao")
    private Long id;

    
    @EqualsAndHashCode.Exclude
    private String descricao;

   

}

