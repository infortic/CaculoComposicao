package com.gerador_de_observacao.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.gerador_de_observacao.Constantes;
import com.gerador_de_observacao.DTO.ComposicaoDTO;
import com.gerador_de_observacao.DTO.ComposicaoComSomaDasMultiplicacoes;
import com.gerador_de_observacao.DTO.ComposicaoComCalculoQuantidadeXvaLorDTO;

/**
 * Classe responsável por fornecer serviço para calculo de composições de itens.
 * 
 * @author Cleiton Silva
 */
@org.springframework.stereotype.Service
public class Service {

	

	private static ComposicaoDTO[] composicaoDTOList = ComposicaoDTO.getListComposicaoDTO();
	private static List<ComposicaoComCalculoQuantidadeXvaLorDTO> composicaoComCalculoQuantidadeXvaLorList= new ArrayList<ComposicaoComCalculoQuantidadeXvaLorDTO>();
	private static List<Long> codigoComposisaoList = new ArrayList<Long>();

	/**
	 * Metódo responsavel por iniar o serviço junto com o Spring.
	 * 
	 * @return void
	 **/
	public static void run() {
		titulo();
		criaListaComposicaoCalculadaQuantidadeXvalor();
		escreveMensagemNoConsole();
	}
	
	

	/**
	 * Metódo responsavel por gerar uma nova lista ja com o total idividual (quantidade * valor unitario).
	 * 
	 * @return void
	 **/
	private static void criaListaComposicaoCalculadaQuantidadeXvalor() {
		for (ComposicaoDTO composicao : composicaoDTOList) {
			if (!composicao.getValorUnitario().isBlank() && !composicao.getQuantidadeComposicao().isBlank()) {
				ComposicaoComCalculoQuantidadeXvaLorDTO composicaoComCalculoQuantidadeXvaLorDTO =  ComposicaoComCalculoQuantidadeXvaLorDTO.getInstance();
				composicaoComCalculoQuantidadeXvaLorDTO.setCodigoComposicao(composicao.getCodigoComposicao());
				composicaoComCalculoQuantidadeXvaLorDTO.setCodigoItem(composicao.getCodigoItem());
				composicaoComCalculoQuantidadeXvaLorDTO.setDescricaoComposicao(composicao.getDescricaoComposicao());
				composicaoComCalculoQuantidadeXvaLorDTO.setQuantidadeComposicao(composicao.getQuantidadeComposicao());
				composicaoComCalculoQuantidadeXvaLorDTO.setUnidadeComposicao(composicao.getUnidadeComposicao());
				composicaoComCalculoQuantidadeXvaLorDTO.setValorUnitario(composicao.getValorUnitario());
				BigDecimal valorUnitario = new BigDecimal(composicao.getValorUnitario().replace(",", "."));
				BigDecimal quantidade = new BigDecimal(composicao.getQuantidadeComposicao().replace(",", "."));
				composicaoComCalculoQuantidadeXvaLorDTO.setValorTotal(valorUnitario.multiply(quantidade));
				composicaoComCalculoQuantidadeXvaLorList.add(composicaoComCalculoQuantidadeXvaLorDTO);
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
		for (ComposicaoComCalculoQuantidadeXvaLorDTO composicaoComTotalUnitario : composicaoComCalculoQuantidadeXvaLorList) {
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
			ComposicaoComSomaDasMultiplicacoes composicaoComSomaDasMultiplicacoes = ComposicaoComSomaDasMultiplicacoes.getInstance();
			composicaoComSomaDasMultiplicacoes.setCodigoComposicao(ComposicaoComCalculoQuantidadeXvaLorDTO.getCodigoComposicao());
			composicaoComSomaDasMultiplicacoes.setDescricaoComposicao(ComposicaoComCalculoQuantidadeXvaLorDTO.getDescricaoComposicao());
			composicaoComSomaDasMultiplicacoes.setUnidadeComposicao(ComposicaoComCalculoQuantidadeXvaLorDTO.getUnidadeComposicao());
			composicaoComSomaDasMultiplicacoes.setValorTotal(somaDasMultiplicacaos(codComposicaoLong));

			System.out.println(
					composicaoComSomaDasMultiplicacoes.getCodigoComposicao() + " " + composicaoComSomaDasMultiplicacoes.getDescricaoComposicao() + " "
							+ composicaoComSomaDasMultiplicacoes.getUnidadeComposicao() + " " + composicaoComSomaDasMultiplicacoes.getValorTotal());
		}
	}

	/**
	 * Metódo responsavel por selecionar uma composicao na lista atravez do codigo da composicão.
	 * @param Long codComposicao
	 * @return ComposicaoComCalculoQuantidadeXvaLorDTO
	 **/
	public static ComposicaoComCalculoQuantidadeXvaLorDTO getComposicaoPorCodigo(Long codComposicao) {
		for (ComposicaoComCalculoQuantidadeXvaLorDTO composicaoComTotalUnitario : composicaoComCalculoQuantidadeXvaLorList) {
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