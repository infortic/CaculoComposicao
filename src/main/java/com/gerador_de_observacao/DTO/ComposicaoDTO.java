package com.gerador_de_observacao.DTO;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ComposicaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

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

	
	
	@Override
	public String toString() {
		return "ComposicaoDTO [codigoComposicao=" + codigoComposicao + ", descricaoComposicao=" + descricaoComposicao
				+ ", unidadeComposicao=" + unidadeComposicao + ", codigoItem=" + codigoItem + ", tipoItem=" + tipoItem
				+ ", descricaoItemComposicao=" + descricaoItemComposicao + ", quantidadeComposicao="
				+ quantidadeComposicao + ", valorUnitario=" + valorUnitario + "]";
	}

	public ComposicaoDTO(Long codigoComposicao, String descricaoComposicao, String unidadeComposicao,
			Long codigoItem, String tipoItem, String descricaoItemComposicao, String quantidadeComposicao,
			String valorUnitario) {
		super();
		this.codigoComposicao = codigoComposicao;
		this.descricaoComposicao = descricaoComposicao;
		this.unidadeComposicao = unidadeComposicao;
		this.codigoItem = codigoItem;
		this.tipoItem = tipoItem;
		this.descricaoItemComposicao = descricaoItemComposicao;
		this.quantidadeComposicao = quantidadeComposicao;
		this.valorUnitario = valorUnitario;
	}
	
	public static final ComposicaoDTO construir(Long codigoComposicao, String descricaoComposicao, String unidadeComposicao,
			 Long codigoItem, String tipoItem, String descricaoItemComposicao, String quantidadeComposicao,
			String valorUnitario) {
		return new ComposicaoDTO(codigoComposicao, descricaoComposicao, unidadeComposicao, codigoItem, 
				tipoItem, descricaoItemComposicao, quantidadeComposicao, valorUnitario);
	}

	public ComposicaoDTO() {
		super();
	}

	public static final ComposicaoDTO getInstance() {
		return new ComposicaoDTO();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(codigoComposicao)
				.append(descricaoComposicao)
				.append(unidadeComposicao)
				.append(codigoItem)
				.append(tipoItem)
				.append(descricaoItemComposicao)
				.append(quantidadeComposicao)
				.append(valorUnitario)
				.toHashCode();
	}

	@Override
	public boolean equals(final Object object) {
		if (object instanceof ComposicaoDTO) {
			final ComposicaoDTO other = (ComposicaoDTO) object;
			return new EqualsBuilder()
					.append(codigoComposicao, other.codigoComposicao)
					.append(descricaoComposicao, other.descricaoComposicao)
					.append(unidadeComposicao, other.unidadeComposicao)
					.append(codigoItem, other.codigoItem)
					.append(tipoItem, other.tipoItem)
					.append(descricaoItemComposicao, other.descricaoItemComposicao)
					.append(quantidadeComposicao, other.quantidadeComposicao)
					.append(valorUnitario, other.valorUnitario)
					.isEquals();
		} else {
			return false;
		}
		
	}
	
	
	
}
