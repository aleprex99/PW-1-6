package alexpre.flexikm.servlet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.UtilizzoMensile;

@Service
public interface UtilizzoMensileService
{
  public UtilizzoMensile insert(UtilizzoMensile utilMens);

  public List<UtilizzoMensile> getUtilizziMensile();

  public UtilizzoMensile update(UtilizzoMensile utilMens);

  public String deleteUtilizzoMensileById(Long id);

  public List<UtilizzoMensile> getUtilizzoMensileById(Long id);
}
