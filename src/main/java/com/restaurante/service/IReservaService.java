/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.service;

import com.restaurante.entity.Reservas;
import java.util.List;

/**
 *
 * @author Marvin Camacho
 */
public interface IReservaService {
    public List<Reservas> getAllReservas();
    public Reservas getReservaByid_usuario(long id_reserva);
    public void saveReserva (Reservas usuario);
    public void delete (long id_usuario); 
}
