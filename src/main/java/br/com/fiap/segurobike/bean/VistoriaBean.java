package br.com.fiap.segurobike.bean;
 
import java.util.List;

import br.com.fiap.segurobike.dto.CotacaoResponseDTO;
import br.com.fiap.segurobike.dto.Imagem; 

public interface VistoriaBean {

	public CotacaoResponseDTO realizarVistoria(Long idApolice, List<Imagem> imagens) throws Exception;

	public CotacaoResponseDTO aprovarVistoria(Long idApolice) throws Exception;

}
