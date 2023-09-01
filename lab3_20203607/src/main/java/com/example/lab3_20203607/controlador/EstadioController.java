package com.example.lab3_20203607.controlador;


import com.example.lab3_20203607.entidad.Estadio;
import com.example.lab3_20203607.entidad.Jugador;
import com.example.lab3_20203607.repositorio.EstadioRepository;
import com.example.lab3_20203607.repositorio.JugadorRepository;
import com.example.lab3_20203607.repositorio.SeleccionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/estadio")
public class EstadioController {


    final EstadioRepository estadioRepository; //el repositorio siempre se debe indicar como final

    public EstadioController(EstadioRepository estadioRepository) {
        this.estadioRepository = estadioRepository;
    }

    @GetMapping("")
    public String listaEstadios (Model model){
        model.addAttribute("lista", estadioRepository.findAll()); //el metodo findall bota TODAs las filas del repositorio
        return "estadio/list";
    };






    @GetMapping("/nuevo")
    public String nuevaDistribuidora(Model model){
        //aca le paso en combobox
        return "estadio/newForm";
    };



    @PostMapping("/guardar")
    public String guardarEstadios(Estadio estadio){
        estadioRepository.save(estadio); //el metodo save si tiene un id conocida loedita y si no es conocido lo crea
        return "redirect:/estadio";
    };


    @GetMapping("/borrar")
    public String borrarEstadios(@RequestParam("id") int id){
        Optional<Estadio> optional = estadioRepository.findById(id);

        if (optional.isPresent()) {
            estadioRepository.deleteById(id); //esto borra la fila que tenga el id indicado
        }

        return "redirect:/estadio";
    };
}
