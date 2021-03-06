package engineering.it.web.webapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

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
		System.out.println("========= MestoDaoJPA getALL =============");
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
		boolean updated = false;
		
		
		Mesto existing = em.find(Mesto.class, m.getPttBroj());
		if(existing!=null) {
			em.getTransaction().begin();
			existing.setNaziv(m.getNaziv());
			em.getTransaction().commit();
			updated= true;
		}

		return updated;
	}

	@Override
	public boolean delete(Long ptt) {
		boolean deleted = false;
		Mesto m = em.find(Mesto.class, ptt);
		if(m!=null) {
			em.getTransaction().begin();
			em.remove(m);
			em.getTransaction().commit();
			deleted = true;
		}

		return deleted;
	}

}
