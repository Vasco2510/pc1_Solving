package com.pc1.pc1_24.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//@Data // Anotacion atajo pero tener cuidado que no se puede usar con entity
@Entity
@Table(name = "Tarea")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarea {

    @Id
    @Column(nullable = false, unique = true) // Código único y obligatorio
    private String codigo; // Cambiado de Long a String (según enunciado: "código único")

    @Column(nullable = false) // Nombre obligatorio
    private String nombre;

    @Column(nullable = false) // Descripción obligatoria
    private String descripcion;

    @Column(name = "fecha_inicio", nullable = false) // Fecha obligatoria
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin", nullable = false) // Fecha obligatoria
    private LocalDate fechaFin;



    // Una tarea tiene un responsable
    @ManyToOne // CHECKED
    @JoinColumn (name = "reponsable_id")
    private Employee responsable;

    // Una tarea pertenece a un proyecto
    @ManyToOne // CHECKED
    @JoinColumn(name = "proyecto_id")
    private Project proyecto;

}

