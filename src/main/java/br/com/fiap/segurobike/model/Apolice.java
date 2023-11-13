package br.com.fiap.segurobike.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "APOLICE")
public class Apolice {
	@Id
	@SequenceGenerator(name = "apolice_sq" , sequenceName = "apolice_sq", allocationSize = 1)
	@GeneratedValue(generator = "apolice_sq")
	@Column(name="NUMERO")
    private Long numero;

	@ManyToOne
	@JoinColumn(name = "IDCLIENTE")
    private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "IDBICICLETA")
    private Bicicleta bicicleta;
	
	@ManyToOne
	@JoinColumn(name = "ID_ASSISTENCIA")
    private Assistencia assistencia;

	@Column(name = "DATAINICIO")
	@Temporal(TemporalType.DATE)
    private Date dataInicio;
	
	@Column(name = "DATAFIM")
	@Temporal(TemporalType.DATE)
    private Date dataFim;

	@Column(name = "VALORPREMIO")
    private Double valorPremio;  
	
	@Column(name = "STATUS")
    private String status; 
    
	@OneToMany(mappedBy="apolice")
    private List<ApoliceCobertura> coberturas;
    
    public Apolice(){
    	super();
    }

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Bicicleta getBicicleta() {
		return bicicleta;
	}

	public void setBicicleta(Bicicleta bicicleta) {
		this.bicicleta = bicicleta;
	}

	public Assistencia getAssistencia() {
		return assistencia;
	}

	public void setAssistencia(Assistencia assistencia) {
		this.assistencia = assistencia;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
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

	public List<ApoliceCobertura> getCoberturas() {
		return coberturas;
	}

	public void setCoberturas(List<ApoliceCobertura> coberturas) {
		this.coberturas = coberturas;
	}
  
}
