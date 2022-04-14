package engineering.it.web.webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mesto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long pttBroj;
	private String naziv;
	
	public Mesto() {
		super();
	}
	
	public Mesto(Long pttBroj, String naziv) {
		super();
		this.pttBroj = pttBroj;
		this.naziv = naziv;
	}

	public Mesto(Long id, Long pttBroj, String naziv) {
		super();
		this.id = id;
		this.pttBroj = pttBroj;
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPttBroj() {
		return pttBroj;
	}

	public void setPttBroj(Long pttBroj) {
		this.pttBroj = pttBroj;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Mesto [id=" + id + ", pttBroj=" + pttBroj + ", naziv=" + naziv + "]";
	}
	
	
}
