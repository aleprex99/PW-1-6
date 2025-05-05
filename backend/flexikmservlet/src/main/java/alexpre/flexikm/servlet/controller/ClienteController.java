package alexpre.flexikm.servlet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import alexpre.flexikm.servlet.model.Cliente;
import alexpre.flexikm.servlet.service.ClienteService;


@RestController
@RequestMapping("/Cliente")
public class ClienteController
{
  @Autowired
  ClienteService clienteService;

  @PostMapping("/insCliente")
  public Cliente insertCliente(@RequestBody Cliente cliente) {
    return clienteService.insert(cliente);
  }

  @PostMapping("/getClienti")
  public List<Cliente> getClienti() {
    return clienteService.getClienti();
  }

  @PostMapping("/updCliente")
  public Cliente updateCliente(@RequestBody Cliente cliente) {
    return clienteService.update(cliente);
  }

  @PostMapping("/getClienteByCognome/{cognome}")
  public List<Cliente> getClienteByCognome(@PathVariable String cognome) {
    return clienteService.getClienteByCognome(cognome);
  }

  @PostMapping("/getClienteByNome/{nome}")
  public List<Cliente> getClienteByNome(@PathVariable String nome) {
    return clienteService.getClienteByNome(nome);
  }

  @PostMapping("/getClienteById/{id}")
  public List<Cliente> getClienteById(@PathVariable long id) {
    return clienteService.getClienteById(id);
  }

  @PostMapping("/deleteClienteById/{id}")
  public String deleteClienteById(@PathVariable Long id) {
    return clienteService.deleteClienteById(id);
  }

}
