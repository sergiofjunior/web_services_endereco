/**
 * 
 */
package com.webservices.rest.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.webservices.exception.endereco.EnderecoInvalidoException;

/**
 * @author sergiofjunior@gmail.com
 */
public class EnderecoInvalidoExceptionMapper implements ExceptionMapper<EnderecoInvalidoException> {

	/**
	 * Resposta padrão.
	 */
	@Override
	public Response toResponse(EnderecoInvalidoException e) {
		return Response.status(422)
				.entity(e.getMessage())
				.type(MediaType.TEXT_PLAIN)
				.build();
	}

}
