package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Klaseak database table.
 * 
 */
@Entity
@Table(name="Klaseak")
@NamedQueries({
	@NamedQuery(name="KlaseakEntity.findAll", query="SELECT k FROM KlaseakEntity k"),
	@NamedQuery(name="KlaseakEntity.findIkasgaia", query="SELECT k FROM KlaseakEntity k WHERE k.ikasgaiak.idIkasgaiak = :idIkasgaiak"),
	@NamedQuery(name="KlaseakEntity.findMaila", query="SELECT k FROM KlaseakEntity k WHERE k.mailak.idMailak = :idMailak")
})
public class KlaseakEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKlaseak;

	//uni-directional many-to-one association to IkasgaiakEntity
	@ManyToOne
	@JoinColumn(name="ikasgaia")
	private IkasgaiakEntity ikasgaiak;

	//uni-directional many-to-one association to IrakasleakEntity
	@ManyToOne
	@JoinColumn(name="irakaslea")
	private IrakasleakEntity irakasleak;

	//uni-directional many-to-one association to MailakEntity
	@ManyToOne
	@JoinColumn(name="maila")
	private MailakEntity mailak;

	//uni-directional many-to-one association to OrdutegiakEntity
	@ManyToOne
	@JoinColumn(name="ordutegia")
	private OrdutegiakEntity ordutegiak;

	public KlaseakEntity() {
	}

	public int getIdKlaseak() {
		return this.idKlaseak;
	}

	public void setIdKlaseak(int idKlaseak) {
		this.idKlaseak = idKlaseak;
	}

	public IkasgaiakEntity getIkasgaiak() {
		return this.ikasgaiak;
	}

	public void setIkasgaiak(IkasgaiakEntity ikasgaiak) {
		this.ikasgaiak = ikasgaiak;
	}

	public IrakasleakEntity getIrakasleak() {
		return this.irakasleak;
	}

	public void setIrakasleak(IrakasleakEntity irakasleak) {
		this.irakasleak = irakasleak;
	}

	public MailakEntity getMailak() {
		return this.mailak;
	}

	public void setMailak(MailakEntity mailak) {
		this.mailak = mailak;
	}

	public OrdutegiakEntity getOrdutegiak() {
		return this.ordutegiak;
	}

	public void setOrdutegiak(OrdutegiakEntity ordutegiak) {
		this.ordutegiak = ordutegiak;
	}

}