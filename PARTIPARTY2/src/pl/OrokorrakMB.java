package pl;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import bl.ZerbitzuLogikaEJB;
import dl.IrakasleakEntity;

@ApplicationScoped
@Named
public class OrokorrakMB {
	@EJB
	private ZerbitzuLogikaEJB zerbitzuLogikaEJB;
	
	private String erabIzena;
	
	public List<IrakasleakEntity> getListIrakasleak(){
		List<IrakasleakEntity> produktuenZerrenda;
		produktuenZerrenda=zerbitzuLogikaEJB.getIrakasleakEntity();
		return produktuenZerrenda;
	}
	public IrakasleakEntity irakaslearenDatuak() {
		IrakasleakEntity irakas=(IrakasleakEntity)zerbitzuLogikaEJB.getIrakasleBakarra(erabIzena);
		return irakas;
	}
	public String getErabIzena() {
		return erabIzena;
	}
	public void setErabIzena(String erabIzena) {
		this.erabIzena=erabIzena;
	}
}
