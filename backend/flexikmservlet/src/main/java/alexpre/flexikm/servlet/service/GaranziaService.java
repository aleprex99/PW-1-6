package alexpre.flexikm.servlet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.Garanzia;

@Service
public interface GaranziaService
{

  public Garanzia insert(Garanzia garanzia);

  public List<Garanzia> getGaranzie();

  public Garanzia update(Garanzia garanzia);

  public String deleteGaranziaById(Long id);

  public List<Garanzia> getGaranziaById(Long id);

}
