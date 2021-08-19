package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.exception.BonusException;
import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) throws BonusException {
		BigDecimal bonus = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (bonus.compareTo(new BigDecimal("1000")) > 0) {
			throw new BonusException("Bônus superior à R$ 1.000,00");
		}
		return bonus.setScale(2, RoundingMode.HALF_UP);
	}

}
