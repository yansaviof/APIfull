package com.savtec.projetoAPI.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="id")
    private Integer id;



    @Size(min = 3, message = "Precisa de no mínimo 3 caracteres")
    @NotBlank(message = "O Nome é obrigatório")
    @Column(name="nome", length = 200, nullable = true)
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Column(name="email", length = 50, nullable = true)
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    @Column(name="senha", columnDefinition = "TEXT", nullable = true)
    private String senha;


    @NotBlank(message = "O telefone é obrigatório")
    @Column(name="telefone",length = 15, nullable = true)
    private String telefone;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
