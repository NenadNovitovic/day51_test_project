package engineering.it.web.webapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import engineering.it.web.webapp.dao.MestoDao;
import engineering.it.web.webapp.dao.ProizvodjacDao;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.domain.Proizvodjac;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;

public class ProizvodjacDaoJPA implements ProizvodjacDao {

	private EntityManager em;

	public ProizvodjacDaoJPA() {
		em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Proizvodjac> getAll() {
		return em.createQuery("from Proizvodjac").getResultList();
	}

	@Override
	public Proizvodjac getById(String pib) {
		Proizvodjac m = null;

		m = em.find(Proizvodjac.class, pib);

		return m;
	}

	@Override
	public boolean add(Proizvodjac m) {
		boolean added = true;

		em.getTransaction().begin();
		em.persist(m);
		em.getTransaction().commit();
		em.close();

		return added;
	}

	@Override
	public boolean update(Proizvodjac p) {
		boolean updated = false;
		
		
		/*Proizvodjac existing = em.find(Proizvodjac.class, p.getPib()));
		if(existing!=null) {
			em.getTransaction().begin();
			existing.setNaziv(p.getNaziv());
			em.getTransaction().commit();
			updated= true;
		}*/

		return updated;
	}

	@Override
	public boolean delete(String pib) {
		boolean deleted = false;
		Proizvodjac m = em.find(Proizvodjac.class, pib);
		if(m!=null) {
			em.getTransaction().begin();
			em.remove(m);
			em.getTransaction().commit();
			deleted = true;
		}

		return deleted;
	}

}
