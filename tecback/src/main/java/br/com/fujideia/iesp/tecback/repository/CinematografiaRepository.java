package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Cinematografia;
import br.com.fujideia.iesp.tecback.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CinematografiaRepository extends JpaRepository<Cinematografia, Long> {
    List<Cinematografia> findByFilme(Filme filme);
    List<Cinematografia> findByPremiosContaining(String premio);
}
