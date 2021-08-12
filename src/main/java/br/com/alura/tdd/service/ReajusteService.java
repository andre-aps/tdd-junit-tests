package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void concedeReajuste(Funcionario funcionario, Desempenho desempenho) {
		BigDecimal percentual = desempenho.percentualReajuste();
		funcionario.reajustaSalario(funcionario.getSalario().multiply(percentual));
	}

}
