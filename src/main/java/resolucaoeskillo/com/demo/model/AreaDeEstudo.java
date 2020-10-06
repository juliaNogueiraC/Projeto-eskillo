package resolucaoeskillo.com.demo.model;
import java.io.Serializable;

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
public class AreaDeEstudo  implements Serializable  {
    
    private static final long serialVersionUID = 1L;

    // 1 atributos basicos 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAreaEstudo")
  private Long id;

  @EqualsAndHashCode.Exclude
  private String descricao;



  // 2 constrrutores 
public AreaDeEstudo(){
    
}

public AreaDeEstudo(Long id , String descricao){
   // pq sao nomes iguais 
    this.id = id;
   this.descricao = descricao;




}



//3 getters e setts

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getDescricao() {
    return descricao;
}

public void setDescricao(String descricao) {
    this.descricao = descricao;
}




// 4 equals e hashcode 
@Override
public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
}




@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    AreaDeEstudo other = (AreaDeEstudo) obj;
    if (descricao == null) {
        if (other.descricao != null)
            return false;
    } else if (!descricao.equals(other.descricao))
        return false;
    if (id == null) {
        if (other.id != null)
            return false;
    } else if (!id.equals(other.id))
        return false;
    return true;
}


// to String 
@Override
public String toString() {
    return "areaDeEstudo [descricao=" + descricao + ", id= ( "+ id +") ]";
}

  


  /* 5 serializable : 
    classe => arq binario (obj -> sequencia de bytes -> arquivo binario )
   e pode fazer o inverso 
   */
  

    
}