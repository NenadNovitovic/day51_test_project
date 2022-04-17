package engineering.it.web.webapp.dao;

import java.util.List;

import engineering.it.web.webapp.domain.Mesto;

public interface MestoDao {

	List<Mesto> getAll();
	Mesto getById(Long ptt);
	boolean add(Mesto m);
	boolean update(Mesto m);
	boolean delete(Long ptt);
}
