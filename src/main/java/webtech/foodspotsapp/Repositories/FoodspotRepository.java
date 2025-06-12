package webtech.foodspotsapp.Repositories;

import org.springframework.data.repository.CrudRepository;
import webtech.foodspotsapp.Entities.Foodspot;

public interface FoodspotRepository extends CrudRepository<Foodspot, Long> {}
