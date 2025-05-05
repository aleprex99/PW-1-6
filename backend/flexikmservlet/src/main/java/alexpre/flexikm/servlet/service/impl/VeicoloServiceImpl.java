package alexpre.flexikm.servlet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.Veicolo;
import alexpre.flexikm.servlet.repository.VeicoloRepository;
import alexpre.flexikm.servlet.service.VeicoloService;

@Service
public class VeicoloServiceImpl implements VeicoloService
{
  @Autowired
  VeicoloRepository veicoloRepository;

  @Override
  public Veicolo insert(Veicolo veicolo) {
    return veicoloRepository.save(veicolo);
  }

  @Override
  public List<Veicolo> getVeicoli() {
    return veicoloRepository.findAll();
  }

  @Override
  public Veicolo update(Veicolo veicolo) {
    return veicoloRepository.save(veicolo);
  }

  @Override
  public String deleteVeicoloById(Long id) {
    veicoloRepository.deleteById(id);

    return "Veicolo Cancellato !";
  }

  @Override
  public List<Veicolo> getVeicoloById(Long id) {
    return veicoloRepository.getVeicoloById(id);
  }

}
