package pl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import bl.ZerbitzuLogikaEJB;
import dl.IkasleakEntity;
import dl.IrakasleakEntity;
import dl.KlaseakEntity;


@ApplicationScoped
@Named
public class OrokorrakMB {
	@EJB
	private ZerbitzuLogikaEJB zerbitzuLogikaEJB;
	
	private String erabIzena;
	
	public List<IrakasleakEntity> getListIrakasleak(){
		List<IrakasleakEntity> irakasleenZerrenda;
		irakasleenZerrenda=zerbitzuLogikaEJB.getIrakasleakEntity();
		return irakasleenZerrenda;
	}
	public List<IkasleakEntity> getListIkasleak(){
		List<IkasleakEntity> ikasleenZerrenda;
		ikasleenZerrenda=zerbitzuLogikaEJB.getIkasleakEntity();
		return ikasleenZerrenda;
	}
	public IrakasleakEntity irakaslearenDatuak() {
		IrakasleakEntity irakas=(IrakasleakEntity)zerbitzuLogikaEJB.getIrakasleBakarra(erabIzena);
		return irakas;
	}
	public List<KlaseakEntity> getListKlaseak(){
		List<KlaseakEntity> klaseenZerrenda=zerbitzuLogikaEJB.getKlaseakEntity();
		return klaseenZerrenda;
	}
	
	public String getErabIzena() {
		return erabIzena;
	}
	public void setErabIzena(String erabIzena) {
		this.erabIzena=erabIzena;
	}
}
