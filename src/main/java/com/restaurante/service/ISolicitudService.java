/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.restaurante.service;

import com.restaurante.entity.Solicitud;
import java.util.List;

/**
 *
 * @author Hillary
 */
public interface ISolicitudService {
    public List<Solicitud> getAllSolicitud();
    public Solicitud getSolicitudById (long id);
    public void saveSolicitud (Solicitud solicitud);
    public void delete (long id); 
}
