/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.controller;

import com.restaurante.entity.Contacto;
import com.restaurante.service.IContactoService;
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
 * @author XPC
 */
@Controller
public class ContactoController {
    @Autowired
    private IContactoService contactoService;
    
    //Trae los puestos disponibles para mostrarlos en una tabla de administración
    @GetMapping("/contacto")
    public String index(Model model) {
        List<Contacto> listaContacto = contactoService.getAllContacto();
        model.addAttribute("titulo", "Tabla Contactos");
        model.addAttribute("contactos", listaContacto);
        return "contactos";
    }
    
    //Permite al usuario agregar un nuevo puesto 
    @GetMapping("/contactonuevo")
    public String crearContacto(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "crearContacto";
    }
    
   @PostMapping("/saveContacto") 
    public String guardarContacto (@ModelAttribute Contacto contacto){ 
        contactoService.saveContacto(contacto);
        return "redirect:/contacto";
    }
    /*
    @GetMapping("/editContacto/{id}")
    public String editarProducto (@PathVariable("id") Long idProducto, Model model){ //permite pasar variable al html
        Producto producto = productoService.getProductoById(idProducto);
        List<Tienda> listaTiendas = tiendaService.listStore();
        model.addAttribute("producto", producto);
        model.addAttribute("tiendas",listaTiendas);
        return "crear";
    }
    */
    
    
    @GetMapping("/deleteContacto/{id}") //url como se comunica controller con servicio
    public String borrarContacto (@PathVariable("id") Long idContacto){ //permite pasar variable al html
        contactoService.delete(idContacto);
        return "redirect:/contacto";
    }
    
}
