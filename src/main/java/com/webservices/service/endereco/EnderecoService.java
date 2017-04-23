package com.webservices.service.endereco;

import java.util.Collection;

import com.webservices.entity.endereco.EnderecoEntity;
import com.webservices.exception.cep.CEPInvalidoException;
import com.webservices.exception.endereco.EnderecoInvalidoException;

/**
 * Interface do serviço para os metodos CRUD de endereço.
 *
 * @author sergiofjunior@gmail.com
 */
public interface EnderecoService {
	
	/**
	 * Salvar um endereço.
	 */
	public void salvar(EnderecoEntity endereco) throws EnderecoInvalidoException, CEPInvalidoException;
	
	/**
	 * Selecionar um endereço pelo id.
	 */
	public void remover(String id) throws EnderecoInvalidoException;
	
	/**
	 * Selecionar um endereço pelo id.
	 */
	public EnderecoEntity selecionar(String id) throws EnderecoInvalidoException;
	
	/**
	 * Listar endereços cadastrados.
	 */
	public Collection<EnderecoEntity> listar();

}
