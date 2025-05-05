package alexpre.flexikm.servlet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alexpre.flexikm.servlet.model.Sinistro;
import alexpre.flexikm.servlet.service.SinistroService;

@RestController
@RequestMapping("/Sinistro")
public class SinistroController
{
  @Autowired
  SinistroService sinistroService;

  @PostMapping("/insSinistro")
  public Sinistro insertSinistro(@RequestBody Sinistro sinistro) {
    return sinistroService.insert(sinistro);
  }

  @PostMapping("/getSinistri")
  public List<Sinistro> getSinistri() {
    return sinistroService.getSinistri();
  }

  @PostMapping("/updSinistro")
  public Sinistro updateSinistro(@RequestBody Sinistro sinistro) {
    return sinistroService.update(sinistro);
  }

  @PostMapping("/getSinistroById/{id}")
  public List<Sinistro> getSinistroById(@PathVariable long id) {
    return sinistroService.getSinistroById(id);
  }

  @PostMapping("/getSinistriByIdPolizza/{id}")
  public List<Sinistro> getSinistriByIdPolizza(@PathVariable long id) {
    return sinistroService.getSinistriByIdPolizza(id);
  }

  @PostMapping("/deleteSinistroById/{id}")
  public String deleteSinistroById(@PathVariable Long id) {
    return sinistroService.deleteSinistroById(id);
  }

}
