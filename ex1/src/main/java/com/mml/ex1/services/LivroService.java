package com.mml.ex1.services;

import com.mml.ex1.models.LivroModel;
import com.mml.ex1.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public LivroModel criarLivro(LivroModel livroModel) {
        return livroRepository.save(livroModel);
    }

    public List<LivroModel> findAll() {
        return livroRepository.findAll();
    }

    public Optional<LivroModel> buscarIdLivro(Long id) {
        return livroRepository.findById(id);
    }

    public void deletarLivro(Long id) {
        livroRepository.deleteById(id);
    }
}
