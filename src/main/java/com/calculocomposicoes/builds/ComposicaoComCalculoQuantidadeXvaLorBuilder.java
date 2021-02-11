package com.calculocomposicoes.builds;

import java.math.BigDecimal;
import com.calculocomposicoes.DTO.ComposicaoComCalculoQuantidadeXvaLorDTO;

public class ComposicaoComCalculoQuantidadeXvaLorBuilder {
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

	public ComposicaoComCalculoQuantidadeXvaLorBuilder(Long codigoComposicao, String descricaoComposicao,
			String unidadeComposicao, BigDecimal valorTotal, String valorUnitario, Long codigoItem,
			String quantidadeComposicao) {
		super();
		this.codigoComposicao = codigoComposicao;
		this.quantidadeComposicao = quantidadeComposicao;
		this.descricaoComposicao = descricaoComposicao;
		this.unidadeComposicao = unidadeComposicao;
		this.valorTotal = valorTotal;
		this.valorUnitario = valorUnitario;
		this.codigoItem = codigoItem;
	}

	public ComposicaoComCalculoQuantidadeXvaLorBuilder() {
		super();
	}

	public static final ComposicaoComCalculoQuantidadeXvaLorBuilder getInstance() {
		return new ComposicaoComCalculoQuantidadeXvaLorBuilder();
	}

	

	public ComposicaoComCalculoQuantidadeXvaLorBuilder quantidadeComposicao(String quantidadeComposicao) {
		this.quantidadeComposicao = quantidadeComposicao;
		return this;
	}

	public ComposicaoComCalculoQuantidadeXvaLorBuilder descricaoComposicao(String descricaoComposicao) {
		this.descricaoComposicao = descricaoComposicao;
		return this;
	}

	public ComposicaoComCalculoQuantidadeXvaLorBuilder unidadeComposicao(String unidadeComposicao) {
		this.unidadeComposicao = unidadeComposicao;
		return this;
	}

	public ComposicaoComCalculoQuantidadeXvaLorBuilder valorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
		return this;
	}

	public ComposicaoComCalculoQuantidadeXvaLorBuilder codigoComposicao(Long codigoComposicao) {
		this.codigoComposicao = codigoComposicao;
		return this;
	}
	public ComposicaoComCalculoQuantidadeXvaLorBuilder valorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
		return this;
	}

	public ComposicaoComCalculoQuantidadeXvaLorBuilder codigoItem(Long codigoItem) {
		this.codigoItem = codigoItem;
		return this;
	}
	
	public ComposicaoComCalculoQuantidadeXvaLorDTO builder() {
		return new ComposicaoComCalculoQuantidadeXvaLorDTO(codigoComposicao, descricaoComposicao, unidadeComposicao, valorTotal, valorUnitario, codigoItem, quantidadeComposicao);
	}

}
