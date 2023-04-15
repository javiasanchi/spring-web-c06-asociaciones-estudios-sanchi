package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "tienda")
public class Tienda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "num_empl")
    private String numEmpl;

    @Column(name = "numb_puesto")
    private Integer numbPuesto;

    @Column(name = "hor_aper")
    private LocalTime horAper;

    @Column(name = "hor_cierre")
    private LocalTime horCierre;
    @ManyToOne
    private  Mercado mercado;

}