package br.com.fiap.segurobike.repository;

import org.springframework.stereotype.Repository;

import br.com.fiap.segurobike.model.Cobertura;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CoberturaRepository extends JpaRepository<Cobertura, Long> {

}
