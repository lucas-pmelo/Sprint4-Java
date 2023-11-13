package br.com.fiap.segurobike.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APOLICE_COBERTURAS")
public class ApoliceCobertura {
 
	@EmbeddedId
	private ApoliceCoberturaPK pk;
	
	@ManyToOne
	@JoinColumn(name = "ID_APOLICE", insertable = false, updatable = false)
    private Apolice apolice;

	@ManyToOne
	@JoinColumn(name = "ID_COBERTURA" , insertable = false, updatable = false)
    private Cobertura cobertura;
    
    private Double valor;

    public ApoliceCobertura(Apolice apolice, Cobertura cobertura, Double valor) {
		super();
		pk = new ApoliceCoberturaPK(apolice.getNumero(), cobertura.getId());
		this.apolice = apolice;
		this.cobertura = cobertura;
		this.valor = valor;
	}

	public ApoliceCobertura() {
    	super();
    }

	public Apolice getApolice() {
		return apolice;
	}

	public void setApolice(Apolice apolice) {
		this.apolice = apolice;
	}

	public Cobertura getCobertura() {
		return cobertura;
	}

	public void setCobertura(Cobertura cobertura) {
		this.cobertura = cobertura;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public ApoliceCoberturaPK getPk() {
		return pk;
	}

	public void setPk(ApoliceCoberturaPK pk) {
		this.pk = pk;
	}
     
}
