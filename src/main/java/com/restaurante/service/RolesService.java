/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.service;

import com.restaurante.entity.Roles;
import com.restaurante.repository.RolesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sky
 */
@Service
public class RolesService implements IRolesService{

    @Autowired
    private RolesRepository rolesRepository;
    @Override
    public List<Roles> listRol() {
       return (List<Roles>)rolesRepository.findAll();
    }
    
}
