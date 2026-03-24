package com.mml.ex1.repositories;

import com.mml.ex1.models.LivroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<LivroModel, Long > {
}
