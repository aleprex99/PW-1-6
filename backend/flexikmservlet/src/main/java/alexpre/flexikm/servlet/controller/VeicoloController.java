package alexpre.flexikm.servlet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alexpre.flexikm.servlet.model.Veicolo;
import alexpre.flexikm.servlet.service.VeicoloService;

@RestController
@RequestMapping("/Veicolo")
public class VeicoloController
{
  @Autowired
  VeicoloService veicoloService;

  @PostMapping("/insVeicolo")
  public Veicolo insertVeicolo(@RequestBody Veicolo veicolo) {
    return veicoloService.insert(veicolo);
  }

  @PostMapping("/getVeicoli")
  public List<Veicolo> getVeicoli() {
    return veicoloService.getVeicoli();
  }

  @PostMapping("/updVeicolo")
  public Veicolo updateVeicolo(@RequestBody Veicolo veicolo) {
    return veicoloService.update(veicolo);
  }

  @PostMapping("/getVeicoloById/{id}")
  public List<Veicolo> getVeicoloById(@PathVariable long id) {
    return veicoloService.getVeicoloById(id);
  }

  @PostMapping("/deleteVeicoloById/{id}")
  public String deleteVeicoloById(@PathVariable Long id) {
    return veicoloService.deleteVeicoloById(id);
  }

}
