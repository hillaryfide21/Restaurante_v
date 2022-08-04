package com.restaurante.service;

import com.restaurante.entity.Orden;
import com.restaurante.repository.OrdenRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenService implements IOrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

    @Override
    public List<Orden> findAll() {
        return (List<Orden>) ordenRepository.findAll();
    }

    @Override
    public String generarNumeroOrden() {
        int numero = 0;
        String numeroConcatenado = "";

        List<Orden> ordenes = findAll();

        List<Integer> numeros = new ArrayList<>();

        //El stream crea un flujo, el forEach es otra forma de for
        //Se añade a la lista de enteros los números de orden pero como enteros para hacer el incremento
        ordenes.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumero())));

        if (ordenes.isEmpty()) {
            numero = 1;
        } else { //Si no es una lista vacía, se obtiene el mayor número de la lista y se le suma uno
            numero = numeros.stream().max(Integer::compare).get();
            numero++;
        }

        if (numero < 10) { //0000000001
            numeroConcatenado = "000000000" + String.valueOf(numero);
        } else if (numero < 100) {
            numeroConcatenado = "00000000" + String.valueOf(numero);
        } else if (numero < 1000) {
            numeroConcatenado = "0000000" + String.valueOf(numero);
        } else if (numero < 10000) {
            numeroConcatenado = "000000" + String.valueOf(numero);
        }

        return numeroConcatenado;
    }

}
