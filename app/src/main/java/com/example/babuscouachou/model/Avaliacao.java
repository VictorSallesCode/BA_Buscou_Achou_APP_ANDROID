package com.exemplo.babuscouachou.model;

public class Avaliacao {
    private int id;
    private int idUsuario; // Quem fez a avaliação
    private String nomeLocal; // No futuro, virá do Google Maps API
    private float estrelas; // 1 a 5
    private String comentario;
    private String caminhoFoto; // Caminho da imagem salva no celular

    public Avaliacao() {}

    public Avaliacao(int idUsuario, String nomeLocal, float estrelas, String comentario) {
        this.idUsuario = idUsuario;
        this.nomeLocal = nomeLocal;
        this.estrelas = estrelas;
        this.comentario = comentario;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getNomeLocal() { return nomeLocal; }
    public void setNomeLocal(String nomeLocal) { this.nomeLocal = nomeLocal; }

    public float getEstrelas() { return estrelas; }
    public void setEstrelas(float estrelas) { this.estrelas = estrelas; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public String getCaminhoFoto() { return caminhoFoto; }
    public void setCaminhoFoto(String caminhoFoto) { this.caminhoFoto = caminhoFoto; }
}