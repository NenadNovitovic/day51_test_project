package engineering.it.web.webapp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Proizvodjac {
	@Id
	private String pib;
	private String maticniBroj;
	private String adresa;
	@ManyToOne(cascade = { CascadeType.MERGE })
	//@ManyToOne
	@JoinColumn(name = "mesto", insertable=false, updatable=false)
	private Mesto mesto;

	public Proizvodjac() {
		super();
	}
	
	public Proizvodjac(String pib, String maticniBroj, String adresa, Mesto mesto) {
		super();
		this.pib = pib;
		this.maticniBroj = maticniBroj;
		this.adresa = adresa;
		this.mesto = mesto;
	}


	public String getPib() {
		return pib;
	}

	public void setPib(String pib) {
		this.pib = pib;
	}

	public String getMaticniBroj() {
		return maticniBroj;
	}

	public void setMaticniBroj(String maticniBroj) {
		this.maticniBroj = maticniBroj;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	@Override
	public String toString() {
		return "Proizvodjac [pib=" + pib + ", maticniBroj=" + maticniBroj + ", adresa=" + adresa
				+ ", mesto=" + mesto + "]";
	}

}
