package bl;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dl.EskariakEntity;
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
    public List<IrakasleakEntity> getIrakasleaBatEntity(){
    	@SuppressWarnings("unchecked")
		List<IrakasleakEntity> irakaslearenZerrenda=(List<IrakasleakEntity>)em.createNamedQuery("IrakasleakEntity.findErabiltzailea").getResultList();
    	return irakaslearenZerrenda;
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
    public int addKlaseaEntity(KlaseakEntity klasea, String erabiltzaileIzena) {
    	int kodea=0;
		IrakasleakEntity irakaslea=(IrakasleakEntity)em.createNamedQuery("IrakasleakEntity.findErabiltzailea").setParameter("erabiltzaileIzena",erabiltzaileIzena).getSingleResult();
    	klasea.setIrakasleak(irakaslea);
    	em.persist(klasea);
    	kodea=4;
    	return kodea;
    }
    public int removeKlaseaEntity(int idKlasea) {
    	int kodea=0;
    	KlaseakEntity klaseDB=(KlaseakEntity)em.find(KlaseakEntity.class, idKlasea);
    	if(klaseDB!=null) {
    		em.remove(klaseDB);
    		kodea=5;
    	}
    	return kodea;
    }
    
    //ESKARIAK
    public List<EskariakEntity> getEskariakEntity(){
    	@SuppressWarnings("unchecked")
		List<EskariakEntity> eskarienZerrenda=(List<EskariakEntity>)em.createNamedQuery("EskariakEntity.findAll").getResultList();
    	return eskarienZerrenda;
    }
    public List<EskariakEntity> getIrakasleenEskariOnartuak(String erabiltzaileIzena){
    	@SuppressWarnings("unchecked")
		List<EskariakEntity> zerrenda=(List<EskariakEntity>)em.createNamedQuery("EskariakEntity.findIrakastrue").setParameter("erabiltzaileIzena", erabiltzaileIzena).getResultList();
    	return zerrenda;
    }
    public List<EskariakEntity> getIrakasleenEskariEzeztatuak(String erabiltzaileIzena){
    	@SuppressWarnings("unchecked")
		List<EskariakEntity> zerrenda=(List<EskariakEntity>)em.createNamedQuery("EskariakEntity.findIrakasfalse").setParameter("erabiltzaileIzena", erabiltzaileIzena).getResultList();
    	return zerrenda;
    }
    public List<EskariakEntity> getIkasleenEskariOnartuak(String erabiltzaileIzena){
    	@SuppressWarnings("unchecked")
		List<EskariakEntity> zerrenda=(List<EskariakEntity>)em.createNamedQuery("EskariakEntity.findIkastrue").setParameter("erabiltzaileIzena", erabiltzaileIzena).getResultList();
    	return zerrenda;
    }
    public List<EskariakEntity> getIkasleenEskariEzeztatuak(String erabiltzaileIzena){
    	@SuppressWarnings("unchecked")
		List<EskariakEntity> zerrenda=(List<EskariakEntity>)em.createNamedQuery("EskariakEntity.findIkasfalse").setParameter("erabiltzaileIzena", erabiltzaileIzena).getResultList();
    	return zerrenda;
    }
    public int addEskariaEntity(EskariakEntity eskaria, String erabiltzaileIzena) {
    	int kodea=0;
    	IkasleakEntity ikaslea=(IkasleakEntity)em.createNamedQuery("IkasleakEntity.findErabiltzailea").setParameter("erabiltzaileIzena", erabiltzaileIzena).getSingleResult();
    	eskaria.setIkasleak(ikaslea);
    	em.persist(eskaria);
    	kodea=6;
    	return kodea;
    }
    public int removeEskariaEntity(int idEskariak) {
    	int kodea=0;
    	EskariakEntity eskariDB=(EskariakEntity)em.find(EskariakEntity.class, idEskariak);
    	if(eskariDB!=null) {
    		em.remove(eskariDB);
    		kodea=7;
    	}
    	return kodea;
    }
    
    //LOGIN
    public int irakasleaEgiaztatu(String erabiltzaileIzena, String pasahitza) {
    	int kodea=0;
    	try {
			@SuppressWarnings("unused")
			IrakasleakEntity irakasDB=(IrakasleakEntity)em.createNamedQuery("IrakasleakEntity.findErabilPasahitz")
					.setParameter("erabiltzaileIzena", erabiltzaileIzena)
					.setParameter("pasahitza", pasahitza).getSingleResult();
			kodea=8;
		} catch (Exception e) {
			kodea=9;
		}
    	return kodea;
    }

}
