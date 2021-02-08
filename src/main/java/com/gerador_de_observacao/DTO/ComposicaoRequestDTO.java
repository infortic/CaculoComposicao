package com.gerador_de_observacao.DTO;

import java.util.List;

public class ComposicaoRequestDTO{
		
	private Boolean mostrarValorNota;
	
	private List<ComposicaoDTO> ComposicaoList;

	public Boolean getMostrarValorNota() {
		return mostrarValorNota;
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

	public ComposicaoRequestDTO(Boolean mostrarValorNota, List<ComposicaoDTO> composicaoList) {
		super();
		this.mostrarValorNota = mostrarValorNota;
		this.ComposicaoList = composicaoList;
	}

	public ComposicaoRequestDTO() {
		super();
	}
	
	public ComposicaoRequestDTO getInstance() {
		return new ComposicaoRequestDTO();
	}
	
	public static final ComposicaoRequestDTO construir(Boolean mostrarValorNota, List<ComposicaoDTO> composicaoList) {
		return new ComposicaoRequestDTO(mostrarValorNota, composicaoList);
	}
					
}
