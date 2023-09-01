package com.example.lab3_20203607.controlador;


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
@RequestMapping("/jugador")
public class JugadorController {

    final JugadorRepository jugadorRepository; //el repositorio siempre se debe indicar como final
    final SeleccionRepository seleccionRepository; //el repositorio siempre se debe indicar como final

    public JugadorController(JugadorRepository jugadorRepository, SeleccionRepository seleccionRepository) {
        this.jugadorRepository = jugadorRepository;
        this.seleccionRepository = seleccionRepository;

    }

    @GetMapping("")
    public String listaJugadores (Model model){
        model.addAttribute("lista", jugadorRepository.findAll()); //el metodo findall bota TODAs las filas del repositorio
        return "jugador/list";
    };






    @GetMapping("/nuevo")
    public String nuevaDistribuidora(Model model){
        //aca le paso en combobox
        model.addAttribute("lista2",seleccionRepository.findAll());
        return "jugador/newForm";
    };







    @PostMapping("/guardar")
    public String guardarJugadores(Jugador jugador){
        jugadorRepository.save(jugador); //el metodo save si tiene un id conocida loedita y si no es conocido lo crea
        return "redirect:/jugador";
    };


    @GetMapping("/borrar")
    public String borrarJugadores(@RequestParam("id") int id){
        Optional<Jugador> optional = jugadorRepository.findById(id);

        if (optional.isPresent()) {
            jugadorRepository.deleteById(id); //esto borra la fila que tenga el id indicado
        }

        return "redirect:/jugador";
    };



}
