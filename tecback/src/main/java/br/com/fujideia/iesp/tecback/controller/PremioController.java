package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Premio;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.PremioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/premios")
public class PremioController {

    @Autowired
    private PremioRepository premioRepository;

    @GetMapping
    public List<Premio> listarTodos() {
        return premioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Premio> buscarPorId(@PathVariable Long id) {
        return premioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Premio adicionar(@RequestBody Premio premio) {
        return premioRepository.save(premio);
    }

    @GetMapping("/categoria")
    public List<Premio> listarPorCategoriaEAno(@RequestParam String categoria, @RequestParam int ano) {
        return premioRepository.findByCategoriaAndAno(categoria, ano);
    }


    }
