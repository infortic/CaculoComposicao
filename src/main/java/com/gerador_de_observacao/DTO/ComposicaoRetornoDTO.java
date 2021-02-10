package com.gerador_de_observacao.DTO;

import java.math.BigDecimal;

public class ComposicaoRetornoDTO {
	
	private Long codigoComposicao;
	private String descricaoComposicao;
	private String unidadeComposicao;
	private String valorUnitario;
	private BigDecimal valorTotal;
	private String quantidadeComposicao;
	private Long codigoItem;
	
	
	public String getQuantidadeComposicao() {
		return quantidadeComposicao;
	}

	public void setQuantidadeComposicao(String quantidadeComposicao) {
		this.quantidadeComposicao = quantidadeComposicao;
	}

	public Long getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(Long codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

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

	public ComposicaoRetornoDTO(Long codigoComposicao, String descricaoComposicao, String unidadeComposicao,
			BigDecimal valorTotal, String valorUnitario, Long codigoItem, String quantidadeComposicao) {
		super();
		this.codigoComposicao = codigoComposicao;
		this.quantidadeComposicao = quantidadeComposicao;
		this.descricaoComposicao = descricaoComposicao;
		this.unidadeComposicao = unidadeComposicao;
		this.valorTotal = valorTotal;
		this.valorUnitario = valorUnitario; 
		this.codigoItem = codigoItem;
	}

	public ComposicaoRetornoDTO() {
		super();
	}
	
	public static final  ComposicaoRetornoDTO getInstance() {
		return new ComposicaoRetornoDTO();
	}
}