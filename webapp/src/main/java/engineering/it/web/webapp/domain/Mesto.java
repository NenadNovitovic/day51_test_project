package engineering.it.web.webapp.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Mesto implements Serializable {
	@Id
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
		return "Mesto [pttBroj=" + pttBroj + ", naziv=" + naziv + "]";
	}
	
	
}
