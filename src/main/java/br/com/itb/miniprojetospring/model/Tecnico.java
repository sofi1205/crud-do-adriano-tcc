package br.com.itb.miniprojetospring.model;

import jakarta.persistence.*;

@Entity
@Table(name="Tecnico")
public class Tecnico {

    Tecnico(){

    }

    public Tecnico(long id, String nome){
        this.id = id;
        this.nome = nome;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "Id_Laboratorio")
    private long id;

    private String nome;
    private String descricao;
    private String codigoBarras;
    private byte[] foto;
    private double preco;
    private String categoria;
    private String destaque;
    private String statusProd;

    // CRIAR GETTERS E SETTERS
    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public String getCodigoBarras() {
        return codigoBarras;
    }
    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }
    public byte[] getFoto() {
        return foto;
    }
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getDestaque() {
        return destaque;
    }
    public void setDestaque(String destaque) {
        this.destaque = destaque;
    }
    public String getStatusProd() {
        return statusProd;
    }
    public void setStatusProd(String statusProd) {
        this.statusProd = statusProd;
    }






}
