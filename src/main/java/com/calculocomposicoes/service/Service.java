package com.calculocomposicoes.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.calculocomposicoes.DTO.ComposicaoComCalculoQuantidadeXvaLorDTO;
import com.calculocomposicoes.DTO.ComposicaoComSomaDasMultiplicacoesDTO;
import com.calculocomposicoes.DTO.ComposicaoDTO;
import com.calculocomposicoes.builds.ComposicaoComCalculoQuantidadeXvaLorBuilder;
import com.calculocomposicoes.builds.ComposicaoComSomaDasMultiplicacoesBuilder;

/**
 * Classe responsável por fornecer serviço para calculo de composições de itens.
 * @author Cleiton Silva
 **/
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
	 * @return void.
	 **/
	private static void criaListaComposicaoCalculadaQuantidadeXvalor() {
		for (ComposicaoDTO composicao : composicaoDTOList) {
			if (!composicao.getValorUnitario().isBlank() && !composicao.getQuantidadeComposicao().isBlank()) {
			
				BigDecimal valorUnitario = new BigDecimal(composicao.getValorUnitario().replace(",", "."));
				BigDecimal quantidade = new BigDecimal(composicao.getQuantidadeComposicao().replace(",", "."));
				
				ComposicaoComCalculoQuantidadeXvaLorDTO composicaoComCalculoQuantidadeXvaLorDTO = ComposicaoComCalculoQuantidadeXvaLorBuilder.getInstance()
						.codigoComposicao(composicao.getCodigoComposicao())
						.codigoItem(composicao.getCodigoItem())
						.descricaoComposicao(composicao.getDescricaoComposicao())
						.quantidadeComposicao(composicao.getQuantidadeComposicao())
						.unidadeComposicao(composicao.getUnidadeComposicao())
						.valorTotal(valorUnitario.multiply(quantidade))
						.valorUnitario(composicao.getValorUnitario())
						.builder();
				
				geraListaComCodigoDasComposicoesPrincipais(composicao);
				composicaoComCalculoQuantidadeXvaLorList.add(composicaoComCalculoQuantidadeXvaLorDTO);	
			}	
		}
	}

	
	/**
	 * Metódo responsavel por gerar lista com os codComposicao principais.
	 * @return void.
	 **/  
	public static List<Long> geraListaComCodigoDasComposicoesPrincipais(ComposicaoDTO composicao) {
		List<Long> codiComposicaoList = new ArrayList<Long>();
		codiComposicaoList.add(composicao.getCodigoComposicao());
		for (Long codComposicao : codiComposicaoList) {
			if (!codigoComposisaoList.contains(codComposicao))
				codigoComposisaoList.add(codComposicao);
		}
		return codigoComposisaoList;
	}
	
	
	/**
	 * Metodo responsavel por Somar as Multiplicações
	 * @param Long codComposicao
	 * @return BigDecimal
	 **/
	public static BigDecimal somaDasMultiplicacaos(Long codComposicao) {
		BigDecimal total = new BigDecimal(0);
		for (ComposicaoComCalculoQuantidadeXvaLorDTO composicaoComTotalUnitario : composicaoComCalculoQuantidadeXvaLorList) {
			if (composicaoComTotalUnitario.getCodigoComposicao().equals(codComposicao)) {
				total = total.add(composicaoComTotalUnitario.getValorTotal());
			}
		}
		return total;
	}

	
	/***
	 * Metódo responsavel por escrever o retorno no console.
	 * @return void
	 ***/
	public static void escreveMensagemNoConsole() {
		for (Long codComposicaoLong : codigoComposisaoList) {
			ComposicaoComCalculoQuantidadeXvaLorDTO ComposicaoComCalculoQuantidadeXvaLorDTO = getComposicaoPorCodigo(codComposicaoLong);
			
			ComposicaoComSomaDasMultiplicacoesDTO composicaoComSomaDasMultiplicacoes = ComposicaoComSomaDasMultiplicacoesBuilder.getInstance()
					.codigoComposicao(ComposicaoComCalculoQuantidadeXvaLorDTO.getCodigoComposicao())
					.descricaoComposicao(ComposicaoComCalculoQuantidadeXvaLorDTO.getDescricaoComposicao())
					.unidadeComposicao(ComposicaoComCalculoQuantidadeXvaLorDTO.getUnidadeComposicao())
					.valorTotal(somaDasMultiplicacaos(codComposicaoLong))
					.builder();

			System.out.println(
					composicaoComSomaDasMultiplicacoes.getCodigoComposicao() + 
					" " + 
					composicaoComSomaDasMultiplicacoes.getDescricaoComposicao() + 
					" "	+ 
					composicaoComSomaDasMultiplicacoes.getUnidadeComposicao() + 
					" " + 
					composicaoComSomaDasMultiplicacoes.getValorTotal());
		}
	}

	/**
	 * Metódo responsavel por selecionar uma composicao na lista atravez do codigo da composicão.
	 * @param Long codComposicao
	 * @return ComposicaoComCalculoQuantidadeXvaLorDTO
	 **/
	public static ComposicaoComCalculoQuantidadeXvaLorDTO getComposicaoPorCodigo(Long codComposicao) {
		criaListaComposicaoCalculadaQuantidadeXvalor();
		for (ComposicaoComCalculoQuantidadeXvaLorDTO composicaoComTotalUnitario : composicaoComCalculoQuantidadeXvaLorList) {
			System.out.println(codComposicao + "    " + composicaoComTotalUnitario.getCodigoComposicao());
			if (composicaoComTotalUnitario.getCodigoComposicao().equals(codComposicao)) {
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