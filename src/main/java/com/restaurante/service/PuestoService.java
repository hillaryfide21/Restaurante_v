/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.service;

import com.restaurante.entity.Puesto;
import com.restaurante.repository.PuestoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Hillary
 */
@Service
public class PuestoService implements IPuestoService{
    @Autowired
    private PuestoRepository puestoRepository;
    
    @Override
    public List<Puesto> getAllPuesto(){
        return (List<Puesto>)puestoRepository.findAll();
    }

    @Override
    public void savePuesto(Puesto puesto) {
        puestoRepository.save(puesto);
    }

    @Override
    public void delete(long id) {
        puestoRepository.deleteById(id);
    }

    @Override
    public Puesto getPuestoById(long id) {
        return puestoRepository.findById(id).orElse(null);
    }
}





