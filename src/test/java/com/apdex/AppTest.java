// Leonardo Cadena de Souza - RM557528

package com.apdex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private App apdex;

    @BeforeEach
    public void setup() {
        // inicializa sempre com o RM como total de amostras
        apdex = new App(557528);
    }

    @Test
    public void validarApdexExcelente() {
        float score = apdex.calcularApdex(530077, 18045); // ≈ 0.97
        assertEquals("Excelente", apdex.getRotulo(score));
    }

    @Test
    public void validarApdexBom() {
        float score = apdex.calcularApdex(474899, 46450); // ≈ 0.89
        assertEquals("Bom", apdex.getRotulo(score));
    }

    @Test
    public void validarApdexRazoavel() {
        float score = apdex.calcularApdex(390269, 44602); // ≈ 0.74
        assertEquals("Razoável", apdex.getRotulo(score));
    }

    @Test
    public void validarApdexRuim() {
        float score = apdex.calcularApdex(278764, 55752); // ≈ 0.55
        assertEquals("Ruim", apdex.getRotulo(score));
    }

    @Test
    public void validarApdexInaceitavel() {
        float score = apdex.calcularApdex(111506, 27876); // ≈ 0.25
        assertEquals("Inaceitável", apdex.getRotulo(score));
    }

    @Test
    public void deveLancarExcecaoQuandoTotalZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new App(0).calcularApdex(10, 5);
        });
    }
}