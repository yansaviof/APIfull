package com.savtec.projetoAPI.service;

import com.savtec.projetoAPI.DAO.IUsuario;
import com.savtec.projetoAPI.controller.UsuarioController;
import com.savtec.projetoAPI.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private IUsuario repository;
    private PasswordEncoder passwordEncoder;


    public UsuarioService(IUsuario repository){
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> listarUsuario(){
        List<Usuario> lista = (List<Usuario>) repository.findAll();
        return lista;
    }

    public Usuario criarUsuario(Usuario usuario){
        String senha = usuario.getSenha();

        if (senha.length() <= 5){
             return usuario;

        } else {
            String encoderSenha = this.passwordEncoder.encode(usuario.getSenha());
            usuario.setSenha(encoderSenha);
            Usuario usuarioNovo = repository.save(usuario);
            return usuarioNovo;}


    }



    public Usuario editarUsuario(Usuario usuario){
        String encoderSenha = this.passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(encoderSenha);
        Usuario usuarioNovo = repository.save(usuario);
        return usuarioNovo;
    }

    public boolean excluirUsuario(Integer id){
        repository.deleteById(id);
        return true;
    }


    public Boolean validarSenha(Usuario usuario) {
        String senha = repository.getById(usuario.getId()).getSenha();
        Boolean valid = passwordEncoder.matches(usuario.getSenha(), senha);
        return valid;
    }
}
