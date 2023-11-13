package br.com.fiap.segurobike.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VISTORIA")
public class Vistoria {
	@Id
	@SequenceGenerator(name = "cliente_sq" , sequenceName = "cliente_sq", allocationSize = 1)
	@GeneratedValue(generator = "cliente_sq")
	@Column(name="ID")
    private Long id;
	@Column(name="ID_APOLICE")
    private Long idApolice;
	@Column(name="DATA")
	@Temporal(TemporalType.TIMESTAMP)
    private Date data;
	@Column(name="RESULTADO")
    private String resultado;
	@Column(name="OBSERVACAO")
    private String observacao; 

    @OneToMany(mappedBy="vistoria", cascade = CascadeType.ALL)
    private List<VistoriaImagem> fotos;
    
     
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdApolice() {
		return idApolice;
	}
	public void setIdApolice(Long idApolice) {
		this.idApolice = idApolice;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public List<VistoriaImagem> getFotos() {
		return fotos;
	}
	public void setFotos(List<VistoriaImagem> fotos) {
		this.fotos = fotos;
	}
    
    
}
