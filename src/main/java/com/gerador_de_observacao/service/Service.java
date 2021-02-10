package com.gerador_de_observacao.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.gerador_de_observacao.Constantes;
import com.gerador_de_observacao.DTO.ComposicaoDTO;
import com.gerador_de_observacao.DTO.ComposicaoFinalDTO;
import com.gerador_de_observacao.DTO.ComposicaoRetornoDTO;

/**
 * Classe responsável por gerar mensagem de nota fiscal de composição.
 * @author Cleiton Silva
 */
@org.springframework.stereotype.Service
public class Service {

	String texto;
	
	private static ComposicaoDTO[] composicaoDTOList = ComposicaoDTO.getListComposicaoDTO();
	private static List<ComposicaoRetornoDTO> composicaoDTOArrayList = new ArrayList<ComposicaoRetornoDTO>(); 
	private static List<Long> codigoComposisaoList = new ArrayList<Long>();
	
	
	  /**
	  * método respósavel por retornar a mensagem de opservação. 
	  * @param notasComposicao Lista de ComposicaoDTO.class
	  * @param mostrarValorNota Boolean necessário para o método descidir se a mensagme vai ser gerada com o valor total do item 
	  * @return String
	  **/
	public static void  run() {
		retornaListaComCalculoIdividualDaComposicao();
	}
	
	private static void retornaListaComCalculoIdividualDaComposicao() {
		for(ComposicaoDTO composicao : composicaoDTOList) {  
			if(!composicao.getValorUnitario().isBlank() && !composicao.getQuantidadeComposicao().isBlank()) {
					ComposicaoRetornoDTO composicaoRetornoDTO = ComposicaoRetornoDTO.getInstance();
					composicaoRetornoDTO.setCodigoComposicao(composicao.getCodigoComposicao());
					composicaoRetornoDTO.setCodigoItem(composicao.getCodigoItem());
					composicaoRetornoDTO.setDescricaoComposicao(composicao.getDescricaoComposicao());
					composicaoRetornoDTO.setQuantidadeComposicao(composicao.getQuantidadeComposicao());
					composicaoRetornoDTO.setUnidadeComposicao(composicao.getUnidadeComposicao());
					composicaoRetornoDTO.setValorUnitario(composicao.getValorUnitario());
					BigDecimal valorUnitario = new BigDecimal(composicao.getValorUnitario().replace(",", "."));
					BigDecimal quantidade = new BigDecimal(composicao.getQuantidadeComposicao().replace(",", "."));
					composicaoRetornoDTO.setValorTotal(valorUnitario.multiply(quantidade));
					composicaoDTOArrayList.add(composicaoRetornoDTO);
			}
			
			List<Long> longs = new ArrayList<Long>();
			longs.add(composicao.getCodigoComposicao());
			for(Long l : longs) {
				if(!codigoComposisaoList.contains(l))
					codigoComposisaoList.add(l);
			}
		}   
		
	}
	
	public static void calculaTotalComposicao(Long codComposicao) {
		for(ComposicaoRetornoDTO composicaoComTotalUnitario : composicaoDTOArrayList) {
			
		}
	}
	
}
