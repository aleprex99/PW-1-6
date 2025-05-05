package alexpre.flexikm.servlet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import alexpre.flexikm.servlet.model.Garanzia;

public interface GaranziaRepository extends JpaRepository<Garanzia, Long>
{
  String deleteGaranziaById(Long id);

  @Query("SELECT c FROM Garanzia c WHERE c.id = :id")
  List<Garanzia> getGaranziaById(Long id);
}
