package alexpre.flexikm.servlet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.UtilizzoMensile;
import alexpre.flexikm.servlet.repository.UtilizzoMensileRepository;
import alexpre.flexikm.servlet.service.UtilizzoMensileService;

@Service
public class UtilizzoMensileServiceImpl implements UtilizzoMensileService
{
  @Autowired
  UtilizzoMensileRepository utilizzoMensileRepository;

  @Override
  public UtilizzoMensile insert(UtilizzoMensile garanzia) {
    return utilizzoMensileRepository.save(garanzia);
  }

  @Override
  public List<UtilizzoMensile> getUtilizziMensile() {
    return utilizzoMensileRepository.findAll();
  }

  @Override
  public UtilizzoMensile update(UtilizzoMensile garanzia) {
    return utilizzoMensileRepository.save(garanzia);
  }

  @Override
  public String deleteUtilizzoMensileById(Long id) {
    utilizzoMensileRepository.deleteById(id);

    return "Utilizzo Mensile Cancellato !";
  }

  @Override
  public List<UtilizzoMensile> getUtilizzoMensileById(Long id) {
    return utilizzoMensileRepository.getUtilizzoMensileById(id);
  }

}
