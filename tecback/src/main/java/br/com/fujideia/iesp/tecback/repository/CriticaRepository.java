package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Critica;
import br.com.fujideia.iesp.tecback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CriticaRepository extends JpaRepository<Critica, Long> {
    List<Critica> findByFilme(Filme filme);
}
