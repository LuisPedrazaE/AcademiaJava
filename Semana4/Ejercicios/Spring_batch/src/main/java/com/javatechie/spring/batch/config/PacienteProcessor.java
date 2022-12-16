package com.javatechie.spring.batch.config;

import com.javatechie.spring.batch.entity.Paciente;
import org.springframework.batch.item.ItemProcessor;

public class PacienteProcessor implements ItemProcessor<Paciente,Paciente> {

    @Override
    public Paciente process(Paciente paciente) throws Exception {
        
        return paciente;
        
    }
}
