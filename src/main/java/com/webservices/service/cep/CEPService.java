/**
 * 
 */
package com.webservices.service.cep;

import com.webservices.entity.endereco.EnderecoEntity;
import com.webservices.exception.cep.CEPInvalidoException;

/**
 * interface de negócio responsável ao CEP.
 *
 * @author sergiofjunior@gmail.com
 */
public interface CEPService {

	/**
	 * Buscar endereço por um CEP válido.
	 * 
	 * @param cep CEP.
	 * @throws CEPInvalidoException Erro ao buscar CEP.
	 */
	public EnderecoEntity buscarEnderecoPorCEP(String cep) throws CEPInvalidoException;
	
}
