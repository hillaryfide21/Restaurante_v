package com.restaurante.repository;

import com.restaurante.entity.Categorias;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriasRepository extends CrudRepository<Categorias, Long>{
    
}
