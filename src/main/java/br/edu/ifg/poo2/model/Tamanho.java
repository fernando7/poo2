package br.edu.ifg.poo2.model;

public enum Tamanho {

    PEQUENO("Pequeno"),
    MEDIO("Médio"),
    GRANDE("Grande");

    private String descricao;

    Tamanho(String descricao) {

        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }

    public String getName() {
        return name();
    }
}
