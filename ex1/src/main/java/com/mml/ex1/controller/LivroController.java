package com.mml.ex1.controller;

import com.mml.ex1.models.LivroModel;
import com.mml.ex1.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<LivroModel> criarLivro(@RequestBody LivroModel livroModel) {
        LivroModel request = livroService.criarLivro(livroModel);

        URI uri = URI.create("/livros/" + request.getId());
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<LivroModel>> findAll() {
        List<LivroModel> request = livroService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LivroModel>> buscarIdLivro(@PathVariable Long id) {
        Optional<LivroModel> request = livroService.buscarIdLivro(id);
        return ResponseEntity.ok().body(request);
    }
}