package com.example.lab3_20203607.repositorio;

import com.example.lab3_20203607.entidad.Jugador;
import com.example.lab3_20203607.entidad.Seleccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeleccionRepository extends JpaRepository<Seleccion, Integer> {
}
