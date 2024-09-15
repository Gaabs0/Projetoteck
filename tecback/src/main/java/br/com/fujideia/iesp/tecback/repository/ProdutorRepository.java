package br.com.fujideia.iesp.tecback.repository;

import br.com.fujideia.iesp.tecback.model.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, Long> {
    List<Produtor> findByNome(String nome);
}














