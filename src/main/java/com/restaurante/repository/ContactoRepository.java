/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.repository;

import com.restaurante.entity.Contacto;
import com.restaurante.entity.Puesto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author XPC
 */
@Repository
public interface ContactoRepository extends CrudRepository<Contacto,Long>{
    
}
