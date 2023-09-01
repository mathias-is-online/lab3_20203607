package com.example.lab3_20203607.entidad;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estadio")
@Getter
@Setter
public class Estadio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto sirve para indicar que es autoincremental
    @Column(name = "idEstadio")
    private Integer idEstadio;

    //el @column se usa cuando el name de la fila no estacomo se indica en la clase
    @Column(name = "nombre")
    private String nombre;

    private String provincia;

    private String club;
}
