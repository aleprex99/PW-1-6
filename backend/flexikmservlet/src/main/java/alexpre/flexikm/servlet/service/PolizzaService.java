package alexpre.flexikm.servlet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.Polizza;

@Service
public interface PolizzaService
{
  public Polizza insert(Polizza polizza);

  public List<Polizza> getPolizze();

  public Polizza update(Polizza polizza);

  public String deletePolizzaById(Long id);

  public List<Polizza> getPolizzaById(Long id);

  public List<Polizza> getPolizzeByClienteId(Long id);
}
