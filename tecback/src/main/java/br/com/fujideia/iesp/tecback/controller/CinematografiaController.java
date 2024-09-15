package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.Cinematografia;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.CinematografiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinematografia")
public class CinematografiaController {

    @Autowired
    private CinematografiaRepository cinematografiaRepository;

    @GetMapping
    public List<Cinematografia> listarTodas() {
        return cinematografiaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cinematografia> buscarPorId(@PathVariable Long id) {
        return cinematografiaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cinematografia adicionar(@RequestBody Cinematografia cinematografia) {
        return cinematografiaRepository.save(cinematografia);
    }

    @GetMapping("/filme/{filmeId}")
    public List<Cinematografia> listarPorFilme(@PathVariable Filme filmeId) {
        return cinematografiaRepository.findByFilme(filmeId);
    }

    @GetMapping("/premios/{premio}")
    public List<Cinematografia> listarPorPremio(@PathVariable String premio) {
        return cinematografiaRepository.findByPremiosContaining(premio);
    }


}
