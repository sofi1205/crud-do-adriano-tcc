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

    public Boolean getLida() {
        return lida;
    }

    public void setLida(Boolean lida) {
        this.lida = lida;
    }

    // Outros getters e setters conforme sua necessidade
}
