package pl;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ZerbitzuLogikaEJB;
import dl.IrakasleakEntity;

@Named
@SessionScoped
public class AdminZerbitzuakMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ZerbitzuLogikaEJB zle;
	private int kodea;
	private IrakasleakEntity irakasleLogin=new IrakasleakEntity();
	
	public void loginEgiaztatu(IrakasleaMB irakaslea) {
		System.out.println("Hola");
		kodea=zle.irakasleaEgiaztatu(irakaslea.getErabiltzaileIzena(), irakaslea.getPasahitza());
		System.out.println("Kodea= "+kodea);
		if(kodea==8) {
			irakasleLogin=(IrakasleakEntity)zle.getIrakasleBakarra(irakaslea.getErabiltzaileIzena());
			
		}
		System.out.println(irakasleLogin.getErabiltzaileIzena());
	}
	
	public void irakasleaGehitu(IrakasleaMB irakaslea) {
		IrakasleakEntity irakasDB=new IrakasleakEntity(irakaslea.getIzena(),irakaslea.getAbizenak(), 
				irakaslea.getDatuak(), irakaslea.getErabiltzaileIzena(), irakaslea.getPasahitza(), 
				irakaslea.getDirua(),irakaslea.getJaiotzedata(), irakaslea.getKokapena(), 
				irakaslea.getTelefonoZenbakia());
		kodea=zle.addIrakasleaEntity(irakasDB);
		
	}
	public void irakaslearenDatuakAldatu(IrakasleaMB irakaslea) {
		irakasleLogin=(IrakasleakEntity)zle.
				irakasleDatuakAldatu(irakasleLogin.getErabiltzaileIzena(), irakaslea.getDatuak());
	}
	public IrakasleakEntity irakaslearenProfila() {
		return irakasleLogin;
	}
	public int getKodea(){
		return kodea;
	}
	public String getMezua(){
		String mezua;
		switch (kodea){
			case 0:
				mezua="Ez dago errorerik";
				break;
			case 1:
				mezua="Erabiltzaile izen horrekin irakasle bat existitzen da jadanik";
				break;
			case 2:
				mezua="Erabiltzailea zuzen gehitu da";
				break;
			case 3:
				mezua="Erabiltzailea ez da existitzen";
				break;
			case 4:
				mezua="Gehitutako eroslea jadanik existitzen da";
				break;
			case 5:
				mezua="Produktu berria gehitu da";
				break;
			case 6:
				mezua="Erosle berria gehitu da";
				break;
			case 7:
				mezua="Eskaria egin da";
				break;
			case 8:
				mezua="Logina ondo gauzatu da";
				break;
			case 9:
				mezua="Erabiltzaile edo pasahitz okerrak";
				break;
			default:
				mezua="default";
				break;
		}
		return mezua;
	}
}
