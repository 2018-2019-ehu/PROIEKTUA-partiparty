package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Ikasgaiak database table.
 * 
 */
@Entity
@Table(name="Ikasgaiak")
@NamedQueries({
	@NamedQuery(name="IkasgaiakEntity.findAll", query="SELECT i FROM IkasgaiakEntity i"),
	@NamedQuery(name="IkasgaiakEntity.findIzena", query="SELECT i FROM IkasgaiakEntity i WHERE i.izena = :izena")
})
public class IkasgaiakEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIkasgaiak;

	private String izena;

	public IkasgaiakEntity() {
	}

	public int getIdIkasgaiak() {
		return this.idIkasgaiak;
	}

	public void setIdIkasgaiak(int idIkasgaiak) {
		this.idIkasgaiak = idIkasgaiak;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

}