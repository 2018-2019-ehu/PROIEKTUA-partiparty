package pl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class EskariakMB {

	private int idEskaria;
	private String ikasgaia;
	private String ikaslea;
	private float prezioa;
	private String ordutegia;
	private String maila;
	
	public EskariakMB() {
		
	}
	public EskariakMB(String ikasgaia, String ikaslea, float prezioa, String ordutegia, String maila) {
		this.ikasgaia=ikasgaia;
		this.ikaslea=ikaslea;
		this.prezioa=prezioa;
		this.ordutegia=ordutegia;
		this.maila=maila;
	}
	public int getId() {
		return idEskaria;
	}
	public void setId(int idEskaria) {
		this.idEskaria=idEskaria;
	}
	public String getIkasgaia() {
		return ikasgaia;
	}
	public void setIkasgaia(String ikasgaia) {
		this.ikasgaia=ikasgaia;
	}
	public String getIkaslea() {
		return ikaslea;
	}
	public void setIkaslea(String ikaslea) {
		this.ikaslea=ikaslea;	
	}
	public float getPrezioa() {
		return prezioa;
	}
	public void setPrezioa(float prezioa) {
		this.prezioa=prezioa;
	}
	public String getOrdutegia() {
		return ordutegia;
	}
	public void setOrdutegia(String ordutegia) {
		this.ordutegia=ordutegia;
	}
	public String getMaila() {
		return maila;
	}
	public void setMaila(String maila) {
		this.maila=maila;
	}
	
	
	
	
	
	
}
