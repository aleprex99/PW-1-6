package alexpre.flexikm.servlet.service;

import java.util.List;

import org.springframework.stereotype.Service;


import alexpre.flexikm.servlet.model.AssocUtilizzoGaranzia;


@Service
public interface AssocUtilizzoGaranziaService {
	public AssocUtilizzoGaranzia insert(AssocUtilizzoGaranzia assoc);

    public List<AssocUtilizzoGaranzia> getAssocUtilizziGaranzie();

    public AssocUtilizzoGaranzia update(AssocUtilizzoGaranzia assoc);

     public String deleteAssocUtilizzoGaranziaById(Long id);


    public List<AssocUtilizzoGaranzia> getAssocUtilizzoGaranziaById(Long id);
    
    public List<AssocUtilizzoGaranzia> getAssocUtilizzoGaranzieByIdUtilMensile(Long id);

}
