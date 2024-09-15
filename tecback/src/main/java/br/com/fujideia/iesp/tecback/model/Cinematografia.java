package br.com.fujideia.iesp.tecback.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data

@NoArgsConstructor
@Entity

public class Cinematografia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String diretorDeFotografia;
    private String estilo;

    @ManyToOne
    private Filme filme;

    @ElementCollection
    private List<String> premios = new ArrayList<>();

    public void adicionarPremio(String premio) {
        premios.add(premio);
    }

    public List<String> listarPremios() {
        return premios;
    }

}
