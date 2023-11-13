package br.com.fiap.segurobike.dto;

public class BicicletaDTO {

    private String modelo;
    private String cor;
    private String marca;
    private String ano;
    private String tipo;
    private String numeroSerie;
    private Double valor;
    private boolean equipamentoAdicional;
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public boolean isEquipamentoAdicional() {
		return equipamentoAdicional;
	}
	public void setEquipamentoAdicional(boolean equipamentoAdicional) {
		this.equipamentoAdicional = equipamentoAdicional;
	}
    
    
}
