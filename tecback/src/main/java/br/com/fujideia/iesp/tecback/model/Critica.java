package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Critica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private String comentario;
    private int nota;

    @ManyToOne
    private Filme filme;

    public void avaliarFilme(Filme filme, int nota, String comentario) {
        this.filme = filme;
        this.nota = nota;
        this.comentario = comentario;
    }

    public static List<Critica> listarCriticas(List<Critica> criticas, Filme filme) {
        List<Critica> criticasFilme = new ArrayList<>();
        for (Critica critica : criticas) {
            if (critica.getFilme().equals(filme)) {
                criticasFilme.add(critica);
            }
        }
        return criticasFilme;
    }

    // Método para calcular nota média de um filme
    public static double calcularNotaMedia(List<Critica> criticas, Filme filme) {
        double total = 0;
        int count = 0;
        for (Critica critica : listarCriticas(criticas, filme)) {
            total += critica.getNota();
            count++;
        }
        return count == 0 ? 0 : total / count;
    }

}
