package resolucaoeskillo.com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Localidade {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLocalidade") // aqui ele diz que vai criar esse campo com esse nome 
    private Long id;
    
    @EqualsAndHashCode.Exclude
    private String nome;
    
    @EqualsAndHashCode.Exclude
    private String uf;

    @Override
    public String toString() {
        return "Localidade [id=" + id + ", nome=" + nome + ", uf=" + uf + "]";
    }
    
}