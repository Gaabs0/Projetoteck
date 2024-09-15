package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Premio;
import br.com.fujideia.iesp.tecback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PremioRepository extends JpaRepository<Premio, Long> {
    List<Premio> findByCategoriaAndAno(String categoria, int ano);
    List<Premio> findByFilme(Filme filme);
}
