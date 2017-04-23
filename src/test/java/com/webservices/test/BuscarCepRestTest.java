package com.webservices.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import com.webservices.entity.endereco.EnderecoEntity;
import com.webservices.rest.AppConfig;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Teste unitário do serviço REST para busca do CEP.
 *
 * @author sergiofjunior@gmail.com
 */
public class BuscarCepRestTest extends JerseyTest {
	
	/**
	 * Configuração REST.
	 */
	@Override
    protected Application configure() {
		
		AppConfig appConfig = new AppConfig();
		appConfig.property("contextConfigLocation", "classpath:applicationContext.xml");
		
        return appConfig;
        
    }
	
	/**
	 * Buscar CEP válido.
	 */
	@Test
	public void buscarCEPsValidos() {
        
		try {
			
			// CEP teste
			String cepTeste = "12345678";

			// Executar requisição GET
			final Response response = target("cep/" + cepTeste).request().get();
			
			// Validar a resposta não é nula
			assertNotNull(response);

			// Validar se a resposta é OK (status 200)
			assertEquals(200, response.getStatus());
			
			// Validar se a resposta está no padrão JSON e é igual ao endereço esperado
			String jsonResponse = response.readEntity(String.class);
			assertNotNull(jsonResponse);
			
			ObjectMapper mapper = new ObjectMapper();
			EnderecoEntity enderecoResponse = mapper.readValue(jsonResponse, EnderecoEntity.class);
			assertEquals("Justino Ribeiro", enderecoResponse.getRua());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
    	
    }

}
