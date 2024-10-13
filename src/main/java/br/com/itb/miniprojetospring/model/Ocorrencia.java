package br.com.itb.miniprojetospring.model;

import jakarta.persistence.*;

@Entity
@Table(name="Ocorrencia")
public class Ocorrencia {

    Ocorrencia(){

    }

    public Ocorrencia(long id, String patrimonio){
        this.id = id;
        this.patrimonio = patrimonio;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "Id_Ocorrencia")
    private long id;

    private String descricao;
    private String patrimonio;
    private byte[] anexo;
    private String statusocorrencia;

    // CRIAR GETTERS E SETTERS
    public long getId() {return id;}
    public void setId(long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getPatrimonio() {
        return patrimonio;
    }
    public void setPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }
    public byte[] getAnexo() {
        return anexo;
    }
    public void setAnexo(byte[] anexo) {this.anexo = anexo;}
    public String getStatusocorrencia() {return statusocorrencia;}
    public void setStatusocorrencia(String statusocorrencia) {this.statusocorrencia = statusocorrencia;}






}
