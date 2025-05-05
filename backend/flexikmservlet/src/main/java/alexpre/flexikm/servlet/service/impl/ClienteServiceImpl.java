package alexpre.flexikm.servlet.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alexpre.flexikm.servlet.model.Cliente;
import alexpre.flexikm.servlet.repository.ClienteRepository;
import alexpre.flexikm.servlet.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService
{
  @Autowired
  ClienteRepository clienteRepository;

  @Override
  public Cliente insert(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @Override
  public List<Cliente> getClienti() {
    return clienteRepository.findAll();
  }

  @Override
  public Cliente update(Cliente cliente) {
    return clienteRepository.save(cliente);
  }

  @Override
  public String deleteClienteById(Long id) {
    clienteRepository.deleteById(id);

    return "Cliente Cancellato !";
  }

  @Override
  public List<Cliente> getClienteByCognome(String cognome) {
    return clienteRepository.getClienteByCognome(cognome);
  }

  @Override
  public List<Cliente> getClienteByNome(String nome) {
    return clienteRepository.getClienteByNome(nome);
  }

  @Override
  public List<Cliente> getClienteById(Long id) {
    return clienteRepository.getClienteById(id);
  }


}
