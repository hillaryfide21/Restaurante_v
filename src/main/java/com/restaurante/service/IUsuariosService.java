/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.restaurante.service;

import com.restaurante.entity.Usuarios;
import java.util.List;

/**
 *
 * @author Sky
 */
public interface IUsuariosService {
    public List<Usuarios> getAllUsuarios();
    public Usuarios getUsuarioByid_usuario(long id_usuario);
    public void saveUsuario (Usuarios usuario);
    public void delete (long id_usuario);
    
}
