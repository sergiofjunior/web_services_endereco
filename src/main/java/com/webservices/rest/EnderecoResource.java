package com.webservices.rest;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.webservices.exception.cep.CEPInvalidoException;
import com.webservices.service.endereco.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webservices.entity.endereco.EnderecoEntity;
import com.webservices.exception.endereco.EnderecoInvalidoException;

/**
 * Implementação REST destinada à requisições do Resource Endereço.
 *
 * @author sergiofjunior@gmail.com
 */
@Path("/endereco")
@Component
public class EnderecoResource {

	/**
	 * Serviço de busca do CEP.
	 */
	@Autowired
	private EnderecoService enderecoService;
	
	/**
	 * Salvar um endereço.
	 */
	@POST
	@Consumes(APPLICATION_JSON)
	@Produces(APPLICATION_JSON)
	public void salvar(EnderecoEntity endereco) throws EnderecoInvalidoException, CEPInvalidoException {
		
		this.enderecoService.salvar(endereco);
		
	}
	
	/**
	 * Selecionar um endereço pelo id.
	 */
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") String id) throws EnderecoInvalidoException {
		
		this.enderecoService.remover(id);
		
	}
	
	/**
	 * Selecionar um endereço pelo id.
	 */
	@GET
	@Path("/{id}")
	@Produces(APPLICATION_JSON)
	public EnderecoEntity selecionar(@PathParam("id") String id) throws EnderecoInvalidoException {
		
		return this.enderecoService.selecionar(id);
		
	}
	
	/**
	 * Listar endereços cadastrados.
	 */
	@GET
	@Produces(APPLICATION_JSON)
	public Collection<EnderecoEntity> selecionar() {
		
		return this.enderecoService.listar();
		
	}
	
}
