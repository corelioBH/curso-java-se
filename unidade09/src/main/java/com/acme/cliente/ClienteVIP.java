/**
 * 
 */
package com.acme.cliente;

import java.util.HashMap;
import com.acme.agencia.Agencia;
import com.acme.conta.ContaCorrente;
import com.acme.conta.Conta;
import com.acme.excecoes.ContaInexistente;
import com.acme.excecoes.ContaInvalida;
import com.acme.excecoes.LimiteChequeEspecialExcedido;
import com.acme.excecoes.LimiteSaqueExcedido;
import com.acme.excecoes.MovimentacaoInvalida;

/**
 * @author Marco Mendes
 * @since 2017
 * 
 */
public class ClienteVIP extends Cliente {

	/**
	 * 
	 */
	private HashMap<String, Conta> contas;

	public ClienteVIP(Agencia agencia, String nome, String endereco, String numeroConta) throws ContaInvalida {
		super(agencia, nome, endereco);
		contas = new HashMap<String, Conta>();
		contas.put(numeroConta, new ContaCorrente(numeroConta, 0, 5000.0));
	}

	// Overload - Sobrecarga do metodo construtor (nao confundir com override!)
	public ClienteVIP(Agencia<ClienteVIP> agencia, String nome, String endereco, String numeroConta, double saldo) throws ContaInvalida {
		super(agencia, nome, endereco);
		contas = new HashMap<String, Conta>();
		contas.put(numeroConta, new ContaCorrente(numeroConta, saldo, 5000.0));
	}

	@Override // Sobrescrita do metodo da classe pai
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString()).append(System.lineSeparator());
		for (Conta conta : contas.values()) {
			sb.append("Dados das contas...");
			sb.append(conta.toString()).append(System.lineSeparator());
		}
		return sb.toString();

	}

	public void creditar(String codigoConta, double valor) throws MovimentacaoInvalida, ContaInexistente {
        Conta conta = contas.get(codigoConta);
        if (conta == null) {
      		throw new ContaInexistente();      	
        }
		conta.creditar(valor); 

	}

	public void debitar(String codigoConta, double valor) 
			throws MovimentacaoInvalida, LimiteSaqueExcedido, LimiteChequeEspecialExcedido, ContaInexistente {

		Conta conta = contas.get(codigoConta);
        if (conta == null) {
      		throw new ContaInexistente();      	
        }
		conta.debitar(valor); 
	}
	
	public void adiconarNovaConta(String codigo, double saldo) throws ContaInvalida {
		contas.put(codigo, new ContaCorrente(codigo, saldo, 5000.0));
	}
	
	public double getSaldo() {
		double montante=0;
		for (Conta conta:contas.values()) {
			montante += conta.getSaldo();
		}
		return montante;
	}
	

	public static void main(String[] args)
			throws MovimentacaoInvalida, LimiteSaqueExcedido, LimiteChequeEspecialExcedido, 
			       ContaInvalida, ContaInexistente {

		// Uso de interface fluente
		Agencia<ClienteVIP> agencia001 = 
				new Agencia<ClienteVIP>().
				nome("Agencia Central").
				endereco("Praça Sete de Setembro").
				cep("30000").
				telefone("(31)99999-9999");
		
		
		ClienteVIP joao = new ClienteVIP(agencia001, "Joao", "Rua das Couves", "12345-6");
		joao.creditar("12345-6", 1300);
		joao.debitar("12345-6", 600);
		System.out.println(joao);

		ClienteVIP maria = new ClienteVIP(agencia001, "Maria", "Rua das Flores", "53321-6", 500);
		maria.debitar("53321-6", 400);
		maria.adiconarNovaConta("34567-6", 1000);
		maria.debitar("34567-6", 3000);
		System.out.println(maria);		
		System.out.println("Banco da Maria: " + obtemBancoCliente.apply(maria));
		
		
		agencia001.adicionaCliente(joao);
		agencia001.adicionaCliente(maria);
		ClienteRegular manu = 
				new ClienteRegular(agencia001, "Manu", "Rua da Manu", "54321-6");

		// agenciaVIP.adicionaCliente(manu); Manu nao pode ser adicionada para esta agencia

		// Sintaxe alternativa para criação de objetos com interface flucnete
		Agencia<ClienteVIP> agencia002 = 
				new Agencia<ClienteVIP>() {
			{ 
				nome("Agencia Secundaria");
				endereco("Praça Quinze de Novembro");
				cep("30000");
				telefone("(31)99999-9998");
			}
		};
		
		System.out.println(agencia002);
		
	}

}
