package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Mailak database table.
 * 
 */
@Entity
@Table(name="Mailak")
@NamedQuery(name="MailakEntity.findAll", query="SELECT m FROM MailakEntity m")
public class MailakEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMailak;

	private String izena;

	public MailakEntity() {
	}

	public int getIdMailak() {
		return this.idMailak;
	}

	public void setIdMailak(int idMailak) {
		this.idMailak = idMailak;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

}