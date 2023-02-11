package com.savtec.projetoAPI.service;

import com.savtec.projetoAPI.DAO.IUsuario;
import com.savtec.projetoAPI.data.DetalheUsuarioData;
import com.savtec.projetoAPI.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {


    private final IUsuario repository;

    public DetalheUsuarioServiceImpl(IUsuario repository) {
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByLogin(username);
        if(usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuario ["+ username + "] não encontrado");
        }

        return  new DetalheUsuarioData(usuario);
    }
}
