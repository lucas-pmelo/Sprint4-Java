package br.com.fiap.segurobike.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.segurobike.model.Bicicleta;

@Repository
public interface BicicletaRepository extends JpaRepository<Bicicleta, Long> {

	Bicicleta findByNumeroSerieAndCliente_id(String numeroSerie, Long id);

}
