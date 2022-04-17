package engineering.it.web.webapp.service;

import java.util.List;

import engineering.it.web.webapp.domain.Mesto;

public interface MestoService {
	public List<Mesto> getAll();
	public Mesto getMesto(Long ptt);
	public boolean addMesto(Mesto m);
	public boolean editMesto(Mesto m);
	public boolean deleteMesto(Long ptt);
}
