package br.com.itb.miniprojetospring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Tecnico")
    private Long id;

    @Column(name = "rmtecnico", nullable = false)
    private String rmtecnico;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "is_admin", nullable = false)
    private boolean isAdmin;

    // Construtor vazio
    public Tecnico() {}

    // Getters e Setters
    public String getRmtecnico() { return rmtecnico; }
    public void setRmtecnico(String rmtecnico) { this.rmtecnico = rmtecnico; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public boolean isAdmin() { return isAdmin; }
    public void setAdmin(boolean admin) { this.isAdmin = admin; }

}
