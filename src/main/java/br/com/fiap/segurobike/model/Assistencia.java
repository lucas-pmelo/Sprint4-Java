package br.com.fiap.segurobike.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ASSISTENCIA")
public class Assistencia {

	@Id
	@SequenceGenerator(name = "assistencia_sq" , sequenceName = "assistencia_sq", allocationSize = 1)
	@GeneratedValue(generator = "assistencia_sq")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DESCRICAO")
	private String descricao; 
	
	public Assistencia() { 
		super();
	}

	public Assistencia(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	} 
	
}
