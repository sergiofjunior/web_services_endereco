package com.webservices.rest;

import com.webservices.rest.exception.CEPInvalidoExceptionMapper;
import com.webservices.rest.exception.EnderecoInvalidoExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

/**
 * Configuração REST.
 *
 * @author sergiofjunior@gmail.com
 */
public class AppConfig extends ResourceConfig {

	/**
	 * Construtor padrão.
	 */
	public AppConfig() {
		register(RequestContextFilter.class);
		register(CEPResource.class);
		register(EnderecoResource.class);
		register(CEPInvalidoExceptionMapper.class);
		register(EnderecoInvalidoExceptionMapper.class);
	}
	
}
