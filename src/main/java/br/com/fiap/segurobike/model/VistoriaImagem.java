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
@Table(name = "VISTORIA_IMAGEM")
public class VistoriaImagem {
	@Id
	@SequenceGenerator(name = "vistoria_imagem_sq" , sequenceName = "vistoria_imagem_sq", allocationSize = 1)
	@GeneratedValue(generator = "vistoria_imagem_sq")
	@Column(name="ID")
    private Long id; 

    @ManyToOne
    @JoinColumn(name="ID_VISTORIA", nullable=false)
    private Vistoria vistoria;
	
	@Column(name="IMAGEM")
    private byte[] imagem;
	@Column(name="OBSERVACAO")
    private String observacao;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
 
	public Vistoria getVistoria() {
		return vistoria;
	}
	public void setVistoria(Vistoria vistoria) {
		this.vistoria = vistoria;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
  
    
}
