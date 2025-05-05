package alexpre.flexikm.servlet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.Polizza;
import alexpre.flexikm.servlet.repository.PolizzaRepository;
import alexpre.flexikm.servlet.service.PolizzaService;

@Service
public class PolizzaServiceImpl implements PolizzaService
{
  @Autowired
  PolizzaRepository polizzaRepository;

  @Override
  public Polizza insert(Polizza polizza) {
    return polizzaRepository.save(polizza);
  }

  @Override
  public List<Polizza> getPolizze() {
    return polizzaRepository.findAll();
  }

  @Override
  public Polizza update(Polizza polizza) {
    return polizzaRepository.save(polizza);
  }

  @Override
  public String deletePolizzaById(Long id) {
    polizzaRepository.deleteById(id);

    return "Polizza Cancellata !";
  }

  @Override
  public List<Polizza> getPolizzaById(Long id) {
    return polizzaRepository.getPolizzaById(id);
  }

  @Override
  public List<Polizza> getPolizzeByClienteId(Long id) {
    return polizzaRepository.getPolizzaByClienteId(id);
  }

}
