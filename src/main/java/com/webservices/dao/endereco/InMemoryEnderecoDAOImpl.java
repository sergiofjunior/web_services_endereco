package com.webservices.dao.endereco;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.webservices.exception.endereco.EnderecoInvalidoException;
import org.apache.commons.lang3.Validate;

import com.webservices.entity.endereco.EnderecoEntity;

/**
 * DAO pattern responsável pelo acesso à entidade Endereço no in-memory repositório.
 *
 * @author sergiofjunior@gmail.com
 */
public class InMemoryEnderecoDAOImpl implements EnderecoDAO {
	
	/**
	 * Map representando o repositório
	 */
	private static Map<String, EnderecoEntity> repositorio = new HashMap<String, EnderecoEntity>();
	
	/**
	 * Salvar um endereço.
	 */
	public void salvar(EnderecoEntity endereco) throws EnderecoInvalidoException {
		
		// Validar integridade do objeto
		validarEndereco(endereco);
		
		// Gerar id se o endereço é novo.
		synchronized (endereco) {
			if (endereco.getId() == null) {
				endereco.setId(UUID.randomUUID().toString());
			}
		}

		// Registrar no repositorio
		InMemoryEnderecoDAOImpl.repositorio.put(endereco.getId(), endereco);

	}
	
	/**
	 * Selecionar um endereço pelo id.
	 * 
	 * @throws EnderecoInvalidoException Erro ao remover endereço.
	 */
	public void remover(String id) throws EnderecoInvalidoException {
		
		// Validar se o o endereço está registrado
		if (!InMemoryEnderecoDAOImpl.repositorio.containsKey(id)) {
			throw new EnderecoInvalidoException(String.format("Endereço não registrado."));
		}
		
		// Retornar 
		InMemoryEnderecoDAOImpl.repositorio.remove(id);

	}
	
	/**
	 * Selecionar um endereço pelo id.
	 * 
	 * @throws EnderecoInvalidoException Erro ao selecionar endereço.
	 */
	public EnderecoEntity selecionar(String id) throws EnderecoInvalidoException {
		
		// Validar se o o endereço está registrado
		if (!InMemoryEnderecoDAOImpl.repositorio.containsKey(id)) {
			throw new EnderecoInvalidoException(String.format("Endereço não registrado."));
		}
		
		// Retornar 
		return InMemoryEnderecoDAOImpl.repositorio.get(id);

	}
	
	/**
	 * Listar endereços cadastrados.
	 */
	public Collection<EnderecoEntity> listar() {
		
		return InMemoryEnderecoDAOImpl.repositorio.values();
		
	}

	/**
	 * Validar endereço ao cadastrar.
	 */
	private void validarEndereco(EnderecoEntity endereco) throws EnderecoInvalidoException {
		
		try {
			// Validar se o endereço não é nulo.
			Validate.notNull(endereco, "Endereço não pode ser nulo.");
			
			// Validar obrigatoriedade dos atributos RUA, NUMERO, CEP, CIDADE e ESTADO
			validarObrigatoriedade(endereco.getRua(), "Rua");
			validarObrigatoriedade(endereco.getNumero(), "Numero");
			validarObrigatoriedade(endereco.getCEP(), "CEP");
			validarObrigatoriedade(endereco.getCidade(), "Cidade");
			validarObrigatoriedade(endereco.getEstado(), "Estado");
			
		} catch (Exception e) {
			throw new EnderecoInvalidoException(e.getMessage());
		}
		
	}

	/**
	 * Método auxiliar para validar a obrigatoriedade.
	 */
	private void validarObrigatoriedade(Object object, String nomeCampo) {
		Validate.notNull(object, String.format("Campo %s é obrigatório!", nomeCampo));
		if (object instanceof String) {
			Validate.notBlank((String) object, "Campo %s é obrigatório!", nomeCampo);
		}
	}

}
