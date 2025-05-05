package alexpre.flexikm.servlet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.Garanzia;
import alexpre.flexikm.servlet.repository.GaranziaRepository;
import alexpre.flexikm.servlet.service.GaranziaService;

@Service
public class GaranziaServiceImpl implements GaranziaService
{
  @Autowired
  GaranziaRepository garanziaRepository;

  @Override
  public Garanzia insert(Garanzia garanzia) {
    return garanziaRepository.save(garanzia);
  }

  @Override
  public List<Garanzia> getGaranzie() {
    return garanziaRepository.findAll();
  }

  @Override
  public Garanzia update(Garanzia garanzia) {
    return garanziaRepository.save(garanzia);
  }

  @Override
  public String deleteGaranziaById(Long id) {
    garanziaRepository.deleteById(id);

    return "Garanzia Cancellata !";
  }

  @Override
  public List<Garanzia> getGaranziaById(Long id) {
    return garanziaRepository.getGaranziaById(id);
  }

}
