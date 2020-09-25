package aula_extra.loja_pedidos.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Pedido {

// relacao de um cliente para muitos pedidos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    
    @ManyToOne// relacao de muitos pediddos para um cliente 
    private Cliente cliente ;



    private Date data; // data do pedido 
    

    @OneToMany // um pedido para varios itens
    @JoinColumn(name = "idPedido")
    private List<ItemPedido> itens;
    
    
}
