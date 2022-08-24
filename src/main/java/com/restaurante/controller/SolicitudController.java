/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.controller;

import com.restaurante.entity.Puesto;
import com.restaurante.entity.Solicitud;
import com.restaurante.service.IPuestoService;
import com.restaurante.service.ISolicitudService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Hillary
 */
@Controller
public class SolicitudController {
    @Autowired
    private ISolicitudService solicitudService;
    @Autowired
    private IPuestoService puestoService;
/*
    //Trae los cupones disponibles para mostrarlos en una tabla de administración
    @GetMapping("/solicitud")
    public String index(Model model) {
        List<Solicitud> listaSolicitud = solicitudService.getAllSolicitud();
        model.addAttribute("titulo", "Lista de Solicitudes");
        model.addAttribute("solicitudes", listaSolicitud);
        return "crearSolicitud";
    */
    
    //Permite al usuario agregar un nuevo cupon 
    @GetMapping("/solicitudnuevo")
    public String crearSolicitud(Model model) {
        model.addAttribute("solicitud", new Solicitud());
        return "solicitudTest";
    }
    
   @PostMapping("/saveSolicitud") 
    public String guardarSolicitud (@ModelAttribute Solicitud solicitud){ 
        solicitudService.saveSolicitud(solicitud);
        return "redirect:/solicitudes";
    }
    
        @GetMapping("/solicituduser")
    public String showSolicitudUser(Model model) {
        List<Puesto> listaPuesto = puestoService.getAllPuesto();
        model.addAttribute("puestos", listaPuesto);
        model.addAttribute("soli", new Solicitud());
        return "solicituduser";
    }
    
   /* @GetMapping("/editPuesto/{id}")
    public String editarProducto (@PathVariable("id") Long idProducto, Model model){ //permite pasar variable al html
        Producto producto = productoService.getProductoById(idProducto);
        List<Tienda> listaTiendas = tiendaService.listStore();
        model.addAttribute("producto", producto);
        model.addAttribute("tiendas",listaTiendas);
        return "crear";
    }
    
    
    
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
    }*/
}
