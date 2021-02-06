package com.gerador_de_observacao.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;

import org.apache.el.lang.ELArithmetic.BigDecimalDelegate;

import com.gerador_de_observacao.Constantes;
import com.gerador_de_observacao.DTO.ComposicaoDTO;
import com.gerador_de_observacao.DTO.ComposicaoDTO;

@org.springframework.stereotype.Service
public class Service {

	String texto;

	
	public String geraObservacao(List notasComposicao, Boolean mostrarValorNota) {
		texto = "";
		if(!notasComposicao.isEmpty()) {
			return retornaCodigos(notasComposicao, mostrarValorNota) + ".";
		}
		return "";
	}


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
				separador = ", ";
			else
				separador = " e ";

			
			mensagemBuilder.append(this.retornaMensagemComOuSemValorTotalNota(separador, composicao, mostrarValorNota)  + calcularTotalNota(composicao));
		}

		return texto + mensagemBuilder;
	}
	
	
	private String retornaMensagemComOuSemValorTotalNota(String separador, ComposicaoDTO composicao, Boolean mostrarValorNota) {
		if(mostrarValorNota) {
			return separador + composicao + this.calcularTotalNota(composicao);
		}else {
			return  separador + composicao;
		}
		
	}
	
	
	private String calcularTotalNota(ComposicaoDTO composicao) {
		if(!composicao.getValorUnitario().isBlank() && !composicao.getQuantidadeComposicao().isBlank()) {
			BigDecimal valorUnitario = new BigDecimal(composicao.getValorUnitario().replace(",", "."));
			BigDecimal quantidade = new BigDecimal(composicao.getQuantidadeComposicao().replace(",", "."));
			BigDecimal totalComposicao = valorUnitario.multiply(quantidade).setScale(2, RoundingMode.HALF_EVEN);;
			return " cujo valor é " + totalComposicao;	
		}
		return "";
	}

}
