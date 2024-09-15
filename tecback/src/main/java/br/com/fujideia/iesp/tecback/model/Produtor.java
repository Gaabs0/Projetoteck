package br.com.fujideia.iesp.tecback.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Produtor {
    private String nome;
    private int idade;
    private String nacionalidade;
    private List<String> filmesProduzidos;

    public Produtor(String nome, int idade, String nacionalidade) {
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        this.filmesProduzidos = new ArrayList<>();
    }

    public void adicionarFilme(String filme) {
        filmesProduzidos.add(filme);
    }

    public List<String> listarFilmes() {
        return filmesProduzidos;
    }

    public String getNome() {
        return nome;
    }
}
