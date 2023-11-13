package br.com.fiap.segurobike.repository;

import br.com.fiap.segurobike.model.Cliente;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	public Cliente findByCpf(String cpf);

}
