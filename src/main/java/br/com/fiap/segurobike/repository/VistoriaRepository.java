package br.com.fiap.segurobike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.segurobike.model.Vistoria;

@Repository
public interface VistoriaRepository extends JpaRepository<Vistoria, Long>{

	Vistoria findByIdApolice(Long idApolice);

}
