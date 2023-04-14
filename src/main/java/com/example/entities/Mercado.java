package com.example.entities;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "mercado")
public class Mercado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    @Column(length = 9)
    private Integer telefono;
    @Column(unique = true)
    private String email;
    private String ciudad;
    private String cif;
    private Integer numPuestos;
    private Boolean abierto;


}