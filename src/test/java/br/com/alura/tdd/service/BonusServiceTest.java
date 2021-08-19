package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.exception.BonusException;
import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	private BonusService bonusService;

	@BeforeEach
	void setup() {
		bonusService = new BonusService();
	}

	@Test
	void shouldReturnZeroIfBonusIsGreaterThanOneThousand() throws BonusException {
		// then
		assertThrows(BonusException.class,
				() -> bonusService.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("11000"))));
	}

	@Test
	void mustReturnTheCalculatedBonusIfTheSalaryIsLessThanTenThousand() throws BonusException {
		// when
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("2500")));

		// then
		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void mustReturnTheCalculatedBonusIfTheSalaryIsExactlyTenThousand() throws BonusException {
		// when
		BigDecimal bonus = bonusService
				.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("10000")));

		// then
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
}
