package com.calculocomposicoes;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.calculocomposicoes.DTO.ComposicaoDTO;
import com.calculocomposicoes.service.Service;

@RunWith(SpringRunner.class)
public class CalculoComposicoesTest {
	
	private static final Long CODIGO_COMPOSICAO_TESTE = new Long(88830);
	
	@Test
	public void getObservacaoComValorTotalNota() {
		List<ComposicaoDTO> list = Service.geraListaComCodigoDasComposicoesPrincipais(CODIGO_COMPOSICAO_TESTE);
	}
	

}
