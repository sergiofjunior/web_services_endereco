package com.webservices.dao.cep;

import com.webservices.entity.endereco.EnderecoEntity;

/**
 * Interface no padrão DAO para busca de endereços pelo CEP.
 * 
 * @author sergiofjunior@gmail.com
 */
public interface CEPDao {
	
	/**
	 * Buscar endereço pelo CEP.
	 */
	public EnderecoEntity buscarEnderecoPorCEP(String cepCode);
	
	/**
	 * Incluir novo endereço pelo CEP.
	 */
	public void addEnderecoPorCEP(String cep, EnderecoEntity enderecoEntity);

	/**
	 * Remover endereço existente pelo CEP.
	 */
	public void removeEnderecoPorCEP(String cep, EnderecoEntity enderecoEntity);

}
