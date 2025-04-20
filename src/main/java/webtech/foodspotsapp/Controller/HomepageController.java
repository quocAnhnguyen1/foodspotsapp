package webtech.foodspotsapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomepageController {
  @GetMapping(path = "/")
  public ModelAndView showHomepage() {
    return new ModelAndView("homepage");
  }
}
