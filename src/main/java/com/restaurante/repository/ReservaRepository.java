/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.repository;

import com.restaurante.entity.Reservas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marvin Camacho
 */
@Repository
public interface ReservaRepository  extends CrudRepository <Reservas,Long>  {
    
}
