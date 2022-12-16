package com.javatechie.spring.batch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PACIENTES_INFO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @Column(name = "PACIENTE_ID")
    private int id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "GENERO")
    private String genero;
    @Column(name = "NUM_CONTACTO")
    private String numContacto;
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "CUMPLEANOS")
    private String cumpleanos;
    
}
