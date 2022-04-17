package engineering.it.web.webapp.dao;

import java.util.List;

import engineering.it.web.webapp.domain.User;

public interface UserDao {
	List<User> getAll();
	User getById(Long id);
	boolean add(User u);
	boolean update(User u);
	boolean delete(Long id);
}
