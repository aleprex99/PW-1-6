package alexpre.flexikm.servlet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alexpre.flexikm.servlet.model.UtilizzoMensile;
import alexpre.flexikm.servlet.service.UtilizzoMensileService;

@RestController
@RequestMapping("/UtilMens")
public class UtilizzoMensileController
{
  @Autowired
  UtilizzoMensileService utilizzoMensileService;

  @PostMapping("/insUtilMens")
  public UtilizzoMensile insertUtilMens(@RequestBody UtilizzoMensile utilMens) {
    return utilizzoMensileService.insert(utilMens);
  }

  @PostMapping("/getUtilMens")
  public List<UtilizzoMensile> getUtilMens() {
    return utilizzoMensileService.getUtilizziMensile();
  }

  @PostMapping("/updUtilMens")
  public UtilizzoMensile updateUtilMens(@RequestBody UtilizzoMensile utilMens) {
    return utilizzoMensileService.update(utilMens);
  }

  @PostMapping("/getUtilMensById/{id}")
  public List<UtilizzoMensile> getUtilMensById(@PathVariable long id) {
    return utilizzoMensileService.getUtilizzoMensileById(id);
  }

  @PostMapping("/deleteUtilMensById/{id}")
  public String deleteUtilMensById(@PathVariable Long id) {
    return utilizzoMensileService.deleteUtilizzoMensileById(id);
  }

}
