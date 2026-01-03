package webtech.foodspotsapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import webtech.foodspotsapp.Entities.Foodspot;
import webtech.foodspotsapp.Repositories.FoodspotRepository;

@RestController
public class FoodspotsController {
  @Autowired FoodspotRepository foodspotRepository;

  @GetMapping(value = "/foodspots", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Foodspot> foodspots() {
    return foodspotRepository.findAll();
  }

  @PostMapping
  public Foodspot create(@RequestBody Foodspot foodspot) {
    foodspot.setId(null);
    return foodspotRepository.save(foodspot);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    foodspotRepository.deleteById(id);
  }

  @PutMapping("/{id}")
  public Foodspot update(@PathVariable Long id, @RequestBody Foodspot updated) {
    return foodspotRepository
        .findById(id)
        .map(
            existing -> {
              existing.setName(updated.getName());
              return foodspotRepository.save(existing);
            })
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }
}
