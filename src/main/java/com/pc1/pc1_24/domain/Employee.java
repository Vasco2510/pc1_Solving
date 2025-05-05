package com.pc1.pc1_24.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//@Data // Anotacion atajo pero tener cuidado que no se puede usar con entity
@Entity
@Table(name = "Employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder //@ToString // Genera el toString() de la clase // @EqualsAndHashCode(onlyExplicitlyIncluded = true) // Genera equals() y hashCode() basados en los campos marcados
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String JoinDate;


    // responsable desde una a varias tareas
    // CHECKED
    @OneToMany (mappedBy = "responsable", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Tarea> tareas;


    //lider de un proyecto
    // CHECKED
    @OneToMany(mappedBy = "empleadoLider", cascade = CascadeType.ALL, fetch = FetchType.LAZY  ) // Primero completé en el que es dueño de la relacion
    private List<Project> proyectosLiderados;

    // empleado de un proyecto
    // CHECKED
    @ManyToMany (mappedBy = "empleados", fetch = FetchType.EAGER)
    private List<Project> proyectos;

}



   /* // Métodos para agregar y remover empleados del proyecto (opcional pero útil)
    public void agregarEmpleado(Employee empleado) {
        this.empleados.add(empleado);
        empleado.getProyectos().add(this);

    }
*/

/*
    public void removerEmpleado(Employee empleado) {
        this.empleados.remove(empleado);
        empleado.getProyectos().remove(this);
    }*/
