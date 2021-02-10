package com.com.gerador_de_observacao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gerador_de_observacao.service.Service;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GeradorDeObservacaoTeste {
	
	@Autowired
	private WebApplicationContext context;
	
//	@Autowired
//	private Service serive;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private MockMvc mockMvc; 
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void getObservacaoComValorTotalNota() {
		
	}
	
}
