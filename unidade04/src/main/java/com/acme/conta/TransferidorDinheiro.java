/**
 * 
 */
package com.acme.conta;

import com.acme.excecoes.LimiteChequeEspecialExcedido;
import com.acme.excecoes.LimiteSaqueExcedido;
import com.acme.excecoes.MovimentacaoInvalida;

/**
 * @author Marco Mendes
 * @since 2017
 * 
 * Pontos de an�lise
 *  - Fun��es est�ticas
 *  - Construtores privativos
 * 
 */
public class TransferidorDinheiro {
	
	private TransferidorDinheiro() {}
	
    static void transferir(IConta origem, IConta destino, double valor) 
    		throws MovimentacaoInvalida, LimiteSaqueExcedido, LimiteChequeEspecialExcedido {
    	     origem.debitar(valor);
    	     destino.creditar(valor);
    }
}
