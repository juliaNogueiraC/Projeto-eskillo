package aula_extra.loja_pedidos.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;


     private String nome;
     private BigDecimal preco;

 // pq um ou mais produtos pode pertecer as categorias 
 // relacoes entre eles 
   

 
 @ManyToOne // varios produtos para uma categoria
 @JoinColumn(name = "idCategoria")   
 private Categoria categorias;
      
}
