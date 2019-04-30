package pl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import bl.ZerbitzuLogikaEJB;
import dl.EskariakEntity;
import dl.IkasleakEntity;
import dl.IrakasleakEntity;
import dl.KlaseakEntity;



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
	private IrakasleakEntity irakaslea=new IrakasleakEntity();
	private List<KlaseakEntity> listKlase=new ArrayList<KlaseakEntity>();

	
	public String loginEgiaztatu(IkasleaMB ikaslea) {
		String orria="ikasleSarrera.xhtml";
		
		kodea=zle.ikasleaEgiaztatu(ikaslea.getErabiltzaileIzena(), ikaslea.getPasahitza());
		
		if(kodea==12) {
			ikasleLogin=(IkasleakEntity)zle.getIkasleBakarra(ikaslea.getErabiltzaileIzena());
			orria="ikaslearenProfila.xhtml";
		}else {
			if(kodea==10) {
				orria="erabiltzaileErroreaIkasle.xhtml";
			}else {
				if(kodea==11) {
					orria="pasahitzErroreaIkasle.xhtml";
				}
			}
			
		}
		ikaslea.clearForm();
		return orria;
	}
	
	public void ikasleaGehitu(IkasleaMB ikaslea) {
		IkasleakEntity ikasDB=new IkasleakEntity(ikaslea.getIzena(),ikaslea.getAbizenak(), 
				ikaslea.getDatuak(), ikaslea.getErabiltzaileIzena(), ikaslea.getPasahitza(), 
				ikaslea.getJaiotzedata(), ikaslea.getKokapena(), 
				ikaslea.getTelefonoZenbakia());
		kodea=zle.addIkasleaEntity(ikasDB);
		ikaslea.clearForm();

		
	}
	
	public IkasleakEntity ikaslearenProfila() {
		return ikasleLogin;
	}
	
	public void ikaslearenDatuakAldatu(IkasleaMB ikaslea) {

		ikasleLogin.setDatuak(ikaslea.getDatuak());
		zle.ikasleDatuakAldatu(ikasleLogin.getErabiltzaileIzena(), ikasleLogin.getDatuak());	
	}
	public void ikaslearenPasahitzaAldatu(IkasleaMB ikaslea) {

		ikasleLogin.setPasahitza(ikaslea.getPasahitza());
		zle.ikaslePasahitzaAldatu(ikasleLogin.getErabiltzaileIzena(), ikasleLogin.getPasahitza());	
	}
	public void ikaslearenKokapenaAldatu(IkasleaMB ikaslea) {

		ikasleLogin.setKokapena(ikaslea.getKokapena());
		zle.ikasleKokapenaAldatu(ikasleLogin.getErabiltzaileIzena(), ikasleLogin.getKokapena());	
	}
	public void ikaslearenTelefonoaAldatu(IkasleaMB ikaslea) {

		ikasleLogin.setTelefonoZenbakia(ikaslea.getTelefonoZenbakia());
		zle.ikasleTelefonoaAldatu(ikasleLogin.getErabiltzaileIzena(), ikasleLogin.getTelefonoZenbakia());	
	}
	
	public List<EskariakEntity> getListEskariOnartuak(){
		//List<EskariakMB> eskariak;
		//eskariak=new ArrayList<EskariakMB>();
		List<EskariakEntity> eskariList=(List<EskariakEntity>)zle.getIkasleenEskariOnartuak(ikasleLogin.getErabiltzaileIzena());
		/*EskariakEntity esk;
		EskariakMB aux=new EskariakMB();
		for(int i=0;i<eskariList.size();i++) {
			esk=eskariList.get(i);
			aux.setId(esk.getIdEskariak());
			aux.setIkasgaia(esk.getKlaseak().getIkasgaiak().getIzena());
			aux.setIkaslea(esk.getIkasleak().getErabiltzaileIzena());
			aux.setPrezioa(esk.getKlaseak().getIrakasleak().getDirua());
			aux.setOrdutegia(esk.getKlaseak().getOrdutegiak().getIzena());
			aux.setMaila(esk.getKlaseak().getMailak().getIzena());
			eskariak.add(i, aux);
		}*/
		return eskariList;
	}
	public List<EskariakEntity> getListEskariEskatuak(){
		
		List<EskariakEntity> eskariList=(List<EskariakEntity>)zle.getIkasleenEskariEskatuak(ikasleLogin.getErabiltzaileIzena());
		
		return eskariList;
	}
	public void eskariaOnartu(int idEskaria) {
		zle.eskariaOnartu(idEskaria);
	}
	public void eskariaEzeztatu(int idEskaria) {
		kodea=zle.removeEskariaEntity(idEskaria);
	}
	
	public List<KlaseakEntity> iragazkienEmaitzak(){
		return listKlase;
	}
	public void klaseIragazkiak(IragazkiakMB ira) {
		if(ira.getKokapena().isEmpty()) {
			System.out.println(ira.getKokapena()+"kokap");
		}
			
	
		if((ira.getIkasgaia().getIdIkasgaiak())==1) {
			if((ira.getMaila().getIdMailak())==1) {
				if((ira.getKokapena()).isEmpty()) {
					System.out.println(ira.getKokapena()+"kok");
					listKlase=zle.getKlaseakEntity();
				}
				else {
					listKlase=zle.getKok(ira.getKokapena());
					if(listKlase.size()==0) {
						kodea=15;
					}
				}
			}else {
				if((ira.getKokapena()).isEmpty()) {
					listKlase=zle.getMaila(ira.getMaila().getIdMailak());
					if(listKlase.size()==0) {
						kodea=15;
					}
					
				}
				else {
					listKlase=zle.getKokMaila(ira.getKokapena(), ira.getMaila().getIdMailak());
					if(listKlase.size()==0) {
						kodea=15;
					}
				}
			}
		}else {
			if(ira.getMaila().getIdMailak()==1) {
				if((ira.getKokapena()).isEmpty()) {
					listKlase=zle.getIkas(ira.getIkasgaia().getIdIkasgaiak());
					if(listKlase.size()==0) {
						kodea=15;
					}
				}
				else {
					listKlase=zle.getKokIkas(ira.getKokapena(), ira.getIkasgaia().getIdIkasgaiak());
					if(listKlase.size()==0) {
						kodea=15;
					}
				}
			}else {
				if((ira.getKokapena()).isEmpty()) {
					listKlase=zle.getIkasMaila(ira.getIkasgaia().getIdIkasgaiak(), ira.getMaila().getIdMailak());
					if(listKlase.size()==0) {
						kodea=15;
					}
				}
				else {
					listKlase=zle.getKokIkasMaila(ira.getKokapena(), ira.getIkasgaia().getIdIkasgaiak(), ira.getMaila().getIdMailak());
					if(listKlase.size()==0) {
						kodea=15;
					}
				}
			}
		}
		
	}
	public void irakasleaGorde(String erabiltzaileIzena) {
		irakaslea=zle.getIrakasleBakarra(erabiltzaileIzena);
	}
	public IrakasleakEntity irakaslearenDatuak() {
		return irakaslea;
	}
	
	public List<KlaseakEntity> getListKlaseak(){
		List<KlaseakEntity> klaseak=(List<KlaseakEntity>)zle.getIrakasleBatenKlaseak(irakaslea.getErabiltzaileIzena());
		return klaseak;
	}
	public void eskariaGehitu(int idKlasea) {
		EskariakEntity eskaria=new EskariakEntity();
		eskaria.setEgoera(0);
		kodea=zle.addEskariaEntity(eskaria, ikasleLogin.getErabiltzaileIzena(), idKlasea);
	}
	public void ikasleaEzabatu() {
		kodea=zle.removeIkasleaEntity(ikasleLogin.getIdIkasleak());
	}
	
	public int getKodea(){
		return kodea;
	}
	public String getMezua(){
		String mezua;
		switch (kodea){
			case 0:
				mezua="Ez dago ";
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
			case 15:
				mezua="Ez dago emaitzik";
				break;
			default:
				mezua="default";
				break;
		}
		return mezua;
	}
}
