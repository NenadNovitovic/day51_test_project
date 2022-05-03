package engineering.it.web.webapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import engineering.it.web.webapp.dao.MestoDao;
import engineering.it.web.webapp.dao.impl.MestoDaoJPA;
import engineering.it.web.webapp.dao.impl.MestoDaoSpringJDBC;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.service.MestoService;

@Service
public class MestoServiceImpl implements MestoService {
	
	@Autowired
	private MestoDao dao;

	
	public MestoServiceImpl() {
		super();
		//this.dao = new MestoDaoJPA();

		System.out.println("MestoServiceImpl const, init novog ProizvodjacDaoJPA");
		//this.dao = new MestoDaoSpringJDBC();
		System.out.println("MestoServiceImpl : MestoDao : " + this.dao);
	}

	@Override
	public List<Mesto> getAll() {
		return dao.getAll();
	}

	@Override
	public Mesto getMesto(Long ptt) {
		return dao.getById(ptt);
	}

	@Override
	public boolean addMesto(Mesto m) {
		return dao.add(m);
	}

	@Override
	public boolean editMesto(Mesto m) {
		//provera da li postoji to mesto vec
		return dao.update(m);
	}

	@Override
	public boolean deleteMesto(Long ptt) {
		// provera da li ima sta da se obrise uopste
		return dao.delete(ptt);
	}

}
