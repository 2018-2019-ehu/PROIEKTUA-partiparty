package pl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ZerbitzuLogikaEJB;
import dl.EskariakEntity;
import dl.IkasgaiakEntity;
import dl.IrakasleakEntity;
import dl.KlaseakEntity;

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

		irakasleLogin.setDatuak(irakaslea.getDatuak());
		zle.irakasleDatuakAldatu(irakasleLogin.getErabiltzaileIzena(), irakasleLogin.getDatuak());	
	}
	public void irakaslearenPasahitzaAldatu(IrakasleaMB irakaslea) {

		irakasleLogin.setPasahitza(irakaslea.getPasahitza());
		zle.irakaslePasahitzaAldatu(irakasleLogin.getErabiltzaileIzena(), irakasleLogin.getPasahitza());	
	}
	public void irakaslearenKokapenaAldatu(IrakasleaMB irakaslea) {

		irakasleLogin.setKokapena(irakaslea.getKokapena());
		zle.irakasleKokapenaAldatu(irakasleLogin.getErabiltzaileIzena(), irakasleLogin.getKokapena());	
	}
	public void irakaslearenTelefonoaAldatu(IrakasleaMB irakaslea) {

		irakasleLogin.setTelefonoZenbakia(irakaslea.getTelefonoZenbakia());
		zle.irakasleTelefonoaAldatu(irakasleLogin.getErabiltzaileIzena(), irakasleLogin.getTelefonoZenbakia());	
	}
	public IrakasleakEntity irakaslearenProfila() {
		return irakasleLogin;
	}
	
	public List<KlaseakEntity> getListKlaseak(){
		List<KlaseakEntity> klaseak=(List<KlaseakEntity>)zle.getIrakasleBatenKlaseak(irakasleLogin.getErabiltzaileIzena());
		return klaseak;
	}
	public void klaseaGehitu(KlaseaMB klasea) {
		kodea=zle.addKlaseaEntity(irakasleLogin.getErabiltzaileIzena()
				,klasea.getIkasgaia().getIdIkasgaiak()
				,klasea.getMaila().getIdMailak()
				,klasea.getOrdutegia().getIdOrdutegia());
	}
	public void klaseaEzabatu(int idKlasea) {
		zle.removeKlaseaEntity(idKlasea);
	}
	public void ikasgaiaGehitu(KlaseaMB klas) {
		IkasgaiakEntity ikas=new IkasgaiakEntity();
		ikas.setIzena(klas.getIrak());
		zle.addIkasgaiaEntity(ikas);
	}
	
	public List<EskariakMB> getListEskariOnartuak(){
		List<EskariakMB> eskariak;
		eskariak=new ArrayList<EskariakMB>();
		List<EskariakEntity> eskariList=(List<EskariakEntity>)zle.getIrakasleenEskariOnartuak(irakasleLogin.getErabiltzaileIzena());
		EskariakEntity esk;
		EskariakMB aux=new EskariakMB();
		for(int i=0;i<eskariList.size();i++) {
			esk=eskariList.get(i);
			aux.setId(esk.getIdEskariak());
			aux.setIkasgaia(esk.getKlaseak().getIkasgaiak().getIzena());
			aux.setIkaslea(esk.getIkasleak().getErabiltzaileIzena());
			aux.setPrezioa(irakasleLogin.getDirua());
			aux.setOrdutegia(esk.getKlaseak().getOrdutegiak().getIzena());
			aux.setMaila(esk.getKlaseak().getMailak().getIzena());
			eskariak.add(i, aux);
		}
		return eskariak;
	}
	public List<EskariakMB> getListEskariEskatuak(){
		List<EskariakMB> eskariak;
		eskariak=new ArrayList<EskariakMB>();
		List<EskariakEntity> eskariList=(List<EskariakEntity>)zle.getIrakasleenEskariEskatuak(irakasleLogin.getErabiltzaileIzena());
		EskariakEntity esk;
		EskariakMB aux=new EskariakMB();
		for(int i=0;i<eskariList.size();i++) {
			esk=eskariList.get(i);
			aux.setId(esk.getIdEskariak());
			aux.setIkasgaia(esk.getKlaseak().getIkasgaiak().getIzena());
			aux.setIkaslea(esk.getIkasleak().getErabiltzaileIzena());
			aux.setPrezioa(irakasleLogin.getDirua());
			aux.setOrdutegia(esk.getKlaseak().getOrdutegiak().getIzena());
			aux.setMaila(esk.getKlaseak().getMailak().getIzena());
			eskariak.add(i, aux);
		}
		return eskariak;
	}
	public void eskariaOnartu(int idEskaria) {
		zle.eskariaOnartu(idEskaria);
	}
	public void eskariaEzeztatu(int idEskaria) {
		zle.removeEskariaEntity(idEskaria);
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
