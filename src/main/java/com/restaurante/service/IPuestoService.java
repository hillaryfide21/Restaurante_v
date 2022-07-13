/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.restaurante.service;

import java.util.List;
import com.restaurante.entity.Puesto;
/**
 *
 * @author Hillary
 */
public interface IPuestoService {
    public List<Puesto> getAllPuesto();
    public Puesto getPuestoById (long id);
    public void savePuesto (Puesto puesto);
    public void delete (long id);
}



    