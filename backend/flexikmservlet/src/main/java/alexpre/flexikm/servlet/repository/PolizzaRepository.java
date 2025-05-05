package alexpre.flexikm.servlet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import alexpre.flexikm.servlet.model.Polizza;

public interface PolizzaRepository extends JpaRepository<Polizza, Long>
{
  String deletePolizzaById(Long id);

  @Query("SELECT c FROM Polizza c WHERE c.id = :id")
  List<Polizza> getPolizzaById(Long id);

  @Query("SELECT c FROM Polizza c WHERE c.clienteId = :id")
  List<Polizza> getPolizzaByClienteId(Long id);
}
