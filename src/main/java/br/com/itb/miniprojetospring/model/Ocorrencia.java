package br.com.itb.miniprojetospring.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dataatendimento", nullable = false)
    private LocalDateTime dataAtendimento;

    @Column(name = "descricao", nullable = false)
    private String descricao;  // Adicionando o campo descricao

    @Column(name = "patrimonio", nullable = false)
    private String patrimonio;  // Adicionando o campo patrimonio

    @Column(name = "status", nullable = false)
    private String status = "PENDENTE";  // Novo campo para controlar o status

    @Column(name = "lida", nullable = false)
    private Boolean lida = false; // Campo para marcar como lida

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(LocalDateTime dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
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

    public Boolean getLida() {
        return lida;
    }

    public void setLida(Boolean lida) {
        this.lida = lida;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
