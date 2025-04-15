package br.com.itb.miniprojetospring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Ocorrencia")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Ocorrencia")
    private long id;

    private String descricao;
    private String patrimonio;
    private byte[] anexo;
    private String statusocorrencia;
    private String dataAbertura;
    private String dataAtendimento;
    private String statusOcorrencia;

    @ManyToOne
    @JoinColumn(name = "laboratorio_id", referencedColumnName = "Id_Laboratorio")
    private Laboratorio laboratorio; // Adiciona referência ao Laboratório

    public Ocorrencia() {
    }

    // Getters e Setters
    public long getId() {
        return id;
    }

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

    public void setAnexo(byte[] anexo) {
        this.anexo = anexo;
    }

    public String getStatusocorrencia() {
        return statusocorrencia;
    }

    public void setStatusocorrencia(String statusocorrencia) {
        this.statusocorrencia = statusocorrencia;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(String dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public String getStatusOcorrencia() {
        return statusOcorrencia;
    }

    public void setStatusOcorrencia(String statusOcorrencia) {
        this.statusOcorrencia = statusOcorrencia;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
}
