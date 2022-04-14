package engineering.it.web.webapp.domain;

public class Proizvodjac {
	private Long id;
	private Long pib;
	private Long maticniBroj;
	private String adresa;
	private Mesto mesto;

	public Proizvodjac() {
		super();
	}

	public Proizvodjac(Long id, Long pib, Long maticniBroj, String adresa, Mesto mesto) {
		super();
		this.id = id;
		this.pib = pib;
		this.maticniBroj = maticniBroj;
		this.adresa = adresa;
		this.mesto = mesto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPib() {
		return pib;
	}

	public void setPib(Long pib) {
		this.pib = pib;
	}

	public Long getMaticniBroj() {
		return maticniBroj;
	}

	public void setMaticniBroj(Long maticniBroj) {
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
		return "Proizvodjac [id=" + id + ", pib=" + pib + ", maticniBroj=" + maticniBroj + ", adresa=" + adresa
				+ ", mesto=" + mesto + "]";
	}

}