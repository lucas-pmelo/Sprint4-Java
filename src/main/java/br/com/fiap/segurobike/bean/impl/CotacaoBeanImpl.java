package br.com.fiap.segurobike.bean.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fiap.segurobike.bean.CotacaoBean;
import br.com.fiap.segurobike.dto.BicicletaDTO;
import br.com.fiap.segurobike.dto.ClienteDTO;
import br.com.fiap.segurobike.dto.CotacaoDTO;
import br.com.fiap.segurobike.dto.CotacaoResponseDTO;
import br.com.fiap.segurobike.model.Apolice;
import br.com.fiap.segurobike.model.ApoliceCobertura;
import br.com.fiap.segurobike.model.Assistencia;
import br.com.fiap.segurobike.model.AssistenciaCobertura;
import br.com.fiap.segurobike.model.Bicicleta;
import br.com.fiap.segurobike.model.Cliente;
import br.com.fiap.segurobike.repository.ApoliceRepository;
import br.com.fiap.segurobike.repository.AssistenciaCoberturaRepository;
import br.com.fiap.segurobike.repository.AssistenciaRepository;
import br.com.fiap.segurobike.repository.BicicletaRepository;
import br.com.fiap.segurobike.repository.ClienteRepository;

@Service
public class CotacaoBeanImpl implements CotacaoBean {
	@Autowired
	private ClienteRepository clienteRepository ;
	@Autowired
	private BicicletaRepository bicicletaRepository;
	@Autowired
	private AssistenciaRepository assistenciaRepository ;
	@Autowired
	private AssistenciaCoberturaRepository assistenciaCoberturaRepository ;
	@Autowired
	private ApoliceRepository apoliceRepository ;

	@Override
	public CotacaoResponseDTO  cotar(CotacaoDTO cotac) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Cliente cliente = clienteRepository.findByCpf(cotac.getCliente().getCpf());
		if (cliente == null) { 
			cliente = clienteFromDto(cotac.getCliente());
			clienteRepository.save(cliente);
		}
 
		Bicicleta bicicleta = bicicletaRepository.findByNumeroSerieAndCliente_id(cotac.getBicicleta().getNumeroSerie(), cliente.getId());
		if (bicicleta == null) {
			bicicleta = bicicletaFromDTO(cotac.getBicicleta());
			bicicleta.setCliente(cliente);
			bicicletaRepository.save(bicicleta);
		}
		
		Assistencia assistencia = assistenciaRepository.findByDescricao(cotac.getAssistencia());
		if (assistencia != null) {

			Apolice apolice = new Apolice();

			apolice.setCliente(cliente);
			apolice.setBicicleta(bicicleta);
			apolice.setDataInicio(sdf.parse(cotac.getInicioVigencia()));
			apolice.setDataFim(sdf.parse(cotac.getFinalVigencia())); 
			apolice.setAssistencia(assistencia);
			
			calcular(apolice);
			apolice.setStatus("CALCULADO");
			apoliceRepository.save(apolice);
			
			System.out.println("Apolice: " + apolice.getNumero() + " criada com sucesso.");
			
			return new CotacaoResponseDTO(apolice.getNumero(), apolice.getStatus());
		}
		
