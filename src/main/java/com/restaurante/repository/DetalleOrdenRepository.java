package com.restaurante.repository;

import com.restaurante.entity.DetalleOrden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepository extends CrudRepository<DetalleOrden, Long>{
    
}
