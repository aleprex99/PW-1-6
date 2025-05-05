package alexpre.flexikm.servlet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import alexpre.flexikm.servlet.model.Veicolo;

public interface VeicoloRepository extends JpaRepository<Veicolo, Long>
{
  String deleteVeicoloById(Long id);

  @Query("SELECT c FROM Veicolo c WHERE c.id = :id")
  List<Veicolo> getVeicoloById(Long id);

}
