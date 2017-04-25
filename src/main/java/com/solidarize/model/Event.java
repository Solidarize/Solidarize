package com.solidarize.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import javax.persistence.SequenceGenerator;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_id_seq")
    @SequenceGenerator(name = "event_id_seq", sequenceName = "event_id_seq", allocationSize = 1)
    private Integer id;
    private String nome;
    private String descricao;
    private int rank;
    private Date data;
    private Institution ins;


    public Event() {
    }

    public Event(Integer id, String nome, String descricao, int rank, Date data, Institution ins) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.rank = rank;
        this.data = data;
        this.ins = ins;
    }

    public Event(String nome, String descricao, int rank, Date data, Institution ins) {
        this.nome = nome;
        this.descricao = descricao;
        this.rank = rank;
        this.data = data;
        this.ins = ins;
    }

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Institution getIns() {
        return ins;
    }

    public void setIns(Institution ins) {
        this.ins = ins;
    }

}
