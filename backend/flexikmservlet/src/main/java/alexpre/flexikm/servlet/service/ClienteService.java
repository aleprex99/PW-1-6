package alexpre.flexikm.servlet.service;

import java.util.List;

import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.Cliente;

@Service
public interface ClienteService
{
  public Cliente insert(Cliente cliente);

  public List<Cliente> getClienti();

  public Cliente update(Cliente cliente);

  public String deleteClienteById(Long id);

  public List<Cliente> getClienteByCognome(String cognome);

  public List<Cliente> getClienteByNome(String nome);

  public List<Cliente> getClienteById(Long id);
}
