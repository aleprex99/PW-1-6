package alexpre.flexikm.servlet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import alexpre.flexikm.servlet.model.AssocUtilizzoGaranzia;


public interface AssocUtilizzoGaranziaRepository extends JpaRepository<AssocUtilizzoGaranzia, Long> {
	 @Query("SELECT c FROM AssocUtilizzoGaranzia c WHERE c.id = :id")
	  List<AssocUtilizzoGaranzia> getAssocUtilizzoGaranziaById(Long id);

	  @Query("SELECT c FROM AssocUtilizzoGaranzia c WHERE c.idUtilMensile = :id")
	  List<AssocUtilizzoGaranzia> getAssocUtilizzoGaranzieByIdUtilMensile(Long id);

	  
}
