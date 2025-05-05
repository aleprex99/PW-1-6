package alexpre.flexikm.servlet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.Sinistro;
import alexpre.flexikm.servlet.repository.SinistroRepository;
import alexpre.flexikm.servlet.service.SinistroService;

@Service
public class SinistroServiceImpl implements SinistroService
{
  @Autowired
  SinistroRepository sinistroRepository;

  @Override
  public Sinistro insert(Sinistro sinistro) {
    return sinistroRepository.save(sinistro);
  }

  @Override
  public List<Sinistro> getSinistri() {
    return sinistroRepository.findAll();
  }

  @Override
  public Sinistro update(Sinistro sinistro) {
    return sinistroRepository.save(sinistro);
  }

  @Override
  public String deleteSinistroById(Long id) {
    sinistroRepository.deleteById(id);

    return "Sinistro Cancellata !";
  }

  @Override
  public List<Sinistro> getSinistroById(Long id) {
    return sinistroRepository.getSinistroById(id);
  }

  @Override
  public List<Sinistro> getSinistriByIdPolizza(Long id) {
    return sinistroRepository.getSinistriByIdPolizza(id);
  }

}
