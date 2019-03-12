package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Eskariak database table.
 * 
 */
@Entity
@Table(name="Eskariak")
@NamedQuery(name="EskariakEntity.findAll", query="SELECT e FROM EskariakEntity e")
public class EskariakEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEskariak;

	//uni-directional many-to-one association to IkasleakEntity
	@ManyToOne
	@JoinColumn(name="Ikasleak_idIkasleak")
	private IkasleakEntity IkasleakEntity;

	//uni-directional many-to-one association to KlaseakEntity
	@ManyToOne
	@JoinColumn(name="Klaseak_idKlaseak")
	private KlaseakEntity KlaseakEntity;

	public EskariakEntity() {
	}

	public int getIdEskariak() {
		return this.idEskariak;
	}

	public void setIdEskariak(int idEskariak) {
		this.idEskariak = idEskariak;
	}

	public IkasleakEntity getIkasleakEntity() {
		return this.IkasleakEntity;
	}

	public void setIkasleakEntity(IkasleakEntity IkasleakEntity) {
		this.IkasleakEntity = IkasleakEntity;
	}

	public KlaseakEntity getKlaseakEntity() {
		return this.KlaseakEntity;
	}

	public void setKlaseakEntity(KlaseakEntity KlaseakEntity) {
		this.KlaseakEntity = KlaseakEntity;
	}

}