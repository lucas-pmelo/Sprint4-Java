package br.com.fiap.segurobike.model;
import java.util.ArrayList;
import java.util.Date;
import  java.util.List;

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
@Table(name = "CLIENTE")
public class Cliente {
	
	@Id
	@SequenceGenerator(name = "cliente_sq" , sequenceName = "cliente_sq", allocationSize = 1)
	@GeneratedValue(generator = "cliente_sq")
	@Column(name="ID")
	private Long id;
	@Column(name = "NOME")
    private String nome;
	@Column(name = "CPF")
    private String cpf;
	@Column(name = "CEP")
    private String cep;
	@Column(name = "TELEFONE")
    private String telefone;
	@Column(name = "EMAIL")
    private String email;
	@Column(name = "LOGRADOURO")
    private String logradouro;
	@Column(name = "COMPLEMENTO")
    private String complemento;
	@Temporal(TemporalType.DATE)
	@Column(name = "DATANASCIMENTO")
    private Date dataNascimento;
	@Column(name = "SENHA")
    private String senha;
    
    @OneToMany(mappedBy="cliente")
    private List<Bicicleta> bicicletas = new ArrayList<>();

    public Cliente() {
    	super();
    }
    
    public Cliente(Long id, String nome, String cpf, String cep, String telefone, String email, String logradouro, String complemento, Date dataNascimento, String senha) {
    	super();
        this.id = id;
    	this.nome = nome;
        this.cpf = cpf;
        this.cep = cep;
        this.telefone = telefone;
        this.email = email;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
    }
 
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Bicicleta> getBicicletas() {
		return bicicletas;
	}

	public void setBicicletas(List<Bicicleta> bicicletas) {
		this.bicicletas = bicicletas;
	}

	@Override
    public String toString() {
        return "Cliente:" +
                "\n id='" + id + '\'' +
                "\n nome='" + nome + '\'' +
                "\n cpf='" + cpf + '\'' +
                "\n cep='" + cep + '\'' +
                "\n telefone='" + telefone + '\'' +
                "\n email='" + email + '\'' +
                "\n logradouro='" + logradouro + '\'' +
                "\n complemento='" + complemento + '\'' +
                "\n dataNascimento='" + dataNascimento + '\'' +
                "\n senha='" + senha + '\'' +
                "\n bicicletas=" + bicicletas;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}