package resolucaoeskillo.com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import resolucaoeskillo.com.demo.model.Perfil;
import resolucaoeskillo.com.demo.services.PerfilService;

@RestController
public class PerfilController {

    @Autowired
    private PerfilService service;

    // listar
    
   @GetMapping("/perfis")
 public List<Perfil> lista(){
     //return service.lista();
     return ResponseEntity<?>.ok().body(lista);

 }

     // buscar
     @GetMapping("/perfis/{id}")
      public ResponseEntity  <?> busca(@PathVariable long id){
           Perfil perfil = service.busca(id);

           if (perfil == null){
               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

           }
           return ResponseEntity.ok().body(perfil);
           
      }
    

 //adicionar
 @PostMapping("/perfis")
 public ResponseEntity<?> adciona(Perfil perfil){
     Perfil novoPerfil = service.adiciona(perfil);
     return ResponseEntity.status(HttpStatus.CREATED).body(novoPerfil);

 }


 // atualiza
 @PutMapping("/perfis")
 public ResponseEntity<?> atualiza(@RequestBody Perfil Perfil){
    Perfil registro = service.atualiza(perfil);
    return ResponseEntity.ok().body(registro);
    

 }

     // remover
     @DeleteMapping("/perfis/{id}")
     public ResponseEntity<?> remove(@PathVariable Long id){
         service.remove(id);
         return ResponseEntity.ok().build();
         
     }
     
    
    
}
