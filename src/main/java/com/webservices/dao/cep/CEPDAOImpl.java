package com.webservices.dao.cep;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.webservices.entity.endereco.EnderecoEntity;

/**
 * Implementação de exemplo no padrão DAO para CRUD de CEPs.
 *
 * @author sergiofjunior@gmail.com
 */
public class CEPDAOImpl implements CEPDao {
	
	/**
	 * Map contendos os CEPs cadastrados e seus respectivos endereços.
	 */
	private Map<String, EnderecoEntity> enderecos;
	
	/**
	 * Construtor padrão.
	 */
	public CEPDAOImpl() {
		this.enderecos = new HashMap<String, EnderecoEntity>();
	}
	
	/**
	 * Construtor passando os valores dos endereços.
	 */
	public CEPDAOImpl(HashMap<String, EnderecoEntity> enderecos) {
		this.enderecos = enderecos;
	}

	/**
	 * Buscar endereço pelo CEP.
	 */
	public EnderecoEntity buscarEnderecoPorCEP(String cep) {
		try {
			return (EnderecoEntity) BeanUtils.cloneBean(this.enderecos.get(cep));
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
	/**
	 * Incluir novo endereço pelo CEP.
	 */
	public void addEnderecoPorCEP(String cep, EnderecoEntity enderecoEntity) {
		this.enderecos.put(cep, enderecoEntity);
	}

	/**
	 * Remover endereço existente pelo CEP.
	 */
	public void removeEnderecoPorCEP(String cep, EnderecoEntity enderecoEntity) {
		this.enderecos.remove(cep);
	}

}

