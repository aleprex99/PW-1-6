package alexpre.flexikm.servlet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import alexpre.flexikm.servlet.model.Sinistro;

public interface SinistroRepository extends JpaRepository<Sinistro, Long>
{

  String deleteSinistroById(Long id);

  @Query("SELECT c FROM Sinistro c WHERE c.id = :id")
  List<Sinistro> getSinistroById(Long id);

  @Query("SELECT c FROM Sinistro c WHERE c.idPolizza = :id")
  List<Sinistro> getSinistriByIdPolizza(Long id);
}
