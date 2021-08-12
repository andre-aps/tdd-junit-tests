package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal bonus = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (bonus.compareTo(new BigDecimal("1000")) > 0) {
			bonus = BigDecimal.ZERO;
		}
		return bonus.setScale(2, RoundingMode.HALF_UP);
	}

}
