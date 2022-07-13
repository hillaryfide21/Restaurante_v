/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.service;
import com.restaurante.entity.Contacto;
import com.restaurante.repository.ContactoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author XPC
 */
@Service
public class ContactoService implements IContactoService{
    @Autowired
    private ContactoRepository contactoRepository;
    
    @Override
    public List<Contacto> getAllContacto(){
        return (List<Contacto>)contactoRepository.findAll();
    }

    @Override
    public void saveContacto(Contacto puesto) {
        contactoRepository.save(puesto);
    }

    @Override
    public void delete(long id) {
        contactoRepository.deleteById(id);
    }

    @Override
    public Contacto getContactoById(long id) {
        return contactoRepository.findById(id).orElse(null);
    }
}
