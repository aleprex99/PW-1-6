package alexpre.flexikm.servlet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente")
public class Cliente
{
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cliente_seq")
  @SequenceGenerator(sequenceName = "id_seq", allocationSize = 1, name = "cliente_seq")
  private Long id;

  private String password;
  private String attivo;
  private String nome;
  private String cognome;
  private String cf;
  private String nazionalita;
  private String email;
  private String tel;
  private String indirizzo;
  private Integer eta;
  private String classeMerito;
  private String docNumero;
  private String tipoDoc;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getAttivo() {
    return attivo;
  }

  public void setAttivo(String attivo) {
    this.attivo = attivo;
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

  public String getNazionalita() {
    return nazionalita;
  }

  public void setNazionalita(String nazionalita) {
    this.nazionalita = nazionalita;
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

  public Integer getEta() {
    return eta;
  }

  public void setEta(Integer eta) {
    this.eta = eta;
  }

  public String getClasseMerito() {
    return classeMerito;
  }

  public void setClasseMerito(String classeMerito) {
    this.classeMerito = classeMerito;
  }

  public String getDocNumero() {
    return docNumero;
  }

  public void setDocNumero(String docNumero) {
    this.docNumero = docNumero;
  }

  public String getTipoDoc() {
    return tipoDoc;
  }

  public void setTipoDoc(String tipoDoc) {
    this.tipoDoc = tipoDoc;
  }

}
