package com.gerador_de_observacao.builds;

import com.gerador_de_observacao.DTO.ComposicaoDTO;

public class ComposicaoBuilder{
	 
	private Long codigoComposicao;
	private String descricaoComposicao;
	private String unidadeComposicao;
	private Long codigoItem;
	private String tipoItem;
	private String descricaoItemComposicao;
	private String quantidadeComposicao;
	private String valorUnitario;
	
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
	public Long getCodigoItem() {
		return codigoItem;
	}
	public void setCodigoItem(Long codigoItem) {
		this.codigoItem = codigoItem;
	}
	public String getTipoItem() {
		return tipoItem;
	}
	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}
	public String getDescricaoItemComposicao() {
		return descricaoItemComposicao;
	}
	public void setDescricaoItemComposicao(String descricaoItemComposicao) {
		this.descricaoItemComposicao = descricaoItemComposicao;
	}
	public String getQuantidadeComposicao() {
		return quantidadeComposicao;
	}
	public void setQuantidadeComposicao(String quantidadeComposicao) {
		this.quantidadeComposicao = quantidadeComposicao;
	}
	public String getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	
	public ComposicaoBuilder codigoComposicao(Long codigoComposicao) {
		this.codigoComposicao = codigoComposicao;
		return this;
	}
	public ComposicaoBuilder descricaoComposicao(String descricaoComposicao) {
		this.descricaoComposicao = descricaoComposicao;
		return this;
	}
	public ComposicaoBuilder unidadeComposicao(String unidadeComposicao) {
		this.unidadeComposicao = unidadeComposicao;
		return this;
	}
	public ComposicaoBuilder codigoItem(Long codigoItem) {
		this.codigoItem = codigoItem;
		return this;
	}
	public ComposicaoBuilder tipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
		return this;
	}
	public ComposicaoBuilder descricaoItemComposicao(String descricaoItemComposicao) {
		this.descricaoItemComposicao = descricaoItemComposicao;
		return this;
	}
	public ComposicaoBuilder quantidadeComposicao(String quantidadeComposicao) {
		this.quantidadeComposicao = quantidadeComposicao;
		return this;
	}
	public ComposicaoBuilder valorUnitario(String valorUnitario) {
		this.valorUnitario = valorUnitario;
		return this;
	}
	
	public ComposicaoDTO build() {
		return ComposicaoDTO.construir(codigoComposicao, descricaoComposicao, unidadeComposicao, codigoItem, 
				tipoItem, descricaoItemComposicao, quantidadeComposicao, valorUnitario);
	}
	
}
