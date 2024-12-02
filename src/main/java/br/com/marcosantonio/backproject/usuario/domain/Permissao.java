package br.com.marcosantonio.backproject.usuario.domain;

public enum Permissao {
    ADMIN("ADMIN"),
    SECRETARIO("SECRETARIO");

    private final String descricao;

    private Permissao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
