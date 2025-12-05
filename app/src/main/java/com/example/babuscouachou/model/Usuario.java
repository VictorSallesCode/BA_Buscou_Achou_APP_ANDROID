package com.exemplo.babuscouachou.model;

public class Usuario {
    private int id;
    private String nome;
    private String telefone; // Será o nosso Login
    private String email;
    private String senha;

    // Construtor vazio
    public Usuario() { }

    // Construtor completo
    public Usuario(String nome, String telefone, String email, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    // Getters e Setters (Necessários para acessar e modificar os dados)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}