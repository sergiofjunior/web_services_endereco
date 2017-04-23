package com.webservices.entity.endereco;

import java.io.Serializable;

/**
 * Entidade que representa um endereço.
 *
 * @author sergiofjunior@gmail.com
 */
public class EnderecoEntity implements Serializable {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 8684785589943206620L;

	/**
	 * Id.
	 */
	private String id;
	
	/**
	 * CEP.
	 */
	private String CEP;
	
	/**
	 * Rua.
	 */
	private String rua;
	
	/**
	 * Número.
	 */
	private String numero;
	
	/**
	 * Bairro.
	 */
	private String bairro;
	
	/**
	 * Complemento.
	 */
	private String complemento;
	
	/**
	 * Cidade.
	 */
	private String cidade;
	
	/**
	 * Estado.
	 */
	private String estado;

	/**
	 * @return the rua
	 */
	public String getRua() {
		return rua;
	}

	/**
	 * @param rua the rua to set
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the cEP
	 */
	public String getCEP() {
		return CEP;
	}

	/**
	 * @param cEP the cEP to set
	 */
	public void setCEP(String cep) {
		CEP = cep;
	}

	/**
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
