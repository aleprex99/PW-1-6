package alexpre.flexikm.servlet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "assoc_utilizzo_garanzia")
public class AssocUtilizzoGaranzia {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "assoc_seq")
	@SequenceGenerator(sequenceName = "id_seq", allocationSize = 1, name = "assoc_seq")
	private Long id;
	private Long idUtilMensile;
	private Long idGaranzia;
	  
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdUtilMensile() {
		return idUtilMensile;
	}
	public void setIdUtilMensile(Long idUtilMensile) {
		this.idUtilMensile = idUtilMensile;
	}
	public Long getIdGaranzia() {
		return idGaranzia;
	}
	public void setIdGaranzia(Long idGaranzia) {
		this.idGaranzia = idGaranzia;
	}
	

}
