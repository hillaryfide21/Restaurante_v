package com.restaurante.controller;

import com.restaurante.entity.Restaurantes;
import com.restaurante.entity.horarioReservas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.restaurante.service.IRestaurantesService;

@Controller
public class RestaurantesController {

    @Autowired
    private IRestaurantesService restaurantesService;
    
    //Página que ve el usuario
    @GetMapping("/restaurantes")
    public String obtenerRestaurantes (Model model) {
        List<Restaurantes> listaInfo = restaurantesService.getAllData();
        model.addAttribute("titulo", "Restaurantes");
        model.addAttribute("restaurantes", listaInfo);

        return "restaurantes";
    }
    
    //Páginas que ve el administrador
    @GetMapping("/restaurantesT")
    public String obtenerRestaurantesT (Model model) {
        List<Restaurantes> listaInfo = restaurantesService.getAllData();
        model.addAttribute("titulo", "Restaurantes");
        model.addAttribute("restaurantes", listaInfo);

        return "restaurantesT";
    }

   @GetMapping("/restauranteNuevo")
    public String crearRestaurante (Model model) {
        model.addAttribute("restaurante", new Restaurantes());
        return "crearRestaurante";
    }
    
    @PostMapping("/saveRestaurante")
    public String guardarRestaurante (@ModelAttribute Restaurantes info) {
        restaurantesService.saveInformacion(info);
        return "redirect:/restaurantesT";
    }
    
    /*@GetMapping("/edit_rest/{id_restaurante}")
    public String editarRestaurante (@PathVariable("id_restaurante") Long idRest, Model model) {
        Restaurantes rest = restaurantesService.getDataById(idRest);
        model.addAttribute("restaurante", rest);
        return "crearRestaurante";
    }*/

    @GetMapping("/delete_rest/{id_restaurante}")
    public String eliminarData (@PathVariable("id_restaurante") Long idRest) {
        restaurantesService.delete(idRest);
        return "redirect:/restaurantesT";

    }
    
}
