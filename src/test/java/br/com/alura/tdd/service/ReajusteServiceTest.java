package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario( "Funcionario Teste", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    void reajusteDeveriaSerDe3PorCentoQuandoDesempenhoForADesejar() {

        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(funcionario.getSalario(), new BigDecimal("1030.00"));
    }

    @Test
    void reajusteDeveriaSerDe15PorCentoQuandoDesempenhoForBom() {

        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(funcionario.getSalario(), new BigDecimal("1150.00"));
    }

    @Test
    void reajusteDeveriaSerDe20PorCentoQuandoDesempenhoForOtimo() {

        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(funcionario.getSalario(), new BigDecimal("1200.00"));
    }
}
