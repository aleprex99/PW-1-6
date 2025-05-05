package alexpre.flexikm.servlet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.Veicolo;

@Service
public interface VeicoloService
{
  public Veicolo insert(Veicolo veicolo);

  public List<Veicolo> getVeicoli();

  public Veicolo update(Veicolo garanzia);

  public String deleteVeicoloById(Long id);

  public List<Veicolo> getVeicoloById(Long id);

}
