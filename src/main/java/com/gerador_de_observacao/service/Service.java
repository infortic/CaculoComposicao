package com.gerador_de_observacao.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;

import com.gerador_de_observacao.Constantes;
import com.gerador_de_observacao.DTO.ComposicaoDTO;




/**
 * Classe responsável por gerar mensagem de nota fiscal de composição.
 * @author Cleiton Silva
 */
@org.springframework.stereotype.Service
public class Service {

	String texto;

	/**
	  * método respósavel por retornar a mensagem de opservação. 
	  * @param notasComposicao   Lista de ComposicaoDTO.class
	  * @param mostrarValorNota    Boolean necessário para o método descidir se a mensagme vai ser gerada com o valor total do item 
	  * @return String
	  */
	public String geraObservacao(List notasComposicao, Boolean mostrarValorNota) {
		texto = "";
		if(!notasComposicao.isEmpty()) {
			return retornaCodigos(notasComposicao, mostrarValorNota) + ".";
		}
		return "";
	}

	
	/**
	  * método respósavel por construit a mensa mensagem de opservação. 
	  * @param notasComposicao   Lista de ComposicaoDTO.class
	  * @param mostrarValorNota    Boolean necessário para o método descidir se a mensagme vai ser gerada com o valor total do item 
	  * @return String
	  */
	private String retornaCodigos(List notasComposicao, Boolean mostrarValorNota) {
		if (notasComposicao.size() >= Constantes.DOIS) {
			texto = Constantes.TEXTO_MULTIPLAS_NOTAS;
		} else {
			texto = Constantes.TEXTO_NOTA_UNICA;
		}
	
		StringBuilder mensagemBuilder = new StringBuilder();
		Iterator<ComposicaoDTO> iterator = notasComposicao.iterator();
		
		while(iterator.hasNext()) {
			ComposicaoDTO composicao = iterator.next();
			String separador = "";
			if (mensagemBuilder.toString() == null || mensagemBuilder.toString().length() <= 0)
				separador = "";
			else if (iterator.hasNext())
				separador = Constantes.VIRGULA;
			else
				separador = Constantes.E;
			mensagemBuilder.append(this.retornaMensagemComOuSemValorTotalNota(separador, composicao, mostrarValorNota));
		}

		return texto + mensagemBuilder;
	}
	
	/**
	  * método que verifica se o valor total do item deve aparecer na mensagem. 
	  * @param notasComposicao     Lista de ComposicaoDTO.class
	  * @param mostrarValorNota    Boolean necessário para o método descidir se a mensagme vai ser gerada com o valor total do item 
	  * @param separador           serador da itens da mensagem
	  * @return String
	  */
	private String retornaMensagemComOuSemValorTotalNota(String separador, ComposicaoDTO composicao, Boolean mostrarValorNota) {
		if(mostrarValorNota) {
			return separador + composicao + this.calcularTotalItem(composicao);
		}else {
			return  separador + composicao;
		}
		
	}
	
	
	/**
	  * método que calcula o total do item. 
	  * @param composicao     	   objeto do tipo ComposicaoDTO.class
	  * @return String
	  */
	private String calcularTotalItem(ComposicaoDTO composicao) {
		if(!composicao.getValorUnitario().isBlank() && !composicao.getQuantidadeComposicao().isBlank()) {
			BigDecimal valorUnitario = new BigDecimal(composicao.getValorUnitario().replace(",", "."));
			BigDecimal quantidade = new BigDecimal(composicao.getQuantidadeComposicao().replace(",", "."));
			BigDecimal totalComposicao = valorUnitario.multiply(quantidade).setScale(2, RoundingMode.HALF_EVEN);;
			return " cujo valor é " + totalComposicao;	
		}
		return "";
	}

}
