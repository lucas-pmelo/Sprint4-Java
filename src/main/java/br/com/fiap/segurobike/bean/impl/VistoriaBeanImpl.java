package br.com.fiap.segurobike.bean.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.segurobike.bean.VistoriaBean;
import br.com.fiap.segurobike.dto.CotacaoResponseDTO;
import br.com.fiap.segurobike.dto.Imagem;
import br.com.fiap.segurobike.model.Apolice;
import br.com.fiap.segurobike.model.Vistoria;
import br.com.fiap.segurobike.model.VistoriaImagem;
import br.com.fiap.segurobike.repository.ApoliceRepository;
import br.com.fiap.segurobike.repository.VistoriaRepository;

@Service
public class VistoriaBeanImpl implements VistoriaBean {

	@Autowired
	private VistoriaRepository vistoriaRepository;

	@Autowired
	private ApoliceRepository apoliceRepository;
	
	@Override
	public CotacaoResponseDTO realizarVistoria(Long idApolice, List<Imagem> imagens) throws Exception {

		
		Apolice apolice =   apoliceRepository.findById(idApolice).get();
		
		Vistoria vistoria = vistoriaRepository.findByIdApolice(idApolice);
		if (vistoria == null) {
			vistoria =  new Vistoria();
		}
		
		vistoria.setData(new Date());
		vistoria.setIdApolice(apolice.getNumero()); 
		vistoria.setResultado("EM ANALISE");
		vistoria.setFotos(new ArrayList<>());
		for (Imagem imagem : imagens) {
			VistoriaImagem vistoriaImagem = new VistoriaImagem();
			vistoriaImagem.setVistoria(vistoria);
			vistoriaImagem.setObservacao(imagem.getObservacao());
			vistoriaImagem.setImagem(DatatypeConverter.parseBase64Binary(imagem.getImagem()));
			vistoria.getFotos().add(vistoriaImagem);
		}
		vistoria = vistoriaRepository.save(vistoria);
		
		apolice.setStatus("LAUDO");
		apoliceRepository.save(apolice);
		
		return new CotacaoResponseDTO(apolice.getNumero(), apolice.getStatus());
	}
	
	@Override
	public CotacaoResponseDTO aprovarVistoria(Long idApolice) throws Exception {
		
		Apolice apolice = apoliceRepository.findById(idApolice).get();
		Vistoria vistoria= vistoriaRepository.findByIdApolice(idApolice);
		
		vistoria.setResultado("APROVADO");
		vistoriaRepository.save(vistoria);
		
		apolice.setStatus("APOLICE");
		apoliceRepository.save(apolice);

		return new CotacaoResponseDTO(apolice.getNumero(), apolice.getStatus());
	}

}
