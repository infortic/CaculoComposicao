package com.calculocomposicoes.builds;

import java.math.BigDecimal;
import com.calculocomposicoes.DTO.ComposicaoComSomaDasMultiplicacoesDTO;

public class ComposicaoComSomaDasMultiplicacoesBuilder {

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

	public ComposicaoComSomaDasMultiplicacoesBuilder(Long codigoComposicao, String descricaoComposicao,
			String unidadeComposicao, BigDecimal valorTotal) {
		super();
		this.codigoComposicao = codigoComposicao;
		this.descricaoComposicao = descricaoComposicao;
		this.unidadeComposicao = unidadeComposicao;
		this.valorTotal = valorTotal;
	}

	public ComposicaoComSomaDasMultiplicacoesBuilder() {
		super();
	}

	public static final ComposicaoComSomaDasMultiplicacoesBuilder getInstance() {
		return new ComposicaoComSomaDasMultiplicacoesBuilder();
	}

	public ComposicaoComSomaDasMultiplicacoesBuilder codigoComposicao(Long codigoComposicao) {
		this.codigoComposicao = codigoComposicao;
		return this;
	}

	public ComposicaoComSomaDasMultiplicacoesBuilder unidadeComposicao(String unidadeComposicao) {
		this.unidadeComposicao = unidadeComposicao;
		return this;
	}

	public ComposicaoComSomaDasMultiplicacoesBuilder descricaoComposicao(String descricaoComposicao) {
		this.descricaoComposicao = descricaoComposicao;
		return this;
	}

	public ComposicaoComSomaDasMultiplicacoesBuilder valorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
		return this;
	}
	public ComposicaoComSomaDasMultiplicacoesDTO builder() {
		return new ComposicaoComSomaDasMultiplicacoesDTO(codigoComposicao, descricaoComposicao, unidadeComposicao, valorTotal);
	}
	
}