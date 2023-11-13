package br.com.fiap.segurobike.bean.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.fiap.segurobike.bean.ClienteBean;
import br.com.fiap.segurobike.model.Bicicleta;
import br.com.fiap.segurobike.model.Cliente;
import br.com.fiap.segurobike.repository.ClienteRepository;

@Service
public class ClienteBeanImpl implements ClienteBean {

 
	private ClienteRepository  clienteRepository;
	 
	public List<Cliente> consultarTodos() throws Exception {
		
		return this.clienteRepository.findAll();
	}
	 
	@Override
	public Cliente salvarCliente(Cliente cliente) throws Exception   {
	 
		clienteRepository.save(cliente);
		return cliente;
	}
	
	

	@Override
	public Cliente consultarClientePorCPF(String cpf) throws Exception {
		return clienteRepository.findByCpf(cpf);
	}

	@Override
	public Cliente consultarClientePorId(Long idCliente) {
		 
		return clienteRepository.findById(idCliente).orElse(null);
	}

	@Override
	public List<Bicicleta> consultarBicicletas(Long idCliente) {
		 
		return null;
	}

	@Override
	public Bicicleta consultarBicicletaCliente(String numeroSerie) {
	 
		return null;
	}

	@Override
	public void adicionarNovaBiciclata(Bicicleta bicicleta) {
		 
	}

}
