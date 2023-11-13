package br.com.fiap.segurobike.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.segurobike.model.AssistenciaCobertura;
import br.com.fiap.segurobike.model.AssistenciaCoberturaPK;

@Repository
public interface AssistenciaCoberturaRepository extends JpaRepository<AssistenciaCobertura, AssistenciaCoberturaPK> {

	List<AssistenciaCobertura> findByAssistencia_Id(Long id);

}
