package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

class ReajusteServiceTest {
	
	private Funcionario funcionario;
	private ReajusteService reajusteService;

	@BeforeEach
	void setup() {
		funcionario = new Funcionario("João", LocalDate.now(), new BigDecimal("1000.00"));
		reajusteService = new ReajusteService();
	}

	@Test
	void mustReadjustTheSalaryIfTheReadjustmentIsThreePercent() {
		//when
		reajusteService.concedeReajuste(funcionario, Desempenho.A_DESEJAR);
	
		//then
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	void mustReadjustTheSalaryIfTheReadjustmentIsFifteenPercent() {
		//when
		reajusteService.concedeReajuste(funcionario, Desempenho.BOM);
	
		//then
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
}
