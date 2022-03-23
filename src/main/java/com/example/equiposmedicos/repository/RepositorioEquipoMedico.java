package com.example.equiposmedicos.repository;

import com.example.equiposmedicos.collections.EquipoMedico;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEquipoMedico extends ReactiveMongoRepository<EquipoMedico, String> {
}
