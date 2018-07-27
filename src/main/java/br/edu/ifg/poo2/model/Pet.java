package br.edu.ifg.poo2.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pet {

    @Id
    @Column
    @GeneratedValue
    private Long id;

    @Column(length = 40)
    private String nome;

    @Column(length = 200)
    private String descricao;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Raca raca;

    @Column(name = "data_inclusao")
    private LocalDate dataInclusao;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private Tamanho tamanho;

    @Column(length = 30)
    private String cor;

    @PrePersist
    void createdAt() {
        this.dataInclusao = LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public LocalDate getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(LocalDate dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }
}
