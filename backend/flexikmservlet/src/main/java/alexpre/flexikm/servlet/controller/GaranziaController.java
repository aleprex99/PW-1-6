package alexpre.flexikm.servlet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alexpre.flexikm.servlet.model.Garanzia;
import alexpre.flexikm.servlet.service.GaranziaService;

@RestController
@RequestMapping("/Garanzia")
public class GaranziaController
{
  @Autowired
  GaranziaService garanziaService;

  @PostMapping("/insGaranzia")
  public Garanzia insertGaranzia(@RequestBody Garanzia garanzia) {
    return garanziaService.insert(garanzia);
  }

  @PostMapping("/getGaranzie")
  public List<Garanzia> getGaranzie() {
    return garanziaService.getGaranzie();
  }

  @PostMapping("/updGaranzia")
  public Garanzia updateGaranzia(@RequestBody Garanzia garanzia) {
    return garanziaService.update(garanzia);
  }

  @PostMapping("/getGaranziaById/{id}")
  public List<Garanzia> getGaranziaById(@PathVariable long id) {
    return garanziaService.getGaranziaById(id);
  }

  @PostMapping("/deleteGaranziaById/{id}")
  public String deleteGaranziaById(@PathVariable Long id) {
    return garanziaService.deleteGaranziaById(id);
  }

}
