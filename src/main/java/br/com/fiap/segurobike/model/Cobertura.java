package br.com.fiap.segurobike.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COBERTURA")
public class Cobertura {

	@Id
	@SequenceGenerator(name = "cobertura_sq" , sequenceName = "cobertura_sq", allocationSize = 1)
	@GeneratedValue(generator = "cobertura_sq")
	@Column(name="ID")
	private Long id;
	
	@Column(name = "DESCRICAO")
	private String descricao;

	@Column(name = "PERCENTUAL")
	private Double percentual;

	@Column(name = "COBERTURA_BASICA")
	private boolean coberturaBasica;

	public Cobertura() {
		super(); 
	}
	
	public Cobertura(Long id, String descricao, Double percentual, boolean coberturaBasica) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.percentual = percentual;
		this.coberturaBasica = coberturaBasica;
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

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public boolean isCoberturaBasica() {
		return coberturaBasica;
	}

	public void setCoberturaBasica(boolean coberturaBasica) {
		this.coberturaBasica = coberturaBasica;
	}
	
	
}
