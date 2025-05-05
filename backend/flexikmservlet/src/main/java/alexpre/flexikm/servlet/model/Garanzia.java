package alexpre.flexikm.servlet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Garanzia")
public class Garanzia
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "garanzia_seq")
  @SequenceGenerator(sequenceName = "id_seq", allocationSize = 1, name = "garanzia_seq")
  private Long id;

  private String nome;
  private String descr;
  private Float costo;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getDescr() {
    return descr;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public Float getCosto() {
    return costo;
  }

  public void setCosto(Float costo) {
    this.costo = costo;
  }
}
