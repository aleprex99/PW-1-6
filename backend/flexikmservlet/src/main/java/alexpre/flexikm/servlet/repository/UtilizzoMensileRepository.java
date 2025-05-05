package alexpre.flexikm.servlet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import alexpre.flexikm.servlet.model.UtilizzoMensile;

public interface UtilizzoMensileRepository extends JpaRepository<UtilizzoMensile, Long>
{
  String deleteUtilizzoMensileById(Long id);

  @Query("SELECT c FROM UtilizzoMensile c WHERE c.id = :id")
  List<UtilizzoMensile> getUtilizzoMensileById(Long id);
}
