package alexpre.flexikm.servlet.model;

import java.util.Calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Polizza")
public class Polizza
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "polizza_seq")
  @SequenceGenerator(sequenceName = "id_seq", allocationSize = 1, name = "polizza_seq")
  private Long id;

  private String numeroPolizza;
  private Long clienteId;
  private Long veicoloId;
  private Calendar dataInizio;
  private Integer durata;
  private String stato;
  private Float quotaMensile;
  private Long kmMensili;
  private Float costoExtra;
  private String guidaEsclusiva;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumeroPolizza() {
    return numeroPolizza;
  }

  public void setNumeroPolizza(String numeroPolizza) {
    this.numeroPolizza = numeroPolizza;
  }

  public Long getClienteId() {
    return clienteId;
  }

  public void setClienteId(Long clienteId) {
    this.clienteId = clienteId;
  }

  public Long getVeicoloId() {
    return veicoloId;
  }

  public void setVeicoloId(Long veicoloId) {
    this.veicoloId = veicoloId;
  }

  public Calendar getDataInizio() {
    return dataInizio;
  }

  public void setDataInizio(Calendar dataInizio) {
    this.dataInizio = dataInizio;
  }

  public Integer getDurata() {
    return durata;
  }

  public void setDurata(Integer durata) {
    this.durata = durata;
  }

  public String getStato() {
    return stato;
  }

  public void setStato(String stato) {
    this.stato = stato;
  }

  public Float getQuotaMensile() {
    return quotaMensile;
  }

  public void setQuotaMensile(Float quotaMensile) {
    this.quotaMensile = quotaMensile;
  }

  public Long getKmMensili() {
    return kmMensili;
  }

  public void setKmMensili(Long kmMensili) {
    this.kmMensili = kmMensili;
  }

  public Float getCostoExtra() {
    return costoExtra;
  }

  public void setCostoExtra(Float costoExtra) {
    this.costoExtra = costoExtra;
  }

  public String getGuidaEsclusiva() {
    return guidaEsclusiva;
  }

  public void setGuidaEsclusiva(String guidaEsclusiva) {
    this.guidaEsclusiva = guidaEsclusiva;
  }

}
