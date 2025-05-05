package alexpre.flexikm.servlet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import alexpre.flexikm.servlet.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>
{

  @Query("SELECT c FROM Cliente c WHERE UPPER(c.nome) = UPPER(:nome)")
  List<Cliente> getClienteByNome(@Param("nome") String nome);

  @Query("SELECT c FROM Cliente c WHERE UPPER(c.cognome) = UPPER(:cognome)")
  List<Cliente> getClienteByCognome(String cognome);

  @Query("SELECT c FROM Cliente c WHERE c.id = :id")
  List<Cliente> getClienteById(Long id);

  String deleteClienteById(Long id);

}
