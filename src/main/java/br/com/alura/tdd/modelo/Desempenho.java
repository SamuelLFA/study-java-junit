package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.03");
        }
    },
    BOM {
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.15");
        }
    },
    OTIMO {
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.2");
        }
    };

    public abstract BigDecimal percentualReajuste();
}
