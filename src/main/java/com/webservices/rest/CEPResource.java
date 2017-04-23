package com.webservices.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webservices.entity.endereco.EnderecoEntity;
import com.webservices.exception.cep.CEPInvalidoException;
import com.webservices.service.cep.CEPService;

/**
 * Implementação REST destinada à requisições do Resource CEP.
 *
 * @author sergiofjunior@gmail.com
 */
@Path("/cep")
@Component
public class CEPResource {
	
	/**
	 * Serviço de busca do CEP.
	 */
	@Autowired
	private CEPService cepService;
	
	/**
	 * Buscar endereço por um CEP válido.
	 * 
	 * @param cep CEP.
	 * @throws CEPInvalidoException Erro ao buscar CEP.
	 */
	@GET
	@Path("/{cep}")
	@Produces(APPLICATION_JSON)
	public EnderecoEntity buscarEnderecoPorCEP(
			@PathParam("cep") String cep) throws CEPInvalidoException {
		
		// Efetuar a busca do endereço por um CEP
		return this.cepService.buscarEnderecoPorCEP(cep);
		
	}
	
}
