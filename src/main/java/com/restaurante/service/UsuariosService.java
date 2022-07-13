/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.service;

import com.restaurante.entity.Usuarios;
import com.restaurante.repository.UsuariosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sky
 */
@Service
public class UsuariosService implements IUsuariosService{

    @Autowired

    private UsuariosRepository usuariosRepository;
    @Override
    public List<Usuarios> getAllUsuarios() {
       return (List<Usuarios>)usuariosRepository.findAll();
    }

    @Override
    public Usuarios getUsuarioByid_usuario(long id_usuario) {
       return usuariosRepository.findById(id_usuario).orElse(null);
    }

    @Override
    public void saveUsuario(Usuarios usuario) {
         usuariosRepository.save(usuario);
    }

    @Override
    public void delete(long id_usuario) {
        usuariosRepository.deleteById(id_usuario);
    }
    
    
}
