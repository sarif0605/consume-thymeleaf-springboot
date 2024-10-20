package id.co.mii.clientapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// @RestController // JSON
@Controller // view -> html
public class HomeController {

  @GetMapping
  public String home(Model model) {
    model.addAttribute("name", "SIBKM");
    return "index";
  }
}
