// Leonardo Cadena de Souza - RM557528
package com.apdex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    private App apdex;

    @BeforeEach
    public void setup() {
        apdex = new App(557528);
    }

    @Test
    public void validarApdexExcelente() {
        float score = apdex.calcularApdex(530077, 18045);
        System.out.printf("Score Excelente: %.2f%n", score);
        assertEquals("Excelente", apdex.getRotulo(score));
    }

    @Test
    public void validarApdexBom() {
        float score = apdex.calcularApdex(474899, 46450);
        System.out.printf("Score Bom: %.2f%n", score);
        assertEquals("Bom", apdex.getRotulo(score));
    }

    @Test
    public void validarApdexRazoavel() {
        float score = apdex.calcularApdex(390269, 44602);
        System.out.printf("Score Razoável: %.2f%n", score);
        assertEquals("Razoável", apdex.getRotulo(score));
    }

    @Test
    public void validarApdexRuim() {
        float score = apdex.calcularApdex(278764, 55752);
        System.out.printf("Score Ruim: %.2f%n", score);
        assertEquals("Ruim", apdex.getRotulo(score));
    }

    @Test
    public void validarApdexInaceitavel() {
        float score = apdex.calcularApdex(111506, 27876);
        System.out.printf("Score Inaceitável: %.2f%n", score);
        assertEquals("Inaceitável", apdex.getRotulo(score));
    }

    @Test
    public void deveLancarExcecaoQuandoTotalZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            new App(0).calcularApdex(10, 5);
        });
    }

    @Test
    public void validarLimiteExcelente() {
        float score = 0.94f;
        System.out.printf("Limite Excelente: %.2f%n", score);
        assertEquals("Excelente", apdex.getRotulo(score));
    }

    @Test
    public void validarLimiteBom() {
        float score = 0.85f;
        System.out.printf("Limite Bom: %.2f%n", score);
        assertEquals("Bom", apdex.getRotulo(score));
    }

    @Test
    public void validarLimiteRazoavel() {
        float score = 0.70f;
        System.out.printf("Limite Razoável: %.2f%n", score);
        assertEquals("Razoável", apdex.getRotulo(score));
    }

    @Test
    public void validarLimiteRuim() {
        float score = 0.50f;
        System.out.printf("Limite Ruim: %.2f%n", score);
        assertEquals("Ruim", apdex.getRotulo(score));
    }
}