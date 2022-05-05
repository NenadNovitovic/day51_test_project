package engineering.it.web.webapp.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Proizvodjac implements Serializable {
	@Id
	private String pib;
	private String maticniBroj;
	private String adresa;
	
	@ManyToOne//(cascade = { CascadeType.MERGE,CascadeType.PERSIST })
	//@ManyToOne
	@JoinColumn(name = "mesto")
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
