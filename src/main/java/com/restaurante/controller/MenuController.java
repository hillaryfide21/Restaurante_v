package com.restaurante.controller;

import com.restaurante.entity.Categorias;
import com.restaurante.entity.Menu;
import com.restaurante.service.ICategoriasService;
import com.restaurante.service.IMenuService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    @Autowired
    private ICategoriasService categoriasService;

    @Autowired
    private IMenuService menuService;

    @GetMapping("/menu")
    public String obtenerCategorias(Model model) {
        List<Categorias> listaCategorias = categoriasService.listaCategorias();
        model.addAttribute("categorias", listaCategorias);

        return "menu";
    }

    @GetMapping("/pizzas")
    public String obtenerDataPizzas(Model model) {
        Categorias categoria = new Categorias(3);
        categoria.getId_categoria();
        List<Menu> listaInfo = menuService.findAll(categoria);
        model.addAttribute("titulo", "Nuestras Pizzas");
        model.addAttribute("pizzas", listaInfo);

        List<Categorias> listaCategorias = categoriasService.listaCategorias();
        model.addAttribute("categorias", listaCategorias);
        
        return "informacionPizzas";
    }

    @GetMapping("/ensaladas")
    public String obtenerDataEnsaladas(Model model) {
        Categorias categoria = new Categorias(2);
        categoria.getId_categoria();
        List<Menu> listaInfo = menuService.findAll(categoria);
        model.addAttribute("titulo", "Nuestras Ensaladas");
        model.addAttribute("ensaladas", listaInfo);
        
        List<Categorias> listaCategorias = categoriasService.listaCategorias();
        model.addAttribute("categorias", listaCategorias);

        return "informacionEnsaladas";
    }
}
