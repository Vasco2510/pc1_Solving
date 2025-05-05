package com.pc1.pc1_24.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.mapping.Set;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

//@Data // Anotacion atajo pero tener cuidado que no se puede usar con entity
@Entity
@Table(name = "Project")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fechaInicio;// auxiliar para asi calcular el deadline

    @Column(nullable = false)
    private LocalDate fechaFin;


    // Un projecto tine un lider
    @ManyToOne // CHECKED
    @JoinColumn(name = "empleado_lider_id")
    private Employee empleadoLider;


    // Un proyecto tiene muchas tareas y una tarea pertence solo a un proyecto.
    // Ello entendiendo que una tarea tiene un código unico
    //y por ello la hace unica en un projecto e irrepetible en otro.
    @OneToMany(mappedBy = "proyecto") // CHECKED
    private List<Tarea> tareas;


    // relacion muchos proyecto a muchos empleados
    @ManyToMany // CHECKED
    @JoinTable(
            name = "proyecto_empleado", //tabla intermedia
            joinColumns = @JoinColumn(name = "proyecto_id"),
            inverseJoinColumns = @JoinColumn(name = "empleado_id")
    )
    private List<Employee> empleados;

}


/*
    // Métodos para agregar y remover empleados del proyecto (opcional pero útil)
    public void agregarEmpleado(Employee empleado) {
        this.empleados.add(empleado);
        empleado.getProyectos().add(this);
    }

    public void removerEmpleado(Employee empleado) {
        this.empleados.remove(empleado);
        empleado.getProyectos().remove(this);
    }*/
