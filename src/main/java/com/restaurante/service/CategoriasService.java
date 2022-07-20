package com.restaurante.service;

import com.restaurante.entity.Categorias;
import com.restaurante.repository.CategoriasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriasService implements ICategoriasService{
    
    @Autowired
    private CategoriasRepository categoriasRepository;

    @Override
    public List<Categorias> listaCategorias() {
        return (List<Categorias>)categoriasRepository.findAll();
    }


}
