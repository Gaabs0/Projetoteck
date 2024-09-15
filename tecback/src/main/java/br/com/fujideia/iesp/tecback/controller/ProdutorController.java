package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Produtor;
import br.com.fujideia.iesp.tecback.repository.ProdutorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtores")
@RequiredArgsConstructor
@Slf4j
public class ProdutorController {

    @Autowired
    private ProdutorRepository produtorRepository;

    @GetMapping
    public List<Produtor> listarTodos() {
        return produtorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtor> buscarPorId(@PathVariable Long id) {
        return produtorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/buscarPorNome")
    public List<Produtor> buscarPorNome(@RequestParam String nome) {
        return produtorRepository.findByNome(nome);
    }

    @PostMapping
    public Produtor adicionar(@RequestBody Produtor produtor) {
        return produtorRepository.save(produtor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produtor> atualizar(@PathVariable Long id, @RequestBody Produtor produtor) {
        return produtorRepository.findById(id)
                .map(p -> {
                    p.setNome(produtor.getNome());
                    p.setIdade(produtor.getIdade());
                    p.setNacionalidade(produtor.getNacionalidade());
                    return ResponseEntity.ok(produtorRepository.save(p));
                })
                .orElse(ResponseEntity.notFound().build());
    }


}
