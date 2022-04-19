package engineering.it.web.webapp.service;

import java.util.List;

import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.domain.Proizvodjac;

public interface ProizvodjacService {
	public List<Proizvodjac> getAll();
	public Proizvodjac getProizvodjac(String pib);
	public boolean addProizvodjac(Proizvodjac m);
	public boolean editProizvodjac(Proizvodjac m);
	public boolean deleteProizvodjac(String ptt);
}
