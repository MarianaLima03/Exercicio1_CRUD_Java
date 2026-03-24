package com.mml.ex1.controller;

import com.mml.ex1.models.LivroModel;
import com.mml.ex1.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/livro")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping
    public LivroModel criarLivro(@RequestBody LivroModel livroModel) {
        return livroService.criarLivro(livroModel);
    }

    @GetMapping
    public List<LivroModel> listarLivros() {
        return livroService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<LivroModel> buscarIdLivro(@PathVariable Long id) {
        return livroService.buscarIdLivro(id);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        livroService.deletarLivro(id);
    }
}
