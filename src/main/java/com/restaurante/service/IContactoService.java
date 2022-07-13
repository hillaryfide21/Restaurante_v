/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.service;

import com.restaurante.entity.Contacto;

import java.util.List;

/**
 *
 * @author XPC
 */
public interface IContactoService {
    public List<Contacto> getAllContacto();
    public Contacto getContactoById (long id);
    public void saveContacto (Contacto puesto);
    public void delete (long id);
}
