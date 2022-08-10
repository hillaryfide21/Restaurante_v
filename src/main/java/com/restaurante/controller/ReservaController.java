/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.controller;

import com.restaurante.entity.Restaurantes;
import com.restaurante.service.IRestaurantesService;
import com.restaurante.entity.Reservas;
import com.restaurante.service.IReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Marvin Camacho
 */


@Controller
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

    @Autowired
    private IRestaurantesService restauranteService;

    @GetMapping("/reservas")
    public String index(Model model) {
        List<Reservas> listReservas = reservaService.getAllReservas();
        model.addAttribute("titulo", "Tabla de Reservas");
        model.addAttribute("reservas", listReservas);
        return "reservas";
    }

    @GetMapping("/reservaN")
    public String CrearReserva(Model model) {
        List<Restaurantes> ListRestaurantes = restauranteService.getAllData();
        model.addAttribute("reserva", new Reservas());
        model.addAttribute("restaurantes", ListRestaurantes);
        
        return "crearReserva";
    }

    @PostMapping("/saveReserva")
    public String GuardarReserva(@ModelAttribute Reservas reservas) {
        
        reservaService.saveReserva(reservas);
        return "redirect:/reservas";
    }

    @GetMapping("/editReserva/{id}")
    public String editarReserva(@PathVariable("id") long id_reserva, Model model) {
        Reservas reservas = reservaService.getReservaByid_usuario(id_reserva);
        List<Restaurantes> listRol = restauranteService.getAllData();
        model.addAttribute("reserva", reservas);
        model.addAttribute("restaurantes", listRol);
        return "crearReserva";
    }

    @GetMapping("/deleteReserva/{id}")
    public String eliminarUsuario(@PathVariable("id") long id_usuario) {
        reservaService.delete(id_usuario);
        return "redirect:/reservas";

    }
}
