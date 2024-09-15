package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Critica;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.CriticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/criticas")
public class CriticaController {

    @Autowired
    private CriticaRepository criticaRepository;

    @GetMapping
    public List<Critica> listarTodas() {
        return criticaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Critica> buscarPorId(@PathVariable Long id) {
        return criticaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Critica adicionar(@RequestBody Critica critica) {
        return criticaRepository.save(critica);
    }

    @GetMapping("/filme/{filmeId}")
    public List<Critica> listarPorFilme(@PathVariable Filme filmeId) {
        return criticaRepository.findByFilme(filmeId);
    }


}

