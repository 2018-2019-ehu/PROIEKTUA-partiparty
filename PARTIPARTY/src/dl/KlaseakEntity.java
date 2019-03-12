package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Klaseak database table.
 * 
 */
@Entity
@Table(name="Klaseak")
@NamedQuery(name="KlaseakEntity.findAll", query="SELECT k FROM KlaseakEntity k")
public class KlaseakEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idKlaseak;

	//uni-directional many-to-one association to IkasgaiakEntity
	@ManyToOne
	@JoinColumn(name="Ikasgaiak_idIkasgaiak")
	private IkasgaiakEntity IkasgaiakEntity;

	//uni-directional many-to-one association to IrakasleakEntity
	@ManyToOne
	@JoinColumn(name="Irakasleak_idIrakasleak")
	private IrakasleakEntity IrakasleakEntity;

	//uni-directional many-to-one association to MailakEntity
	@ManyToOne
	@JoinColumn(name="Mailak_idMailak")
	private MailakEntity MailakEntity;

	//uni-directional many-to-one association to OrdutegiakEntity
	@ManyToOne
	@JoinColumn(name="Ordutegiak_idOrdutegia")
	private OrdutegiakEntity OrdutegiakEntity;

	public KlaseakEntity() {
	}

	public int getIdKlaseak() {
		return this.idKlaseak;
	}

	public void setIdKlaseak(int idKlaseak) {
		this.idKlaseak = idKlaseak;
	}

	public IkasgaiakEntity getIkasgaiakEntity() {
		return this.IkasgaiakEntity;
	}

	public void setIkasgaiakEntity(IkasgaiakEntity IkasgaiakEntity) {
		this.IkasgaiakEntity = IkasgaiakEntity;
	}

	public IrakasleakEntity getIrakasleakEntity() {
		return this.IrakasleakEntity;
	}

	public void setIrakasleakEntity(IrakasleakEntity IrakasleakEntity) {
		this.IrakasleakEntity = IrakasleakEntity;
	}

	public MailakEntity getMailakEntity() {
		return this.MailakEntity;
	}

	public void setMailakEntity(MailakEntity MailakEntity) {
		this.MailakEntity = MailakEntity;
	}

	public OrdutegiakEntity getOrdutegiakEntity() {
		return this.OrdutegiakEntity;
	}

	public void setOrdutegiakEntity(OrdutegiakEntity OrdutegiakEntity) {
		this.OrdutegiakEntity = OrdutegiakEntity;
	}

}