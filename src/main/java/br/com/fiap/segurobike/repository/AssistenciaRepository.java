package br.com.fiap.segurobike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.segurobike.model.Assistencia;

@Repository
public interface AssistenciaRepository extends JpaRepository<Assistencia, Long> {

	Assistencia findByDescricao(String assistencia);

}
