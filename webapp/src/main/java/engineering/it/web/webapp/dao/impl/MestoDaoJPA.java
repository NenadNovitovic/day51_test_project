package engineering.it.web.webapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import engineering.it.web.webapp.dao.MestoDao;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;

public class MestoDaoJPA implements MestoDao {

	private EntityManager em;
	
	public MestoDaoJPA() {
		em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Mesto> getAll() {
		return em.createQuery("from Mesto").getResultList();
	}


	@Override
	public Mesto getById(Long ptt) {
		Mesto m = null;
		
		m = em.find(Mesto.class, ptt);
		
		return m;
	}

	@Override
	public boolean add(Mesto m) {
		boolean added = true;
		
		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();
		
		return added;
	}

	@Override
	public boolean update(Mesto m) {
		boolean updated = true;
		return updated;
	}

	@Override
	public boolean delete(Long ptt) {
		boolean deleted = true;
		return deleted;
	}

}
