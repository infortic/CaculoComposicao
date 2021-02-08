package com.gerador_de_observacao.resource;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gerador_de_observacao.DTO.ComposicaoRequestDTO;
import com.gerador_de_observacao.service.Service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Construtor de Mensagem")
@RestController
@RequestMapping("/mensagem")
public class GeradorDeMensagemResource {

	@Autowired
	private Service service;
	
	@ApiOperation(value = "Retorna mensagem customizada")

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> simular(@RequestBody ComposicaoRequestDTO paylod) throws ParseException {
				
		return new ResponseEntity<>(service.geraObservacao(paylod.getComposicaoList() ,paylod.getMostrarValorNota()), HttpStatus.OK);
	}

}