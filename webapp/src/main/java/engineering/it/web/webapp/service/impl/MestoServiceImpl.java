package engineering.it.web.webapp.service.impl;

import java.util.List;

import engineering.it.web.webapp.dao.MestoDao;
import engineering.it.web.webapp.dao.impl.MestoDaoJPA;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.service.MestoService;

public class MestoServiceImpl implements MestoService {
	
	private MestoDao dao;

	
	public MestoServiceImpl() {
		super();
		this.dao = new MestoDaoJPA();
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
