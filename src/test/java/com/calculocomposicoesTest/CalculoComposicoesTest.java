package com.calculocomposicoesTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.calculocomposicoes.DTO.ComposicaoComCalculoQuantidadeXvaLorDTO;
import com.calculocomposicoes.DTO.ComposicaoDTO;
import com.calculocomposicoes.builds.ComposicaoBuilder;
import com.calculocomposicoes.service.Service;

@RunWith(SpringRunner.class)
public class CalculoComposicoesTest {
	
	private static final Long CODIGO_COMPOSICAO_TESTE = new Long(87286);
	private static ComposicaoDTO[] composicaoDTOList = ComposicaoDTO.getListComposicaoDTO();
	
	
	@Test
	public void testeSomaDasMultiplicacoes() {
		BigDecimal resultado = Service.somaDasMultiplicacaos(CODIGO_COMPOSICAO_TESTE);
		Assertions.assertThat(resultado != null);
	}
	

	@Test
	public void calculoValorunitarioQuantidadeXvalorTest() {
		ComposicaoComCalculoQuantidadeXvaLorDTO composicaoComCalculoQuantidadeXvaLorDTO = Service.getComposicaoPorCodigo(CODIGO_COMPOSICAO_TESTE);
		Assertions.assertThat(composicaoComCalculoQuantidadeXvaLorDTO.getCodigoComposicao() != null);
		Assertions.assertThat(!composicaoComCalculoQuantidadeXvaLorDTO.getDescricaoComposicao().isBlank());
	}
	

	@Test
	public void geraLongCondComposicaoPrincipalTest() {
		ComposicaoDTO composicao = ComposicaoBuilder.getInstance()
				.codigoComposicao(CODIGO_COMPOSICAO_TESTE)
				.build();
		List<Long> longList = new ArrayList<Long>();
		longList.addAll(Service.geraListaComCodigoDasComposicoesPrincipais(composicao));
		Assertions.assertThat(longList.size() != 0);	
	}
	
}
