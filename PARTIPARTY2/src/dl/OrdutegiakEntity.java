package dl;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Ordutegiak database table.
 * 
 */
@Entity
@Table(name="Ordutegiak")
@NamedQuery(name="OrdutegiakEntity.findAll", query="SELECT o FROM OrdutegiakEntity o")
public class OrdutegiakEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idOrdutegia;

	private int denboratartea;

	private int eguna;

	public OrdutegiakEntity() {
	}

	public int getIdOrdutegia() {
		return this.idOrdutegia;
	}

	public void setIdOrdutegia(int idOrdutegia) {
		this.idOrdutegia = idOrdutegia;
	}

	public int getDenboratartea() {
		return this.denboratartea;
	}

	public void setDenboratartea(int denboratartea) {
		this.denboratartea = denboratartea;
	}

	public int getEguna() {
		return this.eguna;
	}

	public void setEguna(int eguna) {
		this.eguna = eguna;
	}

}