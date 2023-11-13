package br.com.fiap.segurobike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.segurobike.bean.CotacaoBean;
import br.com.fiap.segurobike.bean.VistoriaBean;
import br.com.fiap.segurobike.dto.CotacaoDTO;
import br.com.fiap.segurobike.dto.CotacaoResponseDTO;
import br.com.fiap.segurobike.dto.Imagem;
import br.com.fiap.segurobike.model.Apolice;

@RestController
@RequestMapping("cotacao")
public class CotacaoController {

	@Autowired
	private CotacaoBean cotacaoBean;

	@Autowired
	private VistoriaBean vistoriaBean;

	@RequestMapping(value = "/consultar/{numero}", method = RequestMethod.GET)
	public CotacaoDTO  contacao(@PathVariable Long numero) throws Exception {
		return cotacaoBean.findCotacao(numero);
	}
	
	@RequestMapping(value = "/cotar", method = RequestMethod.POST)
	public CotacaoResponseDTO cotar(@RequestBody CotacaoDTO cotacaoDTO) throws Exception {
		return cotacaoBean.cotar(cotacaoDTO);
	}
	
	@RequestMapping(value = "/realizar-vistoria/{numero}", method = RequestMethod.POST)
	public CotacaoResponseDTO realizarVistoria(@PathVariable Long numero, @RequestBody List<Imagem> imagens) throws Exception {
		return vistoriaBean.realizarVistoria(numero, imagens);
	}

	@RequestMapping(value = "/aprovar-vistoria/{numero}", method = RequestMethod.GET)
	public CotacaoResponseDTO realizarVistoria(@PathVariable Long numero) throws Exception {
		return vistoriaBean.aprovarVistoria(numero);
	}

}
