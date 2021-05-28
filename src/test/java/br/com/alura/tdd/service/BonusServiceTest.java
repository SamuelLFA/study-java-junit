package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        var service = new BonusService();
        var funcionario = new Funcionario(
                "FuncionarioTeste",
                LocalDate.now(),
                new BigDecimal("20000")
        );

        assertThrows(IllegalArgumentException.class, 
                () -> service.calcularBonus(funcionario));
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        var service = new BonusService();
        var funcionario = new Funcionario("FuncionarioTeste", LocalDate.now(), new BigDecimal("2500"));
        var bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalarioQuandoSalarioFor10000() {
        var service = new BonusService();
        var funcionario = new Funcionario("FuncionarioTeste", LocalDate.now(), new BigDecimal("10000"));
        var bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
