package webtech.foodspotsapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import webtech.foodspotsapp.Entities.Foodspot;
import webtech.foodspotsapp.Repositories.FoodspotRepository;

@RestController
public class FoodspotsController {
  @Autowired FoodspotRepository foodspotRepository;

  @GetMapping(value = "/foodspots", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Foodspot> foodspots() {
    return foodspotRepository.findAll();
  }

  @PostMapping(value = "/foodspots", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public Foodspot createFoodspot(@RequestBody Foodspot foodspot) {
    return foodspotRepository.save(foodspot);
  }
}

