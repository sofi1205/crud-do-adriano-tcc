package br.com.itb.miniprojetospring.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tecnico")
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Tecnico")
    private Long id;

    @Column(name = "rmtecnico", nullable = false, unique = true)
    private String rmtecnico;

    @Column(name = "senha", nullable = false)
    private String senha;

    @Column(name = "is_admin")  // mapeia o campo do banco "is_admin"
    private boolean admin;

    // Construtor vazio
    public Tecnico() {}

    // Getters e Setters
    public String getRmtecnico() { return rmtecnico; }
    public void setRmtecnico(String rmtecnico) { this.rmtecnico = rmtecnico; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public boolean isAdmin() {return admin;}
    public void setAdmin(boolean admin) {this.admin = admin;}
}
