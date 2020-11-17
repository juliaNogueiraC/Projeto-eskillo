package resolucaoeskillo.com.demo.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import resolucaoeskillo.com.demo.model.Perfil;
import resolucaoeskillo.com.demo.repositories.PerfilRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PerfilRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        List<Perfil> lista = repository.findByEmail(email);
        if (lista.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }
        Perfil perfil = lista.get(0);
        return new UserDetailsPerfil(perfil.getId(), perfil.getEmail(), perfil.getSenha(), null);
    }
    
}