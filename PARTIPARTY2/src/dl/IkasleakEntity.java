package dl;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the Ikasleak database table.
 * 
 */
@Entity
@Table(name="Ikasleak")
@NamedQueries({
	@NamedQuery(name="IkasleakEntity.findAll", query="SELECT i FROM IkasleakEntity i"),
	@NamedQuery(name="IkasleakEntity.findErabiltzailea", query="SELECT i FROM IkasleakEntity i WHERE i.erabiltzaileIzena = :erabiltzaileIzena"),
	@NamedQuery(name="IkasleakEntity.findErabilPasahitz", query="SELECT i FROM IkasleakEntity i WHERE i.erabiltzaileIzena = :erabiltzaileIzena AND i.pasahitza = :pasahitza")
})
public class IkasleakEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIkasleak;

	private String abizenak;

	private String datuak;

	private String erabiltzaileIzena;

	private String izena;

	@Temporal(TemporalType.DATE)
	private Date jaiotzedata;

	private String kokapena;

	private String pasahitza;

	@Column(name="telefono_zenbakia")
	private String telefonoZenbakia;

	public IkasleakEntity() {
	}
	public IkasleakEntity(String izena, String abizenak, String datuak, String erabiltzaileIzena, String pasahitza, Date jaiotzedata, String kokapena, String telefonoZenbakia) {
		this.izena=izena;
		this.abizenak=abizenak;
		this.datuak=datuak;
		this.erabiltzaileIzena=erabiltzaileIzena;
		this.pasahitza=pasahitza;
		this.jaiotzedata=jaiotzedata;
		this.kokapena=kokapena;
		this.telefonoZenbakia=telefonoZenbakia;
	}
	
	public int getIdIkasleak() {
		return this.idIkasleak;
	}

	public void setIdIkasleak(int idIkasleak) {
		this.idIkasleak = idIkasleak;
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