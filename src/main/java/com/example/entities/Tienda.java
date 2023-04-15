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

    @Column(length = 9)
    private Integer telefono;

    @Column(name = "email", unique = true)
    private String email;

    private Integer numEmpl;

    private Integer numbPuesto;

    private LocalTime horAper;

    private LocalTime horCierre;
    @ManyToOne
    private  Mercado mercado;

}