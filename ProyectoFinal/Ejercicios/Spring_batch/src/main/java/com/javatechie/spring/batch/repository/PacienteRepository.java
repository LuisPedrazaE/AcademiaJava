package com.javatechie.spring.batch.repository;

import com.javatechie.spring.batch.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository  extends JpaRepository<Paciente,Integer> {
}
