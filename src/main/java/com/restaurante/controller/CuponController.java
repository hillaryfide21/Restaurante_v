/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.controller;

import com.restaurante.entity.Cupon;
import com.restaurante.service.ICuponService;
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
public class CuponController {
    @Autowired
    private ICuponService cuponService;

    //Trae los cupones disponibles para mostrarlos en una tabla de administración
    @GetMapping("/cupon")
    public String index(Model model) {
        List<Cupon> listaCupon = cuponService.getAllCupon();
        model.addAttribute("titulo", "Descuentos Disponibles");
        model.addAttribute("cupones", listaCupon);
        return "cupones";
    }
    
    //Permite al usuario agregar un nuevo cupon 
    @GetMapping("/cuponnuevo")
    public String crearCupon(Model model) {
        model.addAttribute("cupon", new Cupon());
        return "crearCupon";
    }
    
   @PostMapping("/saveCupon") 
    public String guardarCupon (@ModelAttribute Cupon cupon){ 
        cuponService.saveCupon(cupon);
        return "redirect:/cupon";
    }
    
   /* @GetMapping("/editPuesto/{id}")
    public String editarProducto (@PathVariable("id") Long idProducto, Model model){ //permite pasar variable al html
        Producto producto = productoService.getProductoById(idProducto);
        List<Tienda> listaTiendas = tiendaService.listStore();
        model.addAttribute("producto", producto);
        model.addAttribute("tiendas",listaTiendas);
        return "crear";
    }*/
    
    
    
    @GetMapping("/delete_cupon/{id}") //url como se comunica controller con servicio
    public String borrarCupon (@PathVariable("id") Long idCupon){ //permite pasar variable al html
        cuponService.delete(idCupon);
        return "redirect:/cupon";
    }
    
    //Cupones que ve el usuario
    @GetMapping("/cuponesuser")
    public String traerCupones(Model model) {
        List<Cupon> listaCupon = cuponService.getAllCupon();
        model.addAttribute("titulo", "Descuentos Disponibles");
        model.addAttribute("cupones", listaCupon);
        return "cuponesuser";
    }
}

 