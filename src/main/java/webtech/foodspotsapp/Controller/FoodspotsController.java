package webtech.foodspotsapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import webtech.foodspotsapp.Entities.Foodspot;
import webtech.foodspotsapp.Repositories.FoodspotRepository;

@RestController
public class FoodspotsController {
  @Autowired
  FoodspotRepository foodspotRepository;

  @GetMapping(value = "/foodspots", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Foodspot> foodspots() {
    return foodspotRepository.findAll();
  }
}
