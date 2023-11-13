package br.com.fiap.segurobike.bean;

import java.util.List;

import br.com.fiap.segurobike.model.Bicicleta;
import br.com.fiap.segurobike.model.Cliente;

public interface ClienteBean {

	public List<Cliente> consultarTodos() throws Exception;
	
	public Cliente salvarCliente(Cliente cliente) throws Exception;
	
	public Cliente consultarClientePorCPF(String cpf) throws Exception;
	
	public Cliente consultarClientePorId(Long idCliente) throws Exception;
	
	public List<Bicicleta> consultarBicicletas(Long idCliente);
	
	public Bicicleta consultarBicicletaCliente(String numeroSerie);
	
	public void adicionarNovaBiciclata(Bicicleta bicicleta);
	
}
