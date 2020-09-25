package aula_extra.loja_pedidos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

/*
1. construtor sem parametros
2.gettres e settres 
3.tostring
4.equals e hashcode 

*/


@Entity // aqaui ele fala que a classe é criada cmo entidade no banco de dados
@Data
public class Cliente {
 


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // entidade cliente foi criada !


    private Long id;
    private String nome;
    private String email;
    private String cpfOuCnpj;

    @Enumerated(value = EnumType.STRING)
    private TipoCliente tipo;



   @OneToMany // aqui ele precisa fazer a relacao entre essas entidades 
   @JoinColumn(name = "idCliente")
   // nome dela 
    private List<Telefone> telefones;



    //private List<Pedido> pedidos;
    // comentei pq essas entidades nao estaop mapeadas no banco de dados 



     @OneToMany(mappedBy = "cliente" ) // um cliente para muitos pediddos
    private List<Pedido> pedidos;
}
