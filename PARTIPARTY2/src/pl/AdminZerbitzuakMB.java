package pl;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import bl.ZerbitzuLogikaEJB;
import dl.IrakasleakEntity;

@Named
@RequestScoped
public class AdminZerbitzuakMB {

	@EJB
	private ZerbitzuLogikaEJB zle;
	int kodea;
	
	public void loginEgiaztatu(IrakasleaMB irakaslea) {
		kodea=zle.irakasleaEgiaztatu(irakaslea.getErabiltzaileIzena(), irakaslea.getPasahitza());
	}
	public void irakasleaGehitu(IrakasleaMB irakaslea) {
		IrakasleakEntity irakasDB=new IrakasleakEntity(irakaslea.getIzena(),irakaslea.getAbizenak(), 
				irakaslea.getDatuak(), irakaslea.getErabiltzaileIzena(), irakaslea.getPasahitza(), 
				irakaslea.getDirua(),irakaslea.getJaiotzedata(), irakaslea.getKokapena(), 
				irakaslea.getTelefonoZenbakia());
		kodea=zle.addIrakasleaEntity(irakasDB);
		
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
				mezua="Altan emandako produktua jadanik existitzen da";
				break;
			case 2:
				mezua="Pasahitz okerra";
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
