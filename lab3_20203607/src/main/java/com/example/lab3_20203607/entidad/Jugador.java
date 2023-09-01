package com.example.lab3_20203607.entidad;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;



@Entity
@Table(name = "jugador")
@Getter
@Setter
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Esto sirve para indicar que es autoincremental
    @Column(name = "idjugador")
    private Integer idjugador;

    //el @column se usa cuando el name de la fila no estacomo se indica en la clase
    @Column(name = "nombre")
    private String nombre;

    private Integer edad;

    private String posicion;

    private String club;

    @Column(name = "sn_idSeleccion") //esta es la unica con not null activado por lo que le indico esto
    private Integer sn_idSeleccion;





}
