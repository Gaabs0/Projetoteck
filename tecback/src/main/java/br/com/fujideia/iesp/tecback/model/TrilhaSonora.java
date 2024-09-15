package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TrilhaSonora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String compositor;

    @ManyToOne
    private Filme filme;

    @ElementCollection
    private List<String> faixas = new ArrayList<>();
    private double duracaoTotal;

    public void adicionarFaixa(String faixa, double duracao) {
        faixas.add(faixa);
        duracaoTotal += duracao;
    }

    public double calcularDuracaoTotal() {
        return duracaoTotal;
    }

    // Getters e Setters
}
