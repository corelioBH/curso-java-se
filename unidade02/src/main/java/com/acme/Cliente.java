package com.acme;

/**
 * Classe cliente com constru��es m�nimas em Java
 * @author Marco Mendes
 * @since Dezembro de 2017
 *
 * Pontos de an�lise
 * - Defini��o de classes
 * - Defini��o de atributos
 * - Construtores
 * - Sobrescrita de m�todos
 * - Cria��o de objetos
 * - Classe abstrata
 *
 */
abstract public class Cliente {
   
	private String nome;
	private String endereco;
	
	public Cliente(String nome, String endereco) {
		super();
		this.nome = nome;
		this.endereco = endereco;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return "Nome:" + this.getNome() + System.lineSeparator() + "Endereco:" + this.getEndereco();
	}

	
}
