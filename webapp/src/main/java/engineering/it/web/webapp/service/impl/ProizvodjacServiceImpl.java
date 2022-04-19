package engineering.it.web.webapp.service.impl;

import java.util.List;

import engineering.it.web.webapp.dao.MestoDao;
import engineering.it.web.webapp.dao.ProizvodjacDao;
import engineering.it.web.webapp.dao.impl.MestoDaoJPA;
import engineering.it.web.webapp.dao.impl.ProizvodjacDaoJPA;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.domain.Proizvodjac;
import engineering.it.web.webapp.service.MestoService;
import engineering.it.web.webapp.service.ProizvodjacService;

public class ProizvodjacServiceImpl implements ProizvodjacService {
	
	private ProizvodjacDao dao;

	
	public ProizvodjacServiceImpl() {
		super();
		this.dao = new ProizvodjacDaoJPA();
	}

	@Override
	public List<Proizvodjac> getAll() {
		return dao.getAll();
	}

	@Override
	public Proizvodjac getProizvodjac(String ptt) {
		return dao.getById(ptt);
	}

	@Override
	public boolean addProizvodjac(Proizvodjac m) {
		return dao.add(m);
	}

	@Override
	public boolean editProizvodjac(Proizvodjac m) {
		//provera da li postoji to mesto vec
		return dao.update(m);
	}

	@Override
	public boolean deleteProizvodjac(String pib) {
		// provera da li ima sta da se obrise uopste
		return dao.delete(pib);
	}

}
