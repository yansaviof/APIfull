package com.savtec.projetoAPI.DAO;

import com.savtec.projetoAPI.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.yaml.snakeyaml.events.Event;

import java.util.Optional;

public interface IUsuario  extends CrudRepository<Usuario, Integer> {

    Usuario getById(Integer id);


    Usuario getByEmail(String email);


    Optional<Usuario> findByLogin(String username);
}
