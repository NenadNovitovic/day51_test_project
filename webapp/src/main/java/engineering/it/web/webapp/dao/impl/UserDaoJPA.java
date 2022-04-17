package engineering.it.web.webapp.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;

import engineering.it.web.webapp.dao.UserDao;
import engineering.it.web.webapp.domain.User;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;

public class UserDaoJPA implements UserDao {

	private EntityManager em;
	
	public UserDaoJPA() {
		em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAll() {
		return em.createQuery("from User").getResultList();
	}

	@Override
	public User getById(Long id) {
		User u = null;
		
		u = em.find(User.class, id);
		
		return u;
	}

	@Override
	public boolean add(User u) {
		boolean added = true;
		
		
		
		return added;
	}

	@Override
	public boolean update(User u) {
		boolean updated = true;
		return updated;
	}

	@Override
	public boolean delete(Long id) {
		boolean deleted = true;
		return deleted;
	}

}
