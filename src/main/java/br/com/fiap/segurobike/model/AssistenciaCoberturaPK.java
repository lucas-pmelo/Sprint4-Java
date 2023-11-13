package br.com.fiap.segurobike.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AssistenciaCoberturaPK implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	@Column(name = "ID_ASISTENCIA")
	private Long idAssistencia;
	@Column(name = "ID_COBERTURA")
	private Long idCobertura;
	public Long getIdAssistencia() {
		return idAssistencia;
	}
	public void setIdAssistencia(Long idAssistencia) {
		this.idAssistencia = idAssistencia;
	}
	public Long getIdCobertura() {
		return idCobertura;
	}
	public void setIdCobertura(Long idCobertura) {
		this.idCobertura = idCobertura;
	}
	
	
}
