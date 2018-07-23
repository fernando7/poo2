package br.edu.ifg.poo2.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Animal {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 40)
    private String nome;

    @Column(length = 200)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Raca raca;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_inclusao")
    private Date dataInclusao;

    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private Tamanho tamanho;

    @PrePersist
    void createdAt() {
        this.dataInclusao = new Date();
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Raca getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
