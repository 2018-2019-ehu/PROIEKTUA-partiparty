package pl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import bl.ZerbitzuLogikaEJB;
import dl.IkasgaiakEntity;
import dl.MailakEntity;
import dl.OrdutegiakEntity;




@Named
@RequestScoped
public class KlaseaMB {

	
	private String irak;
	
	private int idSelectItemIkasgaia;
	private IkasgaiakEntity ikasgaia;
	
	private int idSelectItemMaila;
	private MailakEntity maila;
	
	private int idSelectItemOrdutegia;
	private OrdutegiakEntity ordutegia;
	
	@EJB
	private ZerbitzuLogikaEJB zle;
	private List<SelectItem> listSelectItemIkasgaia;
	private List<IkasgaiakEntity> listIkasgaiak;
	private List<SelectItem> listSelectItemMaila;
	private List<MailakEntity> listMailak;
	private List<SelectItem> listSelectItemOrdutegia;
	private List<OrdutegiakEntity> listOrdutegiak;
	
	public KlaseaMB() {
		
	}
	public KlaseaMB(String irak) {
		this.irak=irak;
	}
	
	@PostConstruct
	public void prestatu(){
		listIkasgaiak=zle.getIkasgaiakEntity();
		listSelectItemIkasgaia=new ArrayList<SelectItem>();
		IkasgaiakEntity klasIkas;
		for(int i=1;i<listIkasgaiak.size();i++){
			klasIkas=listIkasgaiak.get(i);
			listSelectItemIkasgaia.add(new SelectItem(i,klasIkas.getIzena()));
		}
		
		listMailak=zle.getMailakEntity();
		listSelectItemMaila=new ArrayList<SelectItem>();
		MailakEntity klasMaila;
		for(int i=1;i<listMailak.size();i++){
			klasMaila=listMailak.get(i);
			listSelectItemMaila.add(new SelectItem(i,klasMaila.getIzena()));
		}
		
		listOrdutegiak=zle.getOrdutegiakEntity();
		listSelectItemOrdutegia=new ArrayList<SelectItem>();
		OrdutegiakEntity klasOrdutegia;
		for(int i=1;i<listOrdutegiak.size();i++){
			klasOrdutegia=listOrdutegiak.get(i);
			listSelectItemOrdutegia.add(new SelectItem(i,klasOrdutegia.getIzena()));
		}
	}
	
	
	public int getIdSelectItemIkasgaia(){
		return idSelectItemIkasgaia;
	}
	public void setIdSelectItemIkasgaia(int idSelectItemIkasgaia){
		this.idSelectItemIkasgaia=idSelectItemIkasgaia;
		this.ikasgaia=listIkasgaiak.get(idSelectItemIkasgaia);
	}
	public List<SelectItem> getListSelectItemIkasgaia(){
		return listSelectItemIkasgaia;
	}
	public IkasgaiakEntity getIkasgaia(){
		return ikasgaia;
	}
	public void setIkasgaia(IkasgaiakEntity ikasgaia){
		this.ikasgaia=ikasgaia;
	}
	
	public int getIdSelectItemMaila(){
		return idSelectItemMaila;
	}
	public void setIdSelectItemMaila(int idSelectItemMaila){
		this.idSelectItemMaila=idSelectItemMaila;
		this.maila=listMailak.get(idSelectItemMaila);
	}
	public List<SelectItem> getListSelectItemMaila(){
		return listSelectItemMaila;
	}
	public MailakEntity getMaila(){
		return maila;
	}
	public void setMaila(MailakEntity maila){
		this.maila=maila;
	}
	
	public int getIdSelectItemOrdutegia(){
		return idSelectItemOrdutegia;
	}
	public void setIdSelectItemOrdutegia(int idSelectItemOrdutegia){
		this.idSelectItemOrdutegia=idSelectItemOrdutegia;
		this.ordutegia=listOrdutegiak.get(idSelectItemOrdutegia);
	}
	public List<SelectItem> getListSelectItemOrdutegia(){
		return listSelectItemOrdutegia;
	}
	public OrdutegiakEntity getOrdutegia(){
		return ordutegia;
	}
	public void setOrdutegia(OrdutegiakEntity ordutegia){
		this.ordutegia=ordutegia;
	}
	
	public String getIrak() {
		return irak;
	}
	public void setIrak(String irak) {
		this.irak=irak;
	}
}
