package com.gerador_de_observacao.DTO;

import java.math.BigDecimal;

public class ComposicaoComSomaDasMultiplicacoes {
	
	private Long codigoComposicao;
	private String descricaoComposicao;
	private String unidadeComposicao;
	private BigDecimal valorTotal;
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getCodigoComposicao() {
		return codigoComposicao;
	}

	public void setCodigoComposicao(Long codigoComposicao) {
		this.codigoComposicao = codigoComposicao;
	}

	public String getDescricaoComposicao() {
		return descricaoComposicao;
	}

	public void setDescricaoComposicao(String descricaoComposicao) {
		this.descricaoComposicao = descricaoComposicao;
	}

	public String getUnidadeComposicao() {
		return unidadeComposicao;
	}

	public void setUnidadeComposicao(String unidadeComposicao) {
		this.unidadeComposicao = unidadeComposicao;
	}

	public ComposicaoComSomaDasMultiplicacoes(Long codigoComposicao, String descricaoComposicao, 
			String unidadeComposicao, BigDecimal valorTotal) {
		super();
		this.codigoComposicao = codigoComposicao;
		this.descricaoComposicao = descricaoComposicao;
		this.unidadeComposicao = unidadeComposicao;
		this.valorTotal = valorTotal;
	}

	public ComposicaoComSomaDasMultiplicacoes() {
		super();
	}
	
	public static final  ComposicaoComSomaDasMultiplicacoes getInstance() {
		return new ComposicaoComSomaDasMultiplicacoes();
	}
}