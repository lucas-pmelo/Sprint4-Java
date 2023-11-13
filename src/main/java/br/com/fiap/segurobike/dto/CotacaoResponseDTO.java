package br.com.fiap.segurobike.dto;

public class CotacaoResponseDTO {

	private Long nroCotacao;

	private String status;

	public CotacaoResponseDTO(Long numero, String status) {
		this.nroCotacao = numero;
		this.status = status;
	}

	public Long getNroCotacao() {
		return nroCotacao;
	}

	public void setNroCotacao(Long nroCotacao) {
		this.nroCotacao = nroCotacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
