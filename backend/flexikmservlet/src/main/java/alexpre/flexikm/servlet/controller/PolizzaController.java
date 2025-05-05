package alexpre.flexikm.servlet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alexpre.flexikm.servlet.model.Polizza;
import alexpre.flexikm.servlet.service.PolizzaService;

@RestController
@RequestMapping("/Polizza")
public class PolizzaController
{
  @Autowired
  PolizzaService polizzaService;

  @PostMapping("/insPolizza")
  public Polizza insertPolizza(@RequestBody Polizza polizza) {
    return polizzaService.insert(polizza);
  }

  @PostMapping("/getPolizze")
  public List<Polizza> getPolizze() {
    return polizzaService.getPolizze();
  }

  @PostMapping("/updPolizza")
  public Polizza updatePolizza(@RequestBody Polizza polizza) {
    return polizzaService.update(polizza);
  }

  @PostMapping("/getPolizzaById/{id}")
  public List<Polizza> getPolizzaById(@PathVariable long id) {
    return polizzaService.getPolizzaById(id);
  }

  @PostMapping("/getPolizzaByClienteId/{id}")
  public List<Polizza> getPolizzeByIdCliente(@PathVariable long id) {
    return polizzaService.getPolizzeByClienteId(id);
  }

  @PostMapping("/deletePolizzaById/{id}")
  public String deletePolizzaById(@PathVariable Long id) {
    return polizzaService.deletePolizzaById(id);
  }

}
