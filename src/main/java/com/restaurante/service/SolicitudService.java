/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.restaurante.service;

import com.restaurante.entity.Solicitud;
import com.restaurante.repository.SolicitudRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hillary
 */
@Service
public class SolicitudService implements ISolicitudService {

    @Autowired
    private SolicitudRepository solicitudRepository;

    @Override
    public List<Solicitud> getAllSolicitud() {
        return (List<Solicitud>) solicitudRepository.findAll();
    }

    @Override
    public Solicitud getSolicitudById(long id) {
        return solicitudRepository.findById(id).orElse(null);
    }

    @Override
    public void saveSolicitud(Solicitud solicitud) {
        solicitudRepository.save(solicitud);
    }

    @Override
    public void delete(long id) {
        solicitudRepository.deleteById(id);

    }

}
