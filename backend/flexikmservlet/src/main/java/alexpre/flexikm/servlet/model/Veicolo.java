package alexpre.flexikm.servlet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "veicolo")
public class Veicolo
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "veicolo_seq")
  @SequenceGenerator(sequenceName = "id_seq", allocationSize = 1, name = "veicolo_seq")
  private Long id;

  private String targa;
  private String modello;
  private Integer annoImmatr;
  private Float valore;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTarga() {
    return targa;
  }

  public void setTarga(String targa) {
    this.targa = targa;
  }

  public String getModello() {
    return modello;
  }

  public void setModello(String modello) {
    this.modello = modello;
  }

  public Integer getAnnoImmatr() {
    return annoImmatr;
  }

  public void setAnnoImmatr(Integer annoImmatr) {
    this.annoImmatr = annoImmatr;
  }

  public Float getValore() {
    return valore;
  }

  public void setValore(Float valore) {
    this.valore = valore;
  }

}
