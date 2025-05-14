package br.com.itb.miniprojetospring.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Ocorrencia")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Ocorrencia")
    private long id;

    private String descricao;
    private String patrimonio;

    @Lob
    private byte[] anexo;

    private String statusOcorrencia;
    private String dataAbertura;
    private String dataAtendimento;

    @ManyToOne
    @JoinColumn(name = "laboratorio_id", referencedColumnName = "Id_Laboratorio")
    private Laboratorio laboratorio;

    public Ocorrencia() {}

    @PrePersist
    protected void onCreate() {
        this.dataAbertura = LocalDate.now().toString();
        this.statusOcorrencia = "Pendente";
    }

    // ======== GETTERS E SETTERS ========

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

    public String getStatusOcorrencia() {
        return statusOcorrencia;
    }

    public void setStatusOcorrencia(String statusOcorrencia) {
        this.statusOcorrencia = statusOcorrencia;
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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
}
