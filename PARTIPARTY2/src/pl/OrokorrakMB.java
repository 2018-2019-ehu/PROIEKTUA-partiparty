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
	
	public List<IrakasleakEntity> getListIrakasleak(){
		List<IrakasleakEntity> irakasleenZerrenda;
		irakasleenZerrenda=zerbitzuLogikaEJB.getIrakasleakEntity();
		return irakasleenZerrenda;
	}
	public List<IrakasleakEntity> getListIrakasleBat(){
		List<IrakasleakEntity> irakasleBatZerrenda;
		irakasleBatZerrenda=zerbitzuLogikaEJB.getIrakasleaBatEntity();
		return irakasleBatZerrenda;
	}
}
