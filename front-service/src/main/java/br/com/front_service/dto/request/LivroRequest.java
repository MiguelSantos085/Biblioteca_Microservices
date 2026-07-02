package br.com.front_service.dto.request;

public class LivroRequest {

    private String titulo;
    private String genero;
    private Integer anoPublicado;
    private Boolean disponivel;
    private Long autorId;

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
