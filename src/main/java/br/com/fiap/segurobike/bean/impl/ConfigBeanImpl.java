package br.com.fiap.segurobike.bean.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.segurobike.bean.ConfigBean;
import br.com.fiap.segurobike.model.Assistencia;
import br.com.fiap.segurobike.model.AssistenciaCobertura;
import br.com.fiap.segurobike.model.AssistenciaCoberturaPK;
import br.com.fiap.segurobike.model.Cobertura;
import br.com.fiap.segurobike.repository.AssistenciaCoberturaRepository;
import br.com.fiap.segurobike.repository.AssistenciaRepository;
import br.com.fiap.segurobike.repository.CoberturaRepository;

@Service
public class ConfigBeanImpl implements ConfigBean {
	@Autowired
	private AssistenciaRepository assistenciaRepository; 
	@Autowired
	private CoberturaRepository coberturaRepository; 
	@Autowired
	private AssistenciaCoberturaRepository assistenciaCoberturaRepository; 
	
	/**
	 * Inicia com os valores iniciais as tabelas Assistencia, Cobertura, Assistencia Cobertura e Corretor
	 */
	@Override
	public void iniciarBancoDeDados() throws Exception {


		Assistencia assistenciaBasica = null;
		Assistencia assistenciaIntermediaria = null;
		Assistencia assistenciaVIP = null;
		  
		List<Assistencia> assistencias = assistenciaRepository.findAll();
		if (assistencias == null || assistencias.isEmpty()) {
			

			//----------------------------------------------// -------------------------------
			Cobertura cobertura1 = new Cobertura(1L , "Cobertura Basica 1", 100D, true); 
			coberturaRepository.save(cobertura1);
			
			Cobertura cobertura2 = new Cobertura(2L , "Cobertura 2", 30D, false); 
			coberturaRepository.save(cobertura2);
			
			Cobertura cobertura3 = new Cobertura(3L , "Cobertura 3", 5D, false); 
			coberturaRepository.save(cobertura3);
			
			//----------------------------------------------// -------------------------------
			assistenciaBasica = new Assistencia(1L, "Basica");
			assistenciaRepository.save(assistenciaBasica);
			
			assistenciaIntermediaria = new Assistencia(2L, "Intermediaria");
			assistenciaRepository.save(assistenciaIntermediaria);
			
			assistenciaVIP = new Assistencia(3L, "VIP");
			assistenciaRepository.save(assistenciaVIP);
			
			//----------------------------------------------// -------------------------------
			 
			criarNovaAssistenciaCobertura(assistenciaBasica, cobertura1);

			criarNovaAssistenciaCobertura(assistenciaIntermediaria, cobertura1);
			criarNovaAssistenciaCobertura(assistenciaIntermediaria, cobertura2);

			criarNovaAssistenciaCobertura(assistenciaVIP, cobertura1);
			criarNovaAssistenciaCobertura(assistenciaVIP, cobertura2);
			criarNovaAssistenciaCobertura(assistenciaVIP, cobertura3);
		 
		}
	}
	
	
	private AssistenciaCobertura criarNovaAssistenciaCobertura(Assistencia assistencia, Cobertura cobertura) {
		AssistenciaCobertura assistenciaCobertura = new AssistenciaCobertura();
		AssistenciaCoberturaPK assistenciaCoberturPK = new AssistenciaCoberturaPK();
		assistenciaCoberturPK.setIdAssistencia(assistencia.getId());
		assistenciaCoberturPK.setIdCobertura(cobertura.getId());
		assistenciaCobertura.setPk(assistenciaCoberturPK);
		
		assistenciaCobertura.setAssistencia(assistencia);
		assistenciaCobertura.setCobertura(cobertura); 
		assistenciaCoberturaRepository.save(assistenciaCobertura);
		return assistenciaCobertura;
	}

}
