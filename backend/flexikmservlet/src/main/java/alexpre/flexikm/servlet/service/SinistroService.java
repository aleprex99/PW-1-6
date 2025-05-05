package alexpre.flexikm.servlet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.Sinistro;

@Service
public interface SinistroService
{
  public Sinistro insert(Sinistro sinistro);

  public List<Sinistro> getSinistri();

  public Sinistro update(Sinistro sinistro);

  public String deleteSinistroById(Long id);

  public List<Sinistro> getSinistroById(Long id);

  public List<Sinistro> getSinistriByIdPolizza(Long id);
}
