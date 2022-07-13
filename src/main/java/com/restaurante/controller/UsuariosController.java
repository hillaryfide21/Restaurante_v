/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.controller;

import com.restaurante.entity.Roles;
import com.restaurante.entity.Usuarios;
import com.restaurante.service.IRolesService;
import com.restaurante.service.IUsuariosService;
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
 * @author Sky
 */
@Controller
public class UsuariosController {
    @Autowired
    private IUsuariosService usuariosService;
    
    @Autowired
private IRolesService rolesService;  
    
    @GetMapping("/usuarios")
    public String index(Model model){
    List <Usuarios> listUsuarios = usuariosService.getAllUsuarios();
      model.addAttribute("titulo", "Tabla de Usuarios");
      model.addAttribute("usuarios", listUsuarios);
      return "usuarios";     
    }
    
   
  @GetMapping("/usuariosN")
  
    public String CrearUsuario(Model model) {
        List<Roles> ListRol = rolesService.listRol();
        model.addAttribute("usuarios",new Usuarios());
        model.addAttribute("rol", ListRol);
        return "Crear";
    } 
    
     @PostMapping("/saveUsuario")
    public String GuardarUsuario (@ModelAttribute Usuarios usuarios ){
        usuariosService.saveUsuario(usuarios);
        return "redirect:/usuarios";
    }
    
        @GetMapping("/editUsuario/{id}")
    public String editarPersona(@PathVariable("id")long id_usuario,Model model){
    Usuarios usuarios=usuariosService.getUsuarioByid_usuario(id_usuario);
    List<Roles> listRol=rolesService.listRol();
    model.addAttribute("usuarios",usuarios);
    model.addAttribute("roles",listRol);
    return "Crear";
            }
    
      @GetMapping("/deleteusuario/{id}")
    public String eliminarUsuario(@PathVariable("id")long id_usuario){
    usuariosService.delete(id_usuario);
    return "redirect:/usuario";

}

}