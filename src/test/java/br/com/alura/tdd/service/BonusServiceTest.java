package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {
	
	private BonusService bonusService;

	@BeforeEach
	void setup() {
		bonusService = new BonusService();
	}

	@Test
	void shouldReturnZeroIfBonusIsGreaterThanOneThousand() {
		//when
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("11000")));
		
		//then
		assertEquals(new BigDecimal("0.00"), bonus);
	}
	
	@Test
	void mustReturnTheCalculatedBonusIfTheSalaryIsLessThanTenThousand() {
		//when
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("2500")));
		
		//then
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void mustReturnTheCalculatedBonusIfTheSalaryIsExactlyTenThousand() {
		//when
		BigDecimal bonus = bonusService.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("10000")));
		
		//then
		assertEquals(new BigDecimal("1000.00"), bonus);
	}
}
