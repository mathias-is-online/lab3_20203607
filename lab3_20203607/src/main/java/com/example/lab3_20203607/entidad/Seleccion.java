package com.example.lab3_20203607.entidad;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "seleccion")
@Getter
@Setter
public class Seleccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto sirve para indicar que es autoincremental
    @Column(name = "idseleccion")
    private Integer idseleccion;

    //el @column se usa cuando el name de la fila no estacomo se indica en la clase
    @Column(name = "nombre")
    private String nombre;

    private String tecnico;

    @Column(name = "estadio_idEstadio") //esta es la unica con not null activado por lo que le indico esto
    private Integer estadio_idEstadio;
}
