package com.gerador_de_observacao.builds;

import java.util.List;

import com.gerador_de_observacao.DTO.ComposicaoDTO;
import com.gerador_de_observacao.DTO.ComposicaoRequestDTO;

public class ComposicaoRequestBuilder {
	
private Boolean mostrarValorNota;
	
	private List<ComposicaoDTO> ComposicaoList;

	public Boolean getMostrarValorNota() {
		return this.mostrarValorNota;
	}
	
	public void setMostrarValorNota(Boolean mostrarValorNota) {
		this.mostrarValorNota = mostrarValorNota;
	}

	public List<ComposicaoDTO> getComposicaoList() {
		return this.ComposicaoList;
	}

	public void setComposicaoList(List<ComposicaoDTO> composicaoList) {
		this.ComposicaoList = composicaoList;
	}
	
	public ComposicaoRequestBuilder mostrarValorNota(Boolean mostrarValorNota) {
		this.mostrarValorNota = mostrarValorNota;
		return this;
	}
	
	public ComposicaoRequestBuilder ComposicaoList(List<ComposicaoDTO> ComposicaoList) {
		this.ComposicaoList.addAll(ComposicaoList);
		return this;
	}
	
	public ComposicaoRequestDTO builder() {
		return ComposicaoRequestDTO.construir(mostrarValorNota, ComposicaoList);
	}
	
	

}