		return null;
		
	}

	private void calcular(Apolice apolice) throws Exception {
		
		List<AssistenciaCobertura> coberturas = assistenciaCoberturaRepository.findByAssistencia_Id(apolice.getAssistencia().getId());
		
		Double valorImportanciaSegurada = apolice.getBicicleta().getValor();
		
		AssistenciaCobertura coberturaBasica = coberturas.stream().filter(c -> c.getCobertura().isCoberturaBasica()).findFirst().orElse(null);

		apolice.setCoberturas(new ArrayList<>());
		// Cobertura basica 
		Double valorPremio = valorImportanciaSegurada * coberturaBasica.getCobertura().getPercentual() / 100;
		Double vlCalculoCoberturas= 0D;
		
		 
		apolice.getCoberturas().add(new ApoliceCobertura(apolice, coberturaBasica.getCobertura(), valorPremio));
		for (AssistenciaCobertura coberturaAssistencia :  coberturas) {
			if (!coberturaAssistencia.getCobertura().isCoberturaBasica()) {
				Double vlCob =  valorPremio * coberturaAssistencia.getCobertura().getPercentual() / 100;
				vlCalculoCoberturas = vlCalculoCoberturas + vlCob ;
				apolice.getCoberturas().add(new ApoliceCobertura(apolice, coberturaAssistencia.getCobertura(), vlCob));
			}
		}
		
		valorPremio = valorPremio + vlCalculoCoberturas;
		
		apolice.setValorPremio(valorPremio);
		
	}

	@Override
	public CotacaoDTO findCotacao(Long numero) {
		CotacaoDTO cotacao  = new CotacaoDTO();
		
		Apolice apolice = apoliceRepository.findById(numero).orElse(null);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		cotacao.setNumeroCotacao(apolice.getNumero());
		cotacao.setStatus(apolice.getStatus());
		cotacao.setCliente(clienteToDto(apolice.getCliente()));
		cotacao.setBicicleta(bicicletaToDTO(apolice.getBicicleta()));
		cotacao.setInicioVigencia(sdf.format(apolice.getDataInicio()));
		cotacao.setFinalVigencia(sdf.format(apolice.getDataFim()));
		cotacao.setValorPremio(apolice.getValorPremio());
		cotacao.setAssistencia(apolice.getAssistencia().getDescricao());
		return cotacao;
	}
	
	
	public ClienteDTO clienteToDto(Cliente  cliente) {
		ClienteDTO dto = new ClienteDTO();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dto.setNome(cliente.getNome());
		dto.setCpf(cliente.getCpf());
		dto.setCep(cliente.getCep());
		dto.setLogradouro(cliente.getLogradouro());
		dto.setComplemento(cliente.getComplemento());
		dto.setDataNascimento(sdf.format(cliente.getDataNascimento()));
		dto.setTelefone(cliente.getTelefone());
		dto.setSenha(cliente.getSenha());
		
		return dto;
	}
	
	public Cliente clienteFromDto(ClienteDTO  dto) {
		Cliente cliente = new Cliente();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		cliente.setNome(dto.getNome());
		cliente.setCpf(dto.getCpf());
		cliente.setCep(dto.getCep());
		cliente.setLogradouro(dto.getLogradouro());
		cliente.setComplemento(dto.getComplemento());
		try {
			cliente.setDataNascimento(sdf.parse(dto.getDataNascimento()));
		} catch (ParseException e) { 
		}
		cliente.setTelefone(dto.getTelefone());
		cliente.setSenha(dto.getSenha());
		
		return cliente;
	}
	
	public BicicletaDTO bicicletaToDTO(Bicicleta bicicleta) {
		BicicletaDTO dto = new BicicletaDTO();
		dto.setMarca(bicicleta.getMarca());
		dto.setModelo(bicicleta.getModelo());
		dto.setAno(bicicleta.getAno());
		dto.setCor(bicicleta.getCor());
		dto.setNumeroSerie(bicicleta.getNumeroSerie());
		dto.setTipo(bicicleta.getTipo());
		dto.setValor(bicicleta.getValor());
		dto.setEquipamentoAdicional(bicicleta.isEquipamentoAdicional());
		
		return dto;
	}
	
	public Bicicleta  bicicletaFromDTO(BicicletaDTO dto) {
		Bicicleta bicicleta = new Bicicleta();
 
		bicicleta.setMarca(dto.getMarca());
		bicicleta.setModelo(dto.getModelo());
		bicicleta.setAno(dto.getAno());
		bicicleta.setCor(dto.getCor());
		bicicleta.setNumeroSerie(dto.getNumeroSerie());
		bicicleta.setTipo(dto.getTipo());
		bicicleta.setValor(dto.getValor());
		bicicleta.setEquipamentoAdicional(dto.isEquipamentoAdicional());
		
		return bicicleta;
	}

}
