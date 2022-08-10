package com.restaurante.service;

import com.restaurante.entity.Restaurantes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.restaurante.repository.RestaurantesRepository;

@Service
public class RestaurantesService implements IRestaurantesService{
    
    @Autowired
    private RestaurantesRepository restaurantesRepository;
    
    @Override
    public List<Restaurantes> getAllData() {
        return(List<Restaurantes>) restaurantesRepository.findAll();
    }

    @Override
    public Restaurantes getDataById(long id_restaurante) {
        return restaurantesRepository.findById(id_restaurante).orElse(null);
    }

    @Override
    public void saveInformacion(Restaurantes registro) {
        restaurantesRepository.save(registro);
    }

    @Override
    public void delete(long id_restaurante) {
        restaurantesRepository.deleteById(id_restaurante);
    }
    @Override
    public long maxReservaHorario(){
        return restaurantesRepository.count();
    }
}
