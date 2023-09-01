package com.example.lab3_20203607.repositorio;

import com.example.lab3_20203607.entidad.Estadio;
import com.example.lab3_20203607.entidad.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadioRepository extends JpaRepository<Estadio, Integer> {
}
