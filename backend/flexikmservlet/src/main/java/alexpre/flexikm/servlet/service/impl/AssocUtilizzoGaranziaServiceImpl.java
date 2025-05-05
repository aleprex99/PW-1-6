package alexpre.flexikm.servlet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.AssocUtilizzoGaranzia;
import alexpre.flexikm.servlet.model.Cliente;
import alexpre.flexikm.servlet.repository.AssocUtilizzoGaranziaRepository;
import alexpre.flexikm.servlet.repository.ClienteRepository;

import alexpre.flexikm.servlet.service.AssocUtilizzoGaranziaService;

@Service
public class AssocUtilizzoGaranziaServiceImpl implements AssocUtilizzoGaranziaService {
	
	 @Autowired
	 AssocUtilizzoGaranziaRepository assocRepository;

	  @Override
	  public AssocUtilizzoGaranzia insert(AssocUtilizzoGaranzia assoc) {
	    return assocRepository.save(assoc);
	  }

	  @Override
	  public List<AssocUtilizzoGaranzia> getAssocUtilizziGaranzie() {
	    return assocRepository.findAll();
	  }

	  @Override
	  public AssocUtilizzoGaranzia update(AssocUtilizzoGaranzia assoc) {
	    return assocRepository.save(assoc);
	  }

	  @Override
	  public String deleteAssocUtilizzoGaranziaById(Long id) {
		  assocRepository.deleteById(id);

	    return "Associazione Utilizzo mensile garanzia Cancellata !";
	  }

	  @Override
	  public List<AssocUtilizzoGaranzia> getAssocUtilizzoGaranzieByIdUtilMensile(Long id) {
	    return assocRepository.getAssocUtilizzoGaranzieByIdUtilMensile(id);
	  }
	  
	  @Override
	  public List<AssocUtilizzoGaranzia> getAssocUtilizzoGaranziaById(Long id) {
		  return assocRepository.getAssocUtilizzoGaranziaById(id);  
	  }
	  

}
