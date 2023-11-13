package br.com.fiap.segurobike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.segurobike.model.Apolice;

@Repository
public interface ApoliceRepository extends JpaRepository<Apolice, Long> {

}
