package com.restaurante.service;

import com.restaurante.entity.Orden;
import java.util.List;

public interface IOrdenService {
    List<Orden> findAll();
    Orden save(Orden orden);
    String generarNumeroOrden();
}
