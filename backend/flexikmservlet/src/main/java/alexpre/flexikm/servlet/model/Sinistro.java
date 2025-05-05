package alexpre.flexikm.servlet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Sinistro")
public class Sinistro
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sinistro_seq")
  @SequenceGenerator(sequenceName = "id_seq", allocationSize = 1, name = "sinistro_seq")
  private Long id;

  private String numeroSinistro;
  private Long idPolizza;
  private String luogo;
  private String tipo;
  private String descr;
  private String nome;
  private String cognome;
  private String cf;
  private String email;
  private String tel;
  private String indirizzo;
  private String numeroPatente;
  private String stato;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNumeroSinistro() {
    return numeroSinistro;
  }

  public void setNumeroSinistro(String numeroSinistro) {
    this.numeroSinistro = numeroSinistro;
  }

  public Long getIdPolizza() {
    return idPolizza;
  }

  public void setIdPolizza(Long idPolizza) {
    this.idPolizza = idPolizza;
  }

  public String getLuogo() {
    return luogo;
  }

  public void setLuogo(String luogo) {
    this.luogo = luogo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getDescr() {
    return descr;
  }

  public void setDescr(String descr) {
    this.descr = descr;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCognome() {
    return cognome;
  }

  public void setCognome(String cognome) {
    this.cognome = cognome;
  }

  public String getCf() {
    return cf;
  }

  public void setCf(String cf) {
    this.cf = cf;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getIndirizzo() {
    return indirizzo;
  }

  public void setIndirizzo(String indirizzo) {
    this.indirizzo = indirizzo;
  }

  public String getNumeroPatente() {
    return numeroPatente;
  }

  public void setNumeroPatente(String numeroPatente) {
    this.numeroPatente = numeroPatente;
  }

  public String getStato() {
    return stato;
  }

  public void setStato(String stato) {
    this.stato = stato;
  }

}
