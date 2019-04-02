package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Eskariak database table.
 * 
 */
@Entity
@Table(name="Eskariak")
@NamedQueries({
	@NamedQuery(name="EskariakEntity.findAll", query="SELECT e FROM EskariakEntity e"),
	@NamedQuery(name="EskariakEntity.findIrakastrue", query="SELECT e FROM EskariakEntity e WHERE e.egoera =true AND e.klaseak.irakasleak.erabiltzaileIzena = :erabiltzaileIzena"),
	@NamedQuery(name="EskariakEntity.findIrakasfalse", query="SELECT e FROM EskariakEntity e WHERE e.egoera =false AND e.klaseak.irakasleak.erabiltzaileIzena = :erabiltzaileIzena"),
	@NamedQuery(name="EskariakEntity.findIkastrue", query="SELECT e FROM EskariakEntity e WHERE e.egoera =true AND e.ikasleak.erabiltzaileIzena = :erabiltzaileIzena"),
	@NamedQuery(name="EskariakEntity.findIkasfalse", query="SELECT e FROM EskariakEntity e WHERE e.egoera =false AND e.ikasleak.erabiltzaileIzena= :erabiltzaileIzena")
	
})

public class EskariakEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEskariak;

	private boolean egoera;

	//uni-directional many-to-one association to IkasleakEntity
	@ManyToOne
	@JoinColumn(name="ikaslea")
	private IkasleakEntity ikasleak;

	//uni-directional many-to-one association to KlaseakEntity
	@ManyToOne
	@JoinColumn(name="klasea")
	private KlaseakEntity klaseak;

	public EskariakEntity() {
	}

	public int getIdEskariak() {
		return this.idEskariak;
	}

	public void setIdEskariak(int idEskariak) {
		this.idEskariak = idEskariak;
	}

	public boolean getEgoera() {
		return this.egoera;
	}

	public void setEgoera(boolean egoera) {
		this.egoera = egoera;
	}

	public IkasleakEntity getIkasleak() {
		return this.ikasleak;
	}

	public void setIkasleak(IkasleakEntity ikasleak) {
		this.ikasleak = ikasleak;
	}

	public KlaseakEntity getKlaseak() {
		return this.klaseak;
	}

	public void setKlaseak(KlaseakEntity klaseak) {
		this.klaseak = klaseak;
	}

}