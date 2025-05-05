package alexpre.flexikm.servlet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alexpre.flexikm.servlet.model.AssocUtilizzoGaranzia;
import alexpre.flexikm.servlet.model.Cliente;
import alexpre.flexikm.servlet.service.AssocUtilizzoGaranziaService;
import alexpre.flexikm.servlet.service.ClienteService;

@RestController
@RequestMapping("/AssocUtilGaranzia")
public class AssocUtilizzoGaranziaController {
	@Autowired
	AssocUtilizzoGaranziaService assocUtilService;
	
	  @PostMapping("/insAssocUtilizzoGaranzia")
	  public AssocUtilizzoGaranzia insertCliente(@RequestBody AssocUtilizzoGaranzia utilizzo) {
	    return assocUtilService.insert(utilizzo);
	  }
	
	  @PostMapping("/getAssocUtilizziGaranzia")
	  public List<AssocUtilizzoGaranzia> getAssocUtilizziGaranzie() {
	    return assocUtilService.getAssocUtilizziGaranzie();
	  }
	
	  @PostMapping("/updAssocUtilizzoGaranzia")
	  public AssocUtilizzoGaranzia updateAssocUtilizzoGaranzia(@RequestBody AssocUtilizzoGaranzia utilizzo) {
	    return assocUtilService.update(utilizzo);
	  }
	
	  
	  @PostMapping("/getAssocUtilizzoGaranziaById/{id}")
	  public List<AssocUtilizzoGaranzia> getAssocUtilizzoGaranziaById(@PathVariable long id) {
	    return assocUtilService.getAssocUtilizzoGaranziaById(id);
	  }
	  
	  @PostMapping("/getAssocUtilizzoGaranziaByIdUtilMensile/{id}")
	  public List<AssocUtilizzoGaranzia> getAssocUtilizzoGaranzieByIdUtilMensile(@PathVariable long id) {
	    return assocUtilService.getAssocUtilizzoGaranzieByIdUtilMensile(id);
	  }
	
	  @PostMapping("/deleteAssocUtilizzoGaranziaById/{id}")
	  public String deleteAssocUtilizzoGaranziaById(@PathVariable Long id) {
	    return assocUtilService.deleteAssocUtilizzoGaranziaById(id);
	  }

}
