package engineering.it.web.webapp.dao;

import java.util.List;

import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.domain.Proizvodjac;

public interface ProizvodjacDao {

	List<Proizvodjac> getAll();
	Proizvodjac getById(String ptt);
	boolean add(Proizvodjac m);
	boolean update(Proizvodjac m);
	boolean delete(String pib);
}
