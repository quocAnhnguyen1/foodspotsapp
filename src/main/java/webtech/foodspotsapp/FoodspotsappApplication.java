package webtech.foodspotsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "webtech.foodspotsapp")
@EnableJpaRepositories("webtech.foodspotsapp.Repositories")
public class FoodspotsappApplication {

  public static void main(String[] args) {
    SpringApplication.run(FoodspotsappApplication.class, args);
  }
}
