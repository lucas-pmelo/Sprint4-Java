package br.com.fiap.segurobike.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ASSISTENCIA_COBERTURA")
public class AssistenciaCobertura {

	@EmbeddedId
	AssistenciaCoberturaPK pk;
	
	@ManyToOne
	@JoinColumn(name = "ID_COBERTURA", insertable = false, updatable = false)
    private Assistencia assistencia; 
	
	@ManyToOne
	@JoinColumn(name = "ID_COBERTURA", insertable = false, updatable = false)
    private Cobertura cobertura;

	public AssistenciaCobertura() {
		super(); 
	}

	public AssistenciaCoberturaPK getPk() {
		return pk;
	}

	public void setPk(AssistenciaCoberturaPK pk) {
		this.pk = pk;
	}

	public Assistencia getAssistencia() {
		return assistencia;
	}

	public void setAssistencia(Assistencia assistencia) {
		this.assistencia = assistencia;
	}

	public Cobertura getCobertura() {
		return cobertura;
	}

	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	} 
	
}
