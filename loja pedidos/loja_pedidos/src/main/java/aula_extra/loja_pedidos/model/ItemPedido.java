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
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @ManyToOne 
   @JoinColumn(name = "idProduto")
    private Produto produto;

    
    private Integer quantidade;
    private BigDecimal preco;
    private BigDecimal desconto;

    
}
