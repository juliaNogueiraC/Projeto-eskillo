package resolucaoeskillo.com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import resolucaoeskillo.com.demo.services.PerfilService;

@RestController
public class PerfilController {

    @Autowired
    private PerfilService service;

    @GetMapping("/perfil")
    
    
    
}
