package resolucaoeskillo.com.demo.model;

import lombok.Data;

@Data
public class Fotografia {

    private Long id;
    private byte[] fotografia;
    private String tipoArquivo;
    
}