package br.com.fiap.segurobike.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "BICICLETA")
public class Bicicleta {

	@Id
	@SequenceGenerator(name = "bicicleta_sq" , sequenceName = "bicicleta_sq", allocationSize = 1)
	@GeneratedValue(generator = "bicicleta_sq")
	@Column(name="ID")
	private Long id;

    @ManyToOne
    @JoinColumn(name="ID_CLIENTE", nullable=false)
	private Cliente cliente;
	
	@Column(name = "MODELO")
    private String modelo;
	@Column(name = "COR")
    private String cor;
	@Column(name = "MARCA")
    private String marca;
	@Column(name = "ANO")
    private String ano;
	@Column(name = "TIPO")
    private String tipo;
	@Column(name = "NUMEROSERIE")
    private String numeroSerie;
	@Column(name = "VALOR")
    private Double valor;
	@Column(name = "EQUIPAMENTOADICIONAL")
    private boolean equipamentoAdicional;

    public Bicicleta() {
    	super();
    }
    
    public Bicicleta(Long id, Cliente cliente, String modelo, String cor, String marca, String ano, String tipo, String numeroSerie, Double valor, boolean equipamentoAdicional) {
    	super();
    	this.id = id;
    	this.cliente = cliente;
    	this.modelo = modelo;
        this.cor = cor;
        this.marca = marca;
        this.ano = ano;
        this.tipo = tipo;
        this.numeroSerie = numeroSerie;
        this.valor = valor; 
        this.equipamentoAdicional = equipamentoAdicional;
    }

   
    @Override
    public String toString() {
        return "Bicicleta:" +
                "\n    id='" + id + '\'' +
                "\n    idCliente='" + cliente + '\'' +
                "\n    modelo='" + modelo + '\'' +
                "\n    cor='" + cor + '\'' +
                "\n    marca='" + marca + '\'' +
                "\n    ano=" + ano +
                "\n    tipo='" + tipo + '\'' +
                "\n    numeroSerie='" + numeroSerie + '\'' +
                "\n    valor=" + valor +
                "\n    equipamentoAdicional=" + equipamentoAdicional;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

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
