package br.com.fiap.segurobike.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ApoliceCoberturaPK  implements Serializable{
	 
	private static final long serialVersionUID = 1L;

	@Column(name = "ID_APOLICE")
    private Long numeroApolice;
	@Column(name = "ID_COBERTURA")
    private Long idCobertura;
	
	 
	public ApoliceCoberturaPK(Long numeroApolice, Long idCobertura) {
		super();
		this.numeroApolice = numeroApolice;
		this.idCobertura = idCobertura;
	}
	public Long getNumeroApolice() {
		return numeroApolice;
	}
	public void setNumeroApolice(Long numeroApolice) {
		this.numeroApolice = numeroApolice;
	}
	public Long getIdCobertura() {
		return idCobertura;
	}
	public void setIdCobertura(Long idCobertura) {
		this.idCobertura = idCobertura;
	}
	
}
