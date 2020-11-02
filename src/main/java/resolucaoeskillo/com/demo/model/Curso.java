package resolucaoeskillo.com.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(exclude = {"organizacao", "cargaHoraria", "dataInicio", "dataFim", "descricao"})
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String organizacao;
    private int cargaHoraria;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Americas/Fortaleza")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="Americas/Fortaleza")
    @Temporal(TemporalType.DATE)
    private Date dataFim;

    private String descricao;

}
