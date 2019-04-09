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
	@NamedQuery(name="EskariakEntity.findIrakasonartua", query="SELECT e FROM EskariakEntity e WHERE e.egoera = 1 AND e.klaseak.irakasleak.erabiltzaileIzena = :erabiltzaileIzena"),
	@NamedQuery(name="EskariakEntity.findIrakaseskatua", query="SELECT e FROM EskariakEntity e WHERE e.egoera = 0 AND e.klaseak.irakasleak.erabiltzaileIzena = :erabiltzaileIzena"),
	@NamedQuery(name="EskariakEntity.findIkasonartua", query="SELECT e FROM EskariakEntity e WHERE e.egoera = 1 AND e.ikasleak.erabiltzaileIzena = :erabiltzaileIzena"),
	@NamedQuery(name="EskariakEntity.findIkaseskatua", query="SELECT e FROM EskariakEntity e WHERE e.egoera = 0 AND e.ikasleak.erabiltzaileIzena= :erabiltzaileIzena")
	
})
public class EskariakEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEskariak;

	//egoera=0 --> eskatua 
	//egoera=1 --> onartua
	//egoera=2 --> ezeztatua
	private int egoera;

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

	public int getEgoera() {
		return this.egoera;
	}

	public void setEgoera(int egoera) {
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