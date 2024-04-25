package edu.pe.cibertec.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "curso")
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcurso", nullable = false)
    private Integer id;

    @Column(name = "nomcurso", nullable = false, length = 100)
    private String nomcurso;

    @Column(name = "fechainicio")
    private LocalDate fechainicio;

    @Column(name = "alumnosmin", nullable = false)
    private Integer alumnosmin;

    @Column(name = "alumnosact", length = 100)
    private String alumnosact;

    @Column(name = "estado")
    private Integer estado;

}