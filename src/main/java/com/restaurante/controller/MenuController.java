package com.restaurante.controller;

import com.restaurante.entity.Categorias;
import com.restaurante.entity.DetalleOrden;
import com.restaurante.entity.Menu;
import com.restaurante.entity.Orden;
import com.restaurante.service.ICategoriasService;
import com.restaurante.service.IDetalleOrdenService;
import com.restaurante.service.IMenuService;
import com.restaurante.service.IOrdenService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MenuController {

    //private final Logger log = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private ICategoriasService categoriasService;

    @Autowired
    private IMenuService menuService;

    @Autowired
    private IOrdenService ordenService;

    @Autowired
    private IDetalleOrdenService detalleOrdenService;

    //Para almacenar los detalles de la orden
    List<DetalleOrden> detalles = new ArrayList<>();

    //Almacena los datos de la orden
    Orden orden = new Orden();

    @GetMapping("/")
    public String Home(){
        return "homepage";
    }
    
    @GetMapping("/menu")
    public String obtenerCategorias(Model model) {
        List<Categorias> listaCategorias = categoriasService.listaCategorias();
        model.addAttribute("categorias", listaCategorias);

        return "menu";
    }

    @GetMapping("/entradas")
    public String obtenerDataEntradas(Model model) {
        Categorias categoria = new Categorias(1);
        categoria.getId_categoria();
        List<Menu> listaInfo = menuService.findAll(categoria);
        model.addAttribute("titulo", "Nuestras Entradas");
        model.addAttribute("entradas", listaInfo);

        List<Categorias> listaCategorias = categoriasService.listaCategorias();
        model.addAttribute("categorias", listaCategorias);

        return "informacionEntradas";
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
    
    @GetMapping("/pastas")
    public String obtenerDataPastas(Model model) {
        Categorias categoria = new Categorias(4);
        categoria.getId_categoria();
        List<Menu> listaInfo = menuService.findAll(categoria);
        model.addAttribute("titulo", "Nuestras Pastas");
        model.addAttribute("pastas", listaInfo);

        List<Categorias> listaCategorias = categoriasService.listaCategorias();
        model.addAttribute("categorias", listaCategorias);

        return "informacionPastas";
    }
    
    @GetMapping("/bebidas")
    public String obtenerDataBebidas(Model model) {
        Categorias categoria = new Categorias(5);
        categoria.getId_categoria();
        List<Menu> listaInfo = menuService.findAll(categoria);
        model.addAttribute("titulo", "Nuestras Bebidas");
        model.addAttribute("bebidas", listaInfo);

        List<Categorias> listaCategorias = categoriasService.listaCategorias();
        model.addAttribute("categorias", listaCategorias);

        return "informacionBebidas";
    }
    

    @PostMapping("/carrito")
    public String addCarrito(@RequestParam(value = "id_producto") Long id, Model model) {
        DetalleOrden detalleOrden = new DetalleOrden();
        Menu producto = new Menu();
        double sumaTotal = 0;
        double cantidad = detalleOrden.getCantidad();
        
        List<DetalleOrden> ordenesNueva = new ArrayList<>();

        Optional<Menu> optionalProducto = menuService.getDataById(id);
        //log.info("Producto añadido: {}", optionalProducto.get());
        //log.info("Cantidad: {}", cantidad);
        producto = optionalProducto.get();

        detalleOrden.setCantidad(cantidad+1);
        detalleOrden.setPrecio(Integer.valueOf(producto.getPrecio_producto()));
        detalleOrden.setNombre(producto.getNombre_producto());
        detalleOrden.setTotal(Integer.valueOf(producto.getPrecio_producto()) * detalleOrden.getCantidad());
        detalleOrden.setId_producto(producto);

        //validar que le producto no se añada 2 veces
        long Id_producto = producto.getId_producto();
        boolean ingresado = detalles.stream().anyMatch(p -> p.getId_producto().getId_producto() == Id_producto);

        if (!ingresado) {
            detalles.add(detalleOrden);
        } else if (ingresado) {
            for (DetalleOrden detalle : detalles) {
                if (detalle.getId_producto().getId_producto() == Id_producto) {
                    detalle.setCantidad((detalle.getCantidad()+1));
                    detalle.setTotal(Integer.valueOf(producto.getPrecio_producto()) * detalle.getCantidad());
                    ordenesNueva.add(detalle);
                } else if (detalle.getId_producto().getId_producto() != Id_producto){
                    ordenesNueva.add(detalle);
                }
            }
            detalles = ordenesNueva;
        }
        
        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "carrito";
    }

    @GetMapping("/delete/carrito/{id}")
    public String borrarProductoCarrito(@PathVariable Long id, Model model) {
        //Lista nueva de productos
        List<DetalleOrden> ordenesNueva = new ArrayList<>();

        for (DetalleOrden detalleOrden : detalles) {
            if (detalleOrden.getId_producto().getId_producto() != id) {
                ordenesNueva.add(detalleOrden);

            }
        }

        //Poner la nueva lista con los productos restantes
        detalles = ordenesNueva;

        double sumaTotal = 0;

        sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "redirect:/getCarrito";
    }

    @GetMapping("/getCarrito")
    public String getCarrito(Model model) {
        //Recordar que son métodos globales
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "carrito";
    }

    @GetMapping("/orden")
    public String orden(Model model) {

        //Se trae después según la sesión
        //Usuario usuario = usuarioService.findById(Long.valueOf(1)).get();
        
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);
        //model.addAttribute("usuario", usuario);

        return "resumenOrden";
    }

    //Guardar la orden
    @GetMapping("/saveOrden")
    public String saveOrden() {
        Date fechaCreacion = new Date();
        orden.setFechaCreacion(fechaCreacion);
        orden.setNumero(ordenService.generarNumeroOrden());

        //usuario
        /*Usuario usuario = usuarioService.findById(Long.valueOf(1)).get();
        
        //Guardar orden
        orden.setUsuario(usuario);*/
        ordenService.save(orden);

        //Guardar detalles
        for (DetalleOrden dt : detalles) {
            dt.setOrden(orden);
            detalleOrdenService.save(dt);
        }

        //Limpiar orden y detalles
        orden = new Orden();
        detalles.clear();

        return "redirect:/menu";
    }

}
