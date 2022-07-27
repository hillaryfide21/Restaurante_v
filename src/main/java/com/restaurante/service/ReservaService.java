/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.service;

import com.restaurante.entity.Reservas;
import com.restaurante.repository.ReservaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Marvin Camacho
 */
@Service
public class ReservaService implements IReservaService{
    
    @Autowired
    private ReservaRepository reservaRepository;
    
    @Override
    public List<Reservas> getAllReservas() {
       return (List<Reservas>)reservaRepository.findAll();
    }

    @Override
    public Reservas getReservaByid_usuario(long id_reserva) {
       return reservaRepository.findById(id_reserva).orElse(null);
    }

    @Override
    public void saveReserva(Reservas usuario) {
         reservaRepository.save(usuario);
    }

    @Override
    public void delete(long id_reserva) {
        reservaRepository.deleteById(id_reserva);
    }
}