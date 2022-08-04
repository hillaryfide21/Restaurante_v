/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.controller;

import com.restaurante.entity.Puesto;
import com.restaurante.service.IPuestoService;
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
 * @author Hillary
 */
@Controller
public class PuestoController {

    @Autowired
    private IPuestoService puestoService;

    //Trae los puestos disponibles para mostrarlos en una tabla de administración
    @GetMapping("/puesto")
    public String index(Model model) {
        List<Puesto> listaPuesto = puestoService.getAllPuesto();
        model.addAttribute("titulo", "Puestos Disponibles");
        model.addAttribute("puestos", listaPuesto);
        return "puestos";
    }

    //Permite al usuario agregar un nuevo puesto 
    @GetMapping("/puestonuevo")
    public String crearPuesto(Model model) {
        model.addAttribute("puesto", new Puesto());
        return "crearPuesto";
    }

    @PostMapping("/savePuesto")
    public String guardarPuesto(@ModelAttribute Puesto puesto) {
        puestoService.savePuesto(puesto);
        return "redirect:/puesto";
    }

    /*@GetMapping("/editPuesto/{id}")
    public String editarProducto (@PathVariable("id") Long idProducto, Model model){ //permite pasar variable al html
        Producto producto = productoService.getProductoById(idProducto);
        List<Tienda> listaTiendas = tiendaService.listStore();
        model.addAttribute("producto", producto);
        model.addAttribute("tiendas",listaTiendas);
        return "crear";
    }*/
    @GetMapping("/delete/{id}") //url como se comunica controller con servicio
    public String borrarPuesto(@PathVariable("id") Long idPuesto) { //permite pasar variable al html
        puestoService.delete(idPuesto);
        return "redirect:/puesto";
    }

    @GetMapping("/homepage")
    public String index() {
        return "homepage";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/contactouser")
    public String showContactUserForm() {
        return "contactouser";
    }

    @GetMapping("/solicituduser")
    public String showSolicitudUser() {
        return "solicituduser";
    }
}
