package dl;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Irakasleak database table.
 * 
 */
@Entity
@Table(name="Irakasleak")
@NamedQueries({
	@NamedQuery(name="IrakasleakEntity.findAll", query="SELECT i FROM IrakasleakEntity i"),
	@NamedQuery(name="IrakasleakEntity.findKokapena", query="SELECT i FROM IrakasleakEntity i WHERE i.kokapena = :kokapena"),
	@NamedQuery(name="IrakasleakEntity.findPrezioa", query="SELECT i FROM IrakasleakEntity i WHERE i.dirua = :dirua"),
	@NamedQuery(name="IrakasleakEntity.findErabiltzailea", query="SELECT i FROM IrakasleakEntity i WHERE i.erabiltzaileIzena = :erabiltzaileIzena"),
	@NamedQuery(name="IrakasleakEntity.findPasahitza", query="SELECT i FROM IrakasleakEntity i WHERE  i.pasahitza = :pasahitza")
})
public class IrakasleakEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIrakasleak;

	private String abizenak;

	private String datuak;

	private float dirua;

	private String erabiltzaileIzena;

	private String izena;

	@Temporal(TemporalType.DATE)
	private Date jaiotzedata;

	private String kokapena;

	private String pasahitza;

	private String telefonoZenbakia;

	public IrakasleakEntity() {
	}

	public IrakasleakEntity(String izena, String abizenak, String datuak, String erabiltzaileIzena, String pasahitza, float dirua, Date jaiotzedata, String kokapena, String telefonoZenbakia) {
		this.izena=izena;
		this.abizenak=abizenak;
		this.datuak=datuak;
		this.erabiltzaileIzena=erabiltzaileIzena;
		this.pasahitza=pasahitza;
		this.dirua=dirua;
		this.jaiotzedata=jaiotzedata;
		this.kokapena=kokapena;
		this.telefonoZenbakia=telefonoZenbakia;
	}
	public int getIdIrakasleak() {
		return this.idIrakasleak;
	}

	public void setIdIrakasleak(int idIrakasleak) {
		this.idIrakasleak = idIrakasleak;
	}

	public String getAbizenak() {
		return this.abizenak;
	}

	public void setAbizenak(String abizenak) {
		this.abizenak = abizenak;
	}

	public String getDatuak() {
		return this.datuak;
	}

	public void setDatuak(String datuak) {
		this.datuak = datuak;
	}

	public float getDirua() {
		return this.dirua;
	}

	public void setDirua(float dirua) {
		this.dirua = dirua;
	}

	public String getErabiltzaileIzena() {
		return this.erabiltzaileIzena;
	}

	public void setErabiltzaileIzena(String erabiltzaileIzena) {
		this.erabiltzaileIzena = erabiltzaileIzena;
	}

	public String getIzena() {
		return this.izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public Date getJaiotzedata() {
		return this.jaiotzedata;
	}

	public void setJaiotzedata(Date jaiotzedata) {
		this.jaiotzedata = jaiotzedata;
	}

	public String getKokapena() {
		return this.kokapena;
	}

	public void setKokapena(String kokapena) {
		this.kokapena = kokapena;
	}

	public String getPasahitza() {
		return this.pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getTelefonoZenbakia() {
		return this.telefonoZenbakia;
	}

	public void setTelefonoZenbakia(String telefonoZenbakia) {
		this.telefonoZenbakia = telefonoZenbakia;
	}

}