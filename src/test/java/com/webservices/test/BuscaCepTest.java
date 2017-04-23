package com.webservices.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.webservices.exception.cep.CEPInvalidoException;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.webservices.dao.cep.CEPDao;
import com.webservices.entity.endereco.EnderecoEntity;
import com.webservices.service.cep.CEPService;

/**
 * Test Case do serviço de busca de CEP.
 *
 * @author sergiofjunior@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(locations = "classpath:testApplicationContext.xml")
public class BuscaCepTest {
	
	/**
	 * Serviço do CEP.
	 */
	@Autowired
	private CEPService cepService;
	
	/**
	 * Serviço do CEP.
	 */
	@Autowired
	private CEPDao cepDao;

	/**
	 * Validar um CEP nulo.
	 */
	@Test
	public void validarCEPNulo() {
		
		try {
			
			// Tentar buscar um CEP nulo
			this.cepService.buscarEnderecoPorCEP(null);
			fail("CEP é nulo");
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), e instanceof CEPInvalidoException);
		}
		
	}
	
	/**
	 * Validar um CEP vazio.
	 */
	@Test
	public void validarCEPVazio() {
		
		try {
			
			// Tentar buscar um CEP com valor vazio
			this.cepService.buscarEnderecoPorCEP("   ");
			fail("CEP é vazio");
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), e instanceof CEPInvalidoException);
		}
		
	}
	
	/**
	 * Validar um CEP nulo.
	 */
	@Test
	public void validarCEPIncorreto() {
		
		try {
			
			// Tentar buscar um CEP com formato incorreto
			String randomCep = RandomStringUtils.random(999);
			this.cepService.buscarEnderecoPorCEP(randomCep);
			fail("CEP é incorreto");
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), e instanceof CEPInvalidoException);
		}
		
		try {
			
			// Tentar buscar um CEP com espaços à direita ou esqueda
			this.cepService.buscarEnderecoPorCEP(" 12345678  ");
			fail("CEP é incorreto");
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), e instanceof CEPInvalidoException);
		}

		
	}
	
	/**
	 * Validar um CEP não cadastrado.
	 */
	@Test
	public void validarCEPNaoEncontrato() {
		
		/*
		 * Valor inexistente 99999999 
		 */
		try {
			
			this.cepService.buscarEnderecoPorCEP("99999999");
			fail("CEP foi encontrado");
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), e instanceof CEPInvalidoException);
		}
		
		/*
		 * Valor inexistente 00000000 
		 */
		try {
			
			this.cepService.buscarEnderecoPorCEP("00000000");
			fail("CEP foi encontrado");
			
		} catch (Exception e) {
			assertTrue(e.getMessage(), e instanceof CEPInvalidoException);
		}
		
	}
	
	/**
	 * Buscar CEP válido.
	 */
	@Test
	public void buscarCEPsValidos() {
		
		try {
			
			EnderecoEntity enderecoEntity = mock(EnderecoEntity.class);
			
			/*
			 * Match exato 12345678
			 */
			when(this.cepDao.buscarEnderecoPorCEP("12345678")).thenReturn(enderecoEntity);

			enderecoEntity = this.cepService.buscarEnderecoPorCEP("12345678");

			assertNotNull(enderecoEntity);

			/*
			 * Match com zeros à diretira 99990000
			 */
			when(this.cepDao.buscarEnderecoPorCEP("99990000")).thenReturn(enderecoEntity);

			enderecoEntity = this.cepService.buscarEnderecoPorCEP("99999999");

			assertNotNull(enderecoEntity);

			/*
			 * Match extado com zeros à direita 08080800
			 */
			when(this.cepDao.buscarEnderecoPorCEP("08080800")).thenReturn(enderecoEntity);

			enderecoEntity = this.cepService.buscarEnderecoPorCEP("08080800");

			assertNotNull(enderecoEntity);
			
			/*
			 * Match aproximado com zeros intercados 70707070
			 */
			when(this.cepDao.buscarEnderecoPorCEP("70707000")).thenReturn(enderecoEntity);
			
			enderecoEntity = this.cepService.buscarEnderecoPorCEP("70707777");

			assertNotNull(enderecoEntity);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
	}

}
