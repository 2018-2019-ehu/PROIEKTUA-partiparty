package pl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ZerbitzuLogikaEJB;

import dl.IkasleakEntity;
import dl.IrakasleakEntity;


@Named
@SessionScoped
public class IkasleZerbitzuakMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ZerbitzuLogikaEJB zle;
	private int kodea;
	private IkasleakEntity ikasleLogin=new IkasleakEntity();
	
	public void loginEgiaztatu(IkasleaMB ikaslea) {
		System.out.println("Hola");
		kodea=zle.ikasleaEgiaztatu(ikaslea.getErabiltzaileIzena(), ikaslea.getPasahitza());
		System.out.println("Kodea= "+kodea);
		if(kodea==8) {
			ikasleLogin=(IkasleakEntity)zle.getIkasleBakarra(ikaslea.getErabiltzaileIzena());
			
		}
		System.out.println(ikasleLogin.getErabiltzaileIzena());
	}
	
	public void ikasleaGehitu(IkasleaMB ikaslea) {
		IkasleakEntity ikasDB=new IkasleakEntity(ikaslea.getIzena(),ikaslea.getAbizenak(), 
				ikaslea.getDatuak(), ikaslea.getErabiltzaileIzena(), ikaslea.getPasahitza(), 
				ikaslea.getJaiotzedata(), ikaslea.getKokapena(), 
				ikaslea.getTelefonoZenbakia());
		kodea=zle.addIkasleaEntity(ikasDB);
		
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
				mezua="Erabiltzailea zuzen gehitu da datubasera";
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
