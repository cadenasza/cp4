// Leonardo Cadena de Souza - RM557528

package com.apdex;

public class App {

    private final int totalSamples; // sempre será o RM

    public App(int rm) {
        this.totalSamples = rm;
    }

    /**
     * Calcula o índice APDEX
     * @param s quantidade de respostas satisfeitas
     * @param t quantidade de respostas toleráveis
     * @return score APDEX entre 0 e 1
     */
    public float calcularApdex(int s, int t) {
        if (totalSamples <= 0) {
            throw new IllegalArgumentException("Total de amostras deve ser maior que zero");
        }
        return (s + (t / 2.0f)) / totalSamples;
    }

    /**
     * Retorna a classificação do Apdex de acordo com o score
     */
    public String getRotulo(float score) {
        if (score >= 0.94f && score <= 1.0f) return "Excelente";
        if (score >= 0.85f && score <= 0.93f) return "Bom";
        if (score >= 0.70f && score <= 0.84f) return "Razoável";
        if (score >= 0.50f && score <= 0.69f) return "Ruim";
        return "Inaceitável";
    }

    public int getTotalSamples() {
        return totalSamples;
    }
}