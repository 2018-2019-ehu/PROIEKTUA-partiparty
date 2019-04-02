package bl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.IkasgaiakEntity;
import dl.IkasleakEntity;
import dl.IrakasleakEntity;
import dl.KlaseakEntity;

/**
 * Session Bean implementation class ZerbitzuLogikaEJB
 */
@Singleton
@LocalBean
public class ZerbitzuLogikaEJB {

    @PersistenceContext
    private EntityManager em;
	
    public ZerbitzuLogikaEJB() {
        // TODO Auto-generated constructor stub
    }
    
    //IRAKASLEAK
    public List<IrakasleakEntity> getIrakasleakEntity(){
    	@SuppressWarnings("unchecked")
		List<IrakasleakEntity> irakasleenZerrenda=(List<IrakasleakEntity>)em.createNamedQuery("IrakasleakEntity.findAll").getResultList();
    	return irakasleenZerrenda;
    }
    public int addIrakasleaEntity(IrakasleakEntity irakaslea) {
    	int kodea=0;
    	try {
			@SuppressWarnings("unused")
			IrakasleakEntity irakasDB=(IrakasleakEntity)em.createNamedQuery("IrakasleakEntity.findErabiltzailea").setParameter("erabiltzaileIzena", irakaslea.getErabiltzaileIzena()).getSingleResult();
			kodea=1;
		} catch (Exception e) {
			em.persist(irakaslea);
			kodea=2;
		}
    	return kodea;
    }
    public int removeIrakasleaEntity(int idIrakasleak){
    	int kodea=0;
		IrakasleakEntity irakasDB=(IrakasleakEntity)em.find(IrakasleakEntity.class,idIrakasleak);
		if(irakasDB!=null){
			em.remove(irakasDB);
			kodea=3;
		}
		return kodea;
	}
    
  //IKASLEAK
    public List<IkasleakEntity> getIkasleakEntity(){
    	@SuppressWarnings("unchecked")
		List<IkasleakEntity> ikasleenZerrenda=(List<IkasleakEntity>)em.createNamedQuery("IkasleakEntity.findAll").getResultList();
    	return ikasleenZerrenda;
    }
    public int addIkasleaEntity(IkasleakEntity ikaslea) {
    	int kodea=0;
    	try {
			@SuppressWarnings("unused")
			IkasleakEntity ikasleDB=(IkasleakEntity)em.createNamedQuery("IkasleakEntity.findErabiltzailea").setParameter("erabiltzaileIzena", ikaslea.getErabiltzaileIzena()).getSingleResult();
			kodea=1;
		} catch (Exception e) {
			em.persist(ikaslea);
			kodea=2;
		}
    	return kodea;
    }
    public int removeIkasleaEntity(int idIkasleak){
    	int kodea=0;
		IkasleakEntity ikasleDB=(IkasleakEntity)em.find(IkasleakEntity.class,idIkasleak);
		if(ikasleDB!=null){
			em.remove(ikasleDB);
			kodea=3;
		}
		return kodea;
	}
    
    //IKASGAIAK
    public List<IkasgaiakEntity> getIkasgaiakEntity(){
    	@SuppressWarnings("unchecked")
		List<IkasgaiakEntity> ikasgaienZerrenda=(List<IkasgaiakEntity>)em.createNamedQuery("IkasgaiakEntity.findAll").getResultList();
    	return ikasgaienZerrenda;
    }
    public int addIkasgaiaEntity(IkasgaiakEntity ikasgaia) {
    	int kodea=0;
    	try {
			@SuppressWarnings("unused")
			IkasgaiakEntity ikasgaiDB=(IkasgaiakEntity)em.createNamedQuery("IkasgaiakEntity.findIzena").setParameter("izena", ikasgaia.getIzena()).getSingleResult();
			kodea=4;
		} catch (Exception e) {
			em.persist(ikasgaia);
			kodea=5;
		}
    	return kodea;
    }
    public int removeIkasgaiaEntity(int idIkasgaia) {
    	int kodea=0;
    	IkasgaiakEntity ikasgaiDB=(IkasgaiakEntity)em.find(IkasgaiakEntity.class, idIkasgaia);
    	if(ikasgaiDB!=null) {
    		em.remove(ikasgaiDB);
    		kodea=6;
    	}
    	return kodea;
    }
    
    //KLASEAK
    public List<KlaseakEntity> getKlaseakEntity(){
    	@SuppressWarnings("unchecked")
		List<KlaseakEntity> klaseenZerrenda=(List<KlaseakEntity>)em.createNamedQuery("KlaseakEntity.findAll").getResultList();
    	return klaseenZerrenda;
    }
    public int addKlaseaEntity(KlaseakEntity klasea) {
    	int kodea=0;
    	em.persist(klasea);
    	kodea=4;
    	return kodea;
    }
    public int removeKlaseaEntity(int idKlasea) {
    	int kodea=0;
    	KlaseakEntity klaseDB=(KlaseakEntity)em.find(KlaseakEntity.class, idKlasea);
    	if(klaseDB!=null) {
    		em.remove(klaseDB);
    		kodea=6;
    	}
    	return kodea;
    }
    
    //

}
