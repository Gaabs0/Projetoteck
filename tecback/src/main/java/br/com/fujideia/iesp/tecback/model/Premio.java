package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Premio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int ano;
    private String categoria;

    @ManyToOne
    private Filme filme;

    public static List<Premio> listarVencedores(List<Premio> premios, String categoria, int ano) {
        List<Premio> vencedores = new ArrayList<>();
        for (Premio premio : premios) {
            if (premio.getCategoria().equals(categoria) && premio.filme.getAnoLancamento() == ano) {
                vencedores.add(premio);
            }
        }
        return vencedores;
    }


}
