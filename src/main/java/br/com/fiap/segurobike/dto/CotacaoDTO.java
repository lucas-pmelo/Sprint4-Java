package br.com.fiap.segurobike.dto;
 

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CotacaoDTO {


	private Long numeroCotacao;

	private String status; 
	private ClienteDTO cliente;
	private BicicletaDTO bicicleta;

	private String assistencia; 
	
	private String inicioVigencia;
	private String finalVigencia;
	
	private Double valorPremio;
	
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public BicicletaDTO getBicicleta() {
		return bicicleta;
	}
	public void setBicicleta(BicicletaDTO bicicleta) {
		this.bicicleta = bicicleta;
	}
	public String getInicioVigencia() {
		return inicioVigencia;
	}
	public void setInicioVigencia(String inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}
	public String getFinalVigencia() {
		return finalVigencia;
	}
	public void setFinalVigencia(String finalVigencia) {
		this.finalVigencia = finalVigencia;
	}
	public String getAssistencia() {
		return assistencia;
	}
	public void setAssistencia(String assistencia) {
		this.assistencia = assistencia;
	}
	public Long getNumeroCotacao() {
		return numeroCotacao;
	}
	public void setNumeroCotacao(Long numeroCotacao) {
		this.numeroCotacao = numeroCotacao;
	}
	public Double getValorPremio() {
		return valorPremio;
	}
	public void setValorPremio(Double valorPremio) {
		this.valorPremio = valorPremio;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	} 
	
}
