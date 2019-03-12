package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Ikasleak database table.
 * 
 */
@Entity
@Table(name="Ikasleak")
@NamedQuery(name="IkasleakEntity.findAll", query="SELECT i FROM IkasleakEntity i")
public class IkasleakEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idIkasleak;

	private String abizenak;

	private String datuak;

	@Column(name="erabiltzaile_izena")
	private String erabiltzaileIzena;

	private String izena;

	private String jaiotzedata;

	private String kokapena;

	private String pasahitza;

	@Column(name="telefono_zenbakia")
	private String telefonoZenbakia;

	public IkasleakEntity() {
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

	public String getJaiotzedata() {
		return this.jaiotzedata;
	}

	public void setJaiotzedata(String jaiotzedata) {
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