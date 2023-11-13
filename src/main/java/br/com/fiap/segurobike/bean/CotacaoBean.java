package br.com.fiap.segurobike.bean;

import br.com.fiap.segurobike.dto.CotacaoDTO;
import br.com.fiap.segurobike.dto.CotacaoResponseDTO;

public interface CotacaoBean {
	public CotacaoDTO findCotacao(Long numero);

	public CotacaoResponseDTO cotar(CotacaoDTO cotac)  throws Exception;

}
