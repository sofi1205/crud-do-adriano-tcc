package br.com.itb.miniprojetospring.model;

import jakarta.persistence.*;

@Entity
@Table(name="Laboratorio")
public class Laboratorio {

	Laboratorio(){

	}

	public Laboratorio(long id, String sala){
		this.id = id;
		this.sala = sala;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "Id_Laboratorio")
	private long id;

	private String sala;
	private String andar;

	// CRIAR GETTERS E SETTERS
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public String getAndar() {
		return andar;
	}
	public void setAndar(String andar) {
		this.andar = andar;
	}


}
