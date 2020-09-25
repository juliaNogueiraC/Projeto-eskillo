package aula_extra.loja_pedidos.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;


    // relacao de ujm ou mais com produtos 
    // private List<Produto> produtos;
    // comentei pq ainda nao mapeei
 
    

    @OneToMany(mappedBy = "categoria")
    private List<Produto> produtos;
}
