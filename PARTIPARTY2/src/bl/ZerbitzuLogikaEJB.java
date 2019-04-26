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
import dl.MailakEntity;
import dl.OrdutegiakEntity;

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
		List<IrakasleakEntity> irakasleenZerrenda=(List<IrakasleakEntity>)em.
		createNamedQuery("IrakasleakEntity.findAll").getResultList();
    	return irakasleenZerrenda;
    }
    public IrakasleakEntity getIrakasleBakarra(String erabIzena) {
    	IrakasleakEntity irakas=(IrakasleakEntity)em.
    			createNamedQuery("IrakasleakEntity.findErabiltzailea").
    			setParameter("erabiltzaileIzena", erabIzena).getSingleResult();
    	return irakas;
    }
    public int addIrakasleaEntity(IrakasleakEntity irakaslea) {
    	int kodea=0;
    	try {
			@SuppressWarnings("unused")
			IrakasleakEntity irakasDB=(IrakasleakEntity)em.
			createNamedQuery("IrakasleakEntity.findErabiltzailea").
			setParameter("erabiltzaileIzena", irakaslea.getErabiltzaileIzena()).
			getSingleResult();
			kodea=1;
		} catch (Exception e) {
			em.persist(irakaslea);
			kodea=2;
		}
    	return kodea;
    }
    public int removeIrakasleaEntity(int idIrakasleak){
    	int kodea=0;
		IrakasleakEntity irakasleDB=(IrakasleakEntity)em.find(IrakasleakEntity.class,idIrakasleak);
		@SuppressWarnings("unchecked")
		List<EskariakEntity> esk=(List<EskariakEntity>)em.createNamedQuery("EskariakEntity.findIrakaslea")
				.setParameter("erabiltzaileIzena", irakasleDB.getErabiltzaileIzena()).getResultList();
		for(int i=0;i<esk.size();i++) {
			em.remove(esk.get(i));
		}
		@SuppressWarnings("unchecked")
		List<KlaseakEntity> klaseak=(List<KlaseakEntity>)em.createNamedQuery("KlaseakEntity.findErabiltzailea")
				.setParameter("erabiltzaileIzena", irakasleDB.getErabiltzaileIzena()).getResultList();
		for(int i=0;i<klaseak.size();i++) {
			em.remove(klaseak.get(i));
		}
		if(irakasleDB!=null){
			em.remove(irakasleDB);
			kodea=3;
		}
		
		return kodea;
	}
    
    public void  irakasleDatuakAldatu(String erabiltzaileIzena, String datuak) {
    	
    	IrakasleakEntity irakasDB=(IrakasleakEntity)em.
    			createNamedQuery("IrakasleakEntity.findErabiltzailea").
    			setParameter("erabiltzaileIzena", erabiltzaileIzena).getSingleResult();
    	irakasDB.setDatuak(datuak);
    }
    public void  irakaslePasahitzaAldatu(String erabiltzaileIzena, String pasahitza) {
    	
    	IrakasleakEntity irakasDB=(IrakasleakEntity)em.
    			createNamedQuery("IrakasleakEntity.findErabiltzailea").
    			setParameter("erabiltzaileIzena", erabiltzaileIzena).getSingleResult();
    	irakasDB.setPasahitza(pasahitza);
    }
	public void  irakasleKokapenaAldatu(String erabiltzaileIzena, String kokapena) {
	
	IrakasleakEntity irakasDB=(IrakasleakEntity)em.
			createNamedQuery("IrakasleakEntity.findErabiltzailea").
			setParameter("erabiltzaileIzena", erabiltzaileIzena).getSingleResult();
	irakasDB.setKokapena(kokapena);
	}
	public void  irakasleTelefonoaAldatu(String erabiltzaileIzena, String telefonoa) {
	
	IrakasleakEntity irakasDB=(IrakasleakEntity)em.
			createNamedQuery("IrakasleakEntity.findErabiltzailea").
			setParameter("erabiltzaileIzena", erabiltzaileIzena).getSingleResult();
	irakasDB.setTelefonoZenbakia(telefonoa);
	}
    
  //IKASLEAK
    public List<IkasleakEntity> getIkasleakEntity(){
    	@SuppressWarnings("unchecked")
		List<IkasleakEntity> ikasleenZerrenda=(List<IkasleakEntity>)em.
		createNamedQuery("IkasleakEntity.findAll").getResultList();
    	return ikasleenZerrenda;
    }
    public IkasleakEntity getIkasleBakarra(String erabIzena) {
    	IkasleakEntity ikas=(IkasleakEntity)em.
    			createNamedQuery("IkasleakEntity.findErabiltzailea").
    			setParameter("erabiltzaileIzena", erabIzena).getSingleResult();
    	return ikas;
    }
    public int addIkasleaEntity(IkasleakEntity ikaslea) {
    	int kodea=0;
    	try {
			@SuppressWarnings("unused")
			IkasleakEntity ikasleDB=(IkasleakEntity)em.
			createNamedQuery("IkasleakEntity.findErabiltzailea").
			setParameter("erabiltzaileIzena", ikaslea.getErabiltzaileIzena()).getSingleResult();
			kodea=1;
		} catch (Exception e) {
			em.persist(ikaslea);
			kodea=2;
		}
    	return kodea;
    }
    public void  ikasleDatuakAldatu(String erabiltzaileIzena, String datuak) {
    	
    	IkasleakEntity ikasDB=(IkasleakEntity)em.
    			createNamedQuery("IkasleakEntity.findErabiltzailea").
    			setParameter("erabiltzaileIzena", erabiltzaileIzena).getSingleResult();
    	ikasDB.setDatuak(datuak);
    }
    public void  ikaslePasahitzaAldatu(String erabiltzaileIzena, String pasahitza) {
    	
    	IkasleakEntity ikasDB=(IkasleakEntity)em.
    			createNamedQuery("IkasleakEntity.findErabiltzailea").
    			setParameter("erabiltzaileIzena", erabiltzaileIzena).getSingleResult();
    	ikasDB.setPasahitza(pasahitza);
    }
	public void  ikasleKokapenaAldatu(String erabiltzaileIzena, String kokapena) {
	
	IkasleakEntity ikasDB=(IkasleakEntity)em.
			createNamedQuery("IkasleakEntity.findErabiltzailea").
			setParameter("erabiltzaileIzena", erabiltzaileIzena).getSingleResult();
	ikasDB.setKokapena(kokapena);
	}
	public void  ikasleTelefonoaAldatu(String erabiltzaileIzena, String telefonoa) {
	
	IkasleakEntity ikasDB=(IkasleakEntity)em.
			createNamedQuery("IkasleakEntity.findErabiltzailea").
			setParameter("erabiltzaileIzena", erabiltzaileIzena).getSingleResult();
	ikasDB.setTelefonoZenbakia(telefonoa);
	}
    
    public int removeIkasleaEntity(int idIkasleak){
    	int kodea=0;
		IkasleakEntity ikasleDB=(IkasleakEntity)em.find(IkasleakEntity.class,idIkasleak);
		@SuppressWarnings("unchecked")
		List<EskariakEntity> esk=(List<EskariakEntity>)em.createNamedQuery("EskariakEntity.findIkaslea")
				.setParameter("erabiltzaileIzena", ikasleDB.getErabiltzaileIzena()).getResultList();
		for(int i=0;i<esk.size();i++) {
			em.remove(esk.get(i));
		}
		if(ikasleDB!=null){
			em.remove(ikasleDB);
			kodea=3;
		}
		
		return kodea;
	}
    
    //IKASGAIAK
    public List<IkasgaiakEntity> getIkasgaiakEntity(){
    	@SuppressWarnings("unchecked")
		List<IkasgaiakEntity> ikasgaienZerrenda=(List<IkasgaiakEntity>)em.
		createNamedQuery("IkasgaiakEntity.findAll").getResultList();
    	return ikasgaienZerrenda;
    }
    public int addIkasgaiaEntity(IkasgaiakEntity ikasgaia) {
    	int kodea=0;
    	try {
			@SuppressWarnings("unused")
			IkasgaiakEntity ikasgaiDB=(IkasgaiakEntity)em.
			createNamedQuery("IkasgaiakEntity.findIzena").
			setParameter("izena", ikasgaia.getIzena()).getSingleResult();
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
		List<KlaseakEntity> klaseenZerrenda=(List<KlaseakEntity>)em.
		createNamedQuery("KlaseakEntity.findAll").getResultList();
    	return klaseenZerrenda;
    }
    public List<KlaseakEntity> getIrakasleBatenKlaseak(String erabiltzaileIzena){
    	@SuppressWarnings("unused")
		IrakasleakEntity irak=(IrakasleakEntity)em.
    			createNamedQuery("IrakasleakEntity.findErabiltzailea").
    			setParameter("erabiltzaileIzena", erabiltzaileIzena).getSingleResult();
    
    	@SuppressWarnings("unchecked")
		List<KlaseakEntity> klaseakDB=(List<KlaseakEntity>)em.
    			createNamedQuery("KlaseakEntity.findErabiltzailea").
    			setParameter("erabiltzaileIzena", erabiltzaileIzena).getResultList();
    	
    	return klaseakDB;
    }
   
	public List<KlaseakEntity> getKok(String kokapena){
    		
    	@SuppressWarnings("unchecked")
		List<KlaseakEntity> klase=(List<KlaseakEntity>)em.createNamedQuery("KlaseakEntity.findKok")
        			.setParameter("kokapena", kokapena).getResultList();
    	return klase;
    }
  
	public List<KlaseakEntity> getMaila(int idMaila){
    	
		@SuppressWarnings("unchecked")
		List<KlaseakEntity> klase=(List<KlaseakEntity>)em.createNamedQuery("KlaseakEntity.findMaila")
        			.setParameter("idMailak", idMaila).getResultList();
        	
    	return klase;
    }
    public List<KlaseakEntity> getIkas(int idIkasgaia){
    	
    	@SuppressWarnings("unchecked")
		List<KlaseakEntity> klase=(List<KlaseakEntity>)em.createNamedQuery("KlaseakEntity.findIkasgaia")
	    			.setParameter("idIkasgaiak", idIkasgaia).getResultList();

    	return klase;
    }
    public List<KlaseakEntity> getKokMaila(String kokapena, int idMaila){
    	
    	@SuppressWarnings("unchecked")
		List<KlaseakEntity> klase=(List<KlaseakEntity>)em.createNamedQuery("KlaseakEntity.findKokMaila")
				.setParameter("kokapena", kokapena).setParameter("idMailak", idMaila).getResultList();

    	return klase;
    }
    public List<KlaseakEntity> getKokIkas(String kokapena, int idIkasgaia){
    	
    	@SuppressWarnings("unchecked")
		List<KlaseakEntity> klase=(List<KlaseakEntity>)em.createNamedQuery("KlaseakEntity.findKokIkas")
					.setParameter("kokapena", kokapena).setParameter("idIkasgaiak", idIkasgaia).getResultList();

    	return klase;
    }
    public List<KlaseakEntity> getIkasMaila(int idIkasgaia, int idMaila){
    	
    	@SuppressWarnings("unchecked")
		List<KlaseakEntity> klase=(List<KlaseakEntity>)em.createNamedQuery("KlaseakEntity.findIkasMaila")
					.setParameter("idIkasgaiak",idIkasgaia).setParameter("idMailak", idMaila).getResultList();
		
    	return klase;
    }
    public List<KlaseakEntity> getKokIkasMaila(String kokapena, int idIkasgaia, int idMaila){
    	
    	@SuppressWarnings("unchecked")
		List<KlaseakEntity> klase=(List<KlaseakEntity>)em.createNamedQuery("KlaseakEntity.findKokIkasMaila")
					.setParameter("kokapena", kokapena).setParameter("idIkasgaiak",idIkasgaia).
					setParameter("idMailak", idMaila).getResultList();
		
    	return klase;
    }
    public int addKlaseaEntity(String erabiltzaileIzena, int idIkasgaia, int idMaila, int idOrdutegia) {
    	int kodea=0;
    	KlaseakEntity klasea=new KlaseakEntity();
		IrakasleakEntity irakaslea=(IrakasleakEntity)em.
				createNamedQuery("IrakasleakEntity.findErabiltzailea").
				setParameter("erabiltzaileIzena",erabiltzaileIzena).getSingleResult();
		IkasgaiakEntity ikas=(IkasgaiakEntity)em.find(IkasgaiakEntity.class, idIkasgaia);
		MailakEntity maila=(MailakEntity)em.find(MailakEntity.class, idMaila);
		OrdutegiakEntity ordu= (OrdutegiakEntity)em.find(OrdutegiakEntity.class, idOrdutegia);
    	klasea.setIrakasleak(irakaslea);
    	klasea.setIkasgaiak(ikas);
    	klasea.setMailak(maila);
    	klasea.setOrdutegiak(ordu);
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
    //MAILAK
    public List<MailakEntity> getMailakEntity(){
    	@SuppressWarnings("unchecked")
		List<MailakEntity> mailenZerrenda=(List<MailakEntity>)em.
		createNamedQuery("MailakEntity.findAll").getResultList();
    	return mailenZerrenda;
    }
    
    //ORDUTEGIAK
    public List<OrdutegiakEntity> getOrdutegiakEntity(){
    	@SuppressWarnings("unchecked")
		List<OrdutegiakEntity> ordutegienZerrenda=(List<OrdutegiakEntity>)em.
		createNamedQuery("OrdutegiakEntity.findAll").getResultList();
    	return ordutegienZerrenda;
    }
    
    //ESKARIAK
    public List<EskariakEntity> getEskariakEntity(){
    	@SuppressWarnings("unchecked")
		List<EskariakEntity> eskarienZerrenda=(List<EskariakEntity>)em.
		createNamedQuery("EskariakEntity.findAll").getResultList();
    	return eskarienZerrenda;
    }
    
    public List<EskariakEntity> getIrakasleenEskariOnartuak(String erabiltzaileIzena){
    	@SuppressWarnings("unchecked")
		List<EskariakEntity> zerrenda=(List<EskariakEntity>)em.
		createNamedQuery("EskariakEntity.findIrakasOnartua").
		setParameter("erabiltzaileIzena", erabiltzaileIzena).getResultList();
    	return zerrenda;
    }
    public List<EskariakEntity> getIrakasleenEskariEskatuak(String erabiltzaileIzena){
    	@SuppressWarnings("unchecked")
		List<EskariakEntity> zerrenda=(List<EskariakEntity>)em.
		createNamedQuery("EskariakEntity.findIrakasEskatua").
		setParameter("erabiltzaileIzena", erabiltzaileIzena).getResultList();
    	return zerrenda;
    }
    public List<EskariakEntity> getIkasleenEskariOnartuak(String erabiltzaileIzena){
    	@SuppressWarnings("unchecked")
		List<EskariakEntity> zerrenda=(List<EskariakEntity>)em.
		createNamedQuery("EskariakEntity.findIkasOnartua").
		setParameter("erabiltzaileIzena", erabiltzaileIzena).getResultList();
    	return zerrenda;
    }
    public List<EskariakEntity> getIkasleenEskariEskatuak(String erabiltzaileIzena){
    	@SuppressWarnings("unchecked")
		List<EskariakEntity> zerrenda=(List<EskariakEntity>)em.
		createNamedQuery("EskariakEntity.findIkasEskatua").
		setParameter("erabiltzaileIzena", erabiltzaileIzena).getResultList();
    	return zerrenda;
    }
    public int addEskariaEntity(EskariakEntity eskaria, String erabiltzaileIzena, int idKlasea) {
    	int kodea=0;
    	IkasleakEntity ikaslea=(IkasleakEntity)em.
    			createNamedQuery("IkasleakEntity.findErabiltzailea").
    			setParameter("erabiltzaileIzena", erabiltzaileIzena).getSingleResult();
    	eskaria.setIkasleak(ikaslea);
    	KlaseakEntity klasea=em.find(KlaseakEntity.class, idKlasea);
    	eskaria.setKlaseak(klasea);
    	em.persist(eskaria);
    	kodea=6;
    	return kodea;
    }
    public void eskariaOnartu(int idEskaria) {
    	EskariakEntity esk=(EskariakEntity)em.find(EskariakEntity.class, idEskaria);
    	esk.setEgoera(1);
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
			IrakasleakEntity irakasDB=(IrakasleakEntity)em.
					createNamedQuery("IrakasleakEntity.findErabilPasahitz")
					.setParameter("erabiltzaileIzena", erabiltzaileIzena)
					.setParameter("pasahitza", pasahitza).getSingleResult();
			kodea=8;
		} catch (Exception e) {
			kodea=9;
		}
    	return kodea;
    }
    public int ikasleaEgiaztatu(String erabiltzaileIzena, String pasahitza) {
    	int kodea=0;
    	try {
			@SuppressWarnings("unused")
			IkasleakEntity irakasDB=(IkasleakEntity)em.
					createNamedQuery("IkasleakEntity.findErabilPasahitz")
					.setParameter("erabiltzaileIzena", erabiltzaileIzena)
					.setParameter("pasahitza", pasahitza).getSingleResult();
			kodea=8;
		} catch (Exception e) {
			kodea=9;
		}
    	return kodea;
    }

}
