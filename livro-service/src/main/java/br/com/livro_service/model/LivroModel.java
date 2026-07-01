package br.com.livro_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Livros")
public class LivroModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(nullable = false, length = 60)
    private String genero;

    @Column(nullable = false)
    private Integer anoPublicado;

    @Column(nullable = false)
    private Boolean disponivel;

    @Column(nullable = false)
    private Long autorId;

    public LivroModel(Long id, String titulo, String genero, Integer anoPublicado, Boolean disponivel, Long autorId) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anoPublicado = anoPublicado;
        this.disponivel = disponivel;
        this.autorId = autorId;
    }

    public LivroModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnoPublicado() {
        return anoPublicado;
    }

    public void setAnoPublicado(Integer anoPublicado) {
        this.anoPublicado = anoPublicado;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Long getAutorId() {
        return autorId;
    }

    public void setAutorId(Long autorId) {
        this.autorId = autorId;
    }
}
