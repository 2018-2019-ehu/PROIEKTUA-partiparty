package pl;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class IrakasleaMB {

	private String izena;
	private String abizenak;
	private String datuak;
	private String erabiltzaileIzena;
	private String pasahitza;
	private float dirua;
	private Date jaiotzedata;
	private String kokapena;
	private String telefonoZenbakia;
	
	public IrakasleaMB() {
		
	}
	public IrakasleaMB(String izena, String abizenak, String datuak, String erabiltzaileIzena, String pasahitza, float dirua, Date jaiotzedata, String kokapena, String telefonoZenbakia) {
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
	
	public String getAbizenak() {
		return abizenak;
	}

	public void setAbizenak(String abizenak) {
		this.abizenak = abizenak;
	}

	public String getDatuak() {
		return datuak;
	}

	public void setDatuak(String datuak) {
		this.datuak = datuak;
	}

	public float getDirua() {
		return dirua;
	}

	public void setDirua(float dirua) {
		this.dirua = dirua;
	}

	public String getErabiltzaileIzena() {
		return erabiltzaileIzena;
	}

	public void setErabiltzaileIzena(String erabiltzaileIzena) {
		this.erabiltzaileIzena = erabiltzaileIzena;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public Date getJaiotzedata() {
		return jaiotzedata;
	}

	public void setJaiotzedata(Date jaiotzedata) {
		this.jaiotzedata = jaiotzedata;
	}

	public String getKokapena() {
		return kokapena;
	}

	public void setKokapena(String kokapena) {
		this.kokapena = kokapena;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public String getTelefonoZenbakia() {
		return telefonoZenbakia;
	}

	public void setTelefonoZenbakia(String telefonoZenbakia) {
		this.telefonoZenbakia = telefonoZenbakia;
	}
	
}
