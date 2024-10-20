package id.co.mii.clientapp.controllers;

import id.co.mii.clientapp.models.Region;
import id.co.mii.clientapp.services.RegionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/region")
public class RegionController {

  private RegionService regionService;

  @GetMapping
  public String getAll(Model model) {
    model.addAttribute("regions", regionService.getAll());
    model.addAttribute("isActive", "region");
    return "region/index";
  }

  @GetMapping("/{id}")
  public String getById(@PathVariable Integer id, Model model) {
    model.addAttribute("isActive", "region");
    model.addAttribute("region", regionService.getById(id));
    return "region/detail";
  }

  @GetMapping("/create")
  public String create(Region region, Model model) {
    model.addAttribute("isActive", "region");
    return "region/create-form";
  }

  @PostMapping
  public String created(Region region) {
    regionService.create(region);
    return "redirect:/region";
  }

  @GetMapping("/update/{id}")
  public String update(Model model, @PathVariable Integer id, Region region) {
    model.addAttribute("region", regionService.getById(id));
    model.addAttribute("isActive", "region");
    return "region/update-form";
  }

  @PutMapping("/{id}")
  public String updated(@PathVariable Integer id, Region region) {
    regionService.update(id, region);
    return "redirect:/region";
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable Integer id) {
    regionService.delete(id);
    return "redirect:/region";
  }
}
