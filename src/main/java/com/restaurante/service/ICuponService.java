/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.restaurante.service;

import java.util.List;
import com.restaurante.entity.Cupon;
/**
 *
 * @author Hillary
 */
public interface ICuponService {
    public List<Cupon> getAllCupon();
    public Cupon getCuponById (long id);
    public void saveCupon (Cupon cupon);
    public void delete (long id); 
}


