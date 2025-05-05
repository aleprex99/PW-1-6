package alexpre.flexikm.servlet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "utilizzo_mensile")
public class UtilizzoMensile
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utilmen_seq")
  @SequenceGenerator(sequenceName = "id_seq", allocationSize = 1, name = "utilmen_seq")
  private Long id;
  private long polizzaId;
  private Integer anno;
  private Integer mese;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public long getPolizzaId() {
    return polizzaId;
  }

  public void setPolizzaId(long polizzaId) {
    this.polizzaId = polizzaId;
  }

  public Integer getAnno() {
    return anno;
  }

  public void setAnno(Integer anno) {
    this.anno = anno;
  }

  public Integer getMese() {
    return mese;
  }

  public void setMese(Integer mese) {
    this.mese = mese;
  }

}
