package com.webservices.exception.endereco;

/**
 * Exceção endereço inválido.
 *
 * @author sergiofjunior@gmail.com
 */
public class EnderecoInvalidoException extends Exception {

	/**
	 * Serial;
	 */
	private static final long serialVersionUID = -3205289088605739909L;

	/**
	 * Construtor.
	 * 
	 * @param message Mensagem de erro.
	 */
	public EnderecoInvalidoException(String message) {
		super(message);
	}

}
