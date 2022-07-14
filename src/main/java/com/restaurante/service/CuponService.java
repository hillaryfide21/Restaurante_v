/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.service;

import com.restaurante.entity.Cupon;
import com.restaurante.repository.CuponRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author Hillary
 */

@Service
public class CuponService implements ICuponService{

    @Autowired
    private CuponRepository cuponRepository;
        
    @Override
    public List<Cupon> getAllCupon() {
        return (List<Cupon>)cuponRepository.findAll();
    }

    @Override
    public Cupon getCuponById(long id) {
        return cuponRepository.findById(id).orElse(null);
        
    }

    @Override
    public void saveCupon(Cupon cupon) {
        cuponRepository.save(cupon);
    }

    @Override
    public void delete(long id) {
        cuponRepository.deleteById(id);
    }
    
}







