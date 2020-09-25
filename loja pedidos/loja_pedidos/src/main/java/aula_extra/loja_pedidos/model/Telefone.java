package aula_extra.loja_pedidos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Telefone {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

  // o proprio numero pode ser um id tambem !
 //@id
  private String numero;
 
 // agora ela esta mapeada !


 
}