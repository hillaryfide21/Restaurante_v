/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.service;

import com.restaurante.entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sky
 */
@Service
public class UserService implements UserDetailsService{

    
    
    @Autowired
     public IUsuariosService usuariosService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        /* Login solucionar el find*/
        Usuarios usuarios=this.usuariosService.findbyCorreo(username);
        Userprincipal userPrincipal = new Userprincipal(usuarios);
               return userPrincipal;          
    }
}