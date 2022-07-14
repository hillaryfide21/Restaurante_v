package com.restaurante.repository;

import com.restaurante.entity.Restaurantes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantesRepository extends CrudRepository<Restaurantes, Long>{
    
}
