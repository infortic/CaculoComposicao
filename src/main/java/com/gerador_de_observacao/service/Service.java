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
import com.gerador_de_observacao.DTO.ComposicaoComCalculoQuantidadeXvaLorDTO;

/**
 * Classe responsável por fornecer serviço para calculo de composições de itens.
 * 
 * @author Cleiton Silva
 */
@org.springframework.stereotype.Service
public class Service {

	String texto;

	private static ComposicaoDTO[] composicaoDTOList = ComposicaoDTO.getListComposicaoDTO();
	private static List<ComposicaoComCalculoQuantidadeXvaLorDTO> composicaoDTOArrayList = new ArrayList<ComposicaoComCalculoQuantidadeXvaLorDTO>();
	private static List<Long> codigoComposisaoList = new ArrayList<Long>();

	/**
	 * Metódo responsavel por iniar o serviço junto com o Spring.
	 * 
	 * @return void
	 **/
	public static void run() {
		titulo();
		multiplicacaoItensComposicao();
		escreveMensagemNoConsole();
	}
	
	

	/**
	 * Metódo responsavel por gerar uma nova lista ja com o total idividual (quantidade * valor unitario).
	 * 
	 * @return void
	 **/
	private static void multiplicacaoItensComposicao() {
		for (ComposicaoDTO composicao : composicaoDTOList) {
			if (!composicao.getValorUnitario().isBlank() && !composicao.getQuantidadeComposicao().isBlank()) {
				ComposicaoComCalculoQuantidadeXvaLorDTO ComposicaoComCalculoQuantidadeXvaLorDTO = com.gerador_de_observacao.DTO.ComposicaoComCalculoQuantidadeXvaLorDTO.getInstance();
				ComposicaoComCalculoQuantidadeXvaLorDTO.setCodigoComposicao(composicao.getCodigoComposicao());
				ComposicaoComCalculoQuantidadeXvaLorDTO.setCodigoItem(composicao.getCodigoItem());
				ComposicaoComCalculoQuantidadeXvaLorDTO.setDescricaoComposicao(composicao.getDescricaoComposicao());
				ComposicaoComCalculoQuantidadeXvaLorDTO.setQuantidadeComposicao(composicao.getQuantidadeComposicao());
				ComposicaoComCalculoQuantidadeXvaLorDTO.setUnidadeComposicao(composicao.getUnidadeComposicao());
				ComposicaoComCalculoQuantidadeXvaLorDTO.setValorUnitario(composicao.getValorUnitario());
				BigDecimal valorUnitario = new BigDecimal(composicao.getValorUnitario().replace(",", "."));
				BigDecimal quantidade = new BigDecimal(composicao.getQuantidadeComposicao().replace(",", "."));
				ComposicaoComCalculoQuantidadeXvaLorDTO.setValorTotal(valorUnitario.multiply(quantidade));
				composicaoDTOArrayList.add(ComposicaoComCalculoQuantidadeXvaLorDTO);
			}

			List<Long> longs = new ArrayList<Long>();
			longs.add(composicao.getCodigoComposicao());
			for (Long l : longs) {
				if (!codigoComposisaoList.contains(l))
					codigoComposisaoList.add(l);
			}
		}

	}

	
	
	/**
	 * Metódo responsavel por gerar uma nova lista já com o total individual (quantidade * valor unitario).
	 * @param Long codComposicao
	 * @return BigDecimal
	 **/
	public static BigDecimal somaDasMultiplicacaos(Long codComposicao) {
		BigDecimal total = new BigDecimal(0);
		for (ComposicaoComCalculoQuantidadeXvaLorDTO composicaoComTotalUnitario : composicaoDTOArrayList) {
			if (composicaoComTotalUnitario.getCodigoComposicao() == codComposicao) {
				total = total.add(composicaoComTotalUnitario.getValorTotal());
			}
		}
		return total;
	}

	
	/**
	 * Metódo responsavel por escrever o retorno no console.
	 * @return void
	 **/
	public static void escreveMensagemNoConsole() {
		for (Long codComposicaoLong : codigoComposisaoList) {
			ComposicaoComCalculoQuantidadeXvaLorDTO ComposicaoComCalculoQuantidadeXvaLorDTO = getComposicaoPorCodigo(codComposicaoLong);
			ComposicaoFinalDTO composicaoFinalDTO = ComposicaoFinalDTO.getInstance();
			composicaoFinalDTO.setCodigoComposicao(ComposicaoComCalculoQuantidadeXvaLorDTO.getCodigoComposicao());
			composicaoFinalDTO.setDescricaoComposicao(ComposicaoComCalculoQuantidadeXvaLorDTO.getDescricaoComposicao());
			composicaoFinalDTO.setUnidadeComposicao(ComposicaoComCalculoQuantidadeXvaLorDTO.getUnidadeComposicao());
			composicaoFinalDTO.setValorTotal(somaDasMultiplicacaos(codComposicaoLong));

			System.out.println(
					composicaoFinalDTO.getCodigoComposicao() + " " + composicaoFinalDTO.getDescricaoComposicao() + " "
							+ composicaoFinalDTO.getUnidadeComposicao() + " " + composicaoFinalDTO.getValorTotal());
		}
	}

	public static ComposicaoComCalculoQuantidadeXvaLorDTO getComposicaoPorCodigo(Long codComposicao) {
		for (ComposicaoComCalculoQuantidadeXvaLorDTO composicaoComTotalUnitario : composicaoDTOArrayList) {
			if (composicaoComTotalUnitario.getCodigoComposicao() == codComposicao) {
				return composicaoComTotalUnitario;
			}
		}
		return null;
	}

	public static void titulo() {
		System.out.println(" ");
		System.out.println(" Retorno Console ");
		System.out.println(" ");
	}
}