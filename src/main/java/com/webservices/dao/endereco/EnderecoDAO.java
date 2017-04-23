package com.webservices.dao.endereco;

import java.util.Collection;

import com.webservices.entity.endereco.EnderecoEntity;
import com.webservices.exception.endereco.EnderecoInvalidoException;

/**
 * DAO pattern responsável pelo acesso à entidade Endereço.
 *
 * @author sergiofjunior@gmail.com
 */
public interface EnderecoDAO {

	/**
	 * Salvar um endereço.
	 */
	public void salvar(EnderecoEntity endereco) throws EnderecoInvalidoException;
	
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
