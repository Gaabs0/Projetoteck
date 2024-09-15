package br.com.fujideia.iesp.tecback.controller;

import br.com.fujideia.iesp.tecback.model.TrilhaSonora;
import br.com.fujideia.iesp.tecback.model.Filme;
import br.com.fujideia.iesp.tecback.repository.TrilhaSonoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trilhasSonoras")
public class TrilhaSonoraController {

    @Autowired
    private TrilhaSonoraRepository trilhaSonoraRepository;

    @GetMapping
    public List<TrilhaSonora> listarTodas() {
        return trilhaSonoraRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrilhaSonora> buscarPorId(@PathVariable Long id) {
        return trilhaSonoraRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public TrilhaSonora adicionar(@RequestBody TrilhaSonora trilhaSonora) {
        return trilhaSonoraRepository.save(trilhaSonora);
    }

    @GetMapping("/filme/{filmeId}")
    public List<TrilhaSonora> listarPorFilme(@PathVariable Filme filmeId) {
        return trilhaSonoraRepository.findByFilme(filmeId);
    }

    @GetMapping("/compositor/{compositor}")
    public List<TrilhaSonora> listarPorCompositor(@PathVariable String compositor) {
        return trilhaSonoraRepository.findByCompositor(compositor);


    }}