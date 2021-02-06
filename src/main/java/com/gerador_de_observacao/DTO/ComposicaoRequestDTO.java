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
		return ComposicaoList;
	}

	public void setComposicaoList(List<ComposicaoDTO> composicaoList) {
		ComposicaoList = composicaoList;
	}
	
	
					
}
