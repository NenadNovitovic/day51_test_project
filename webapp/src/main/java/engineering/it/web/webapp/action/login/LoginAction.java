package engineering.it.web.webapp.action.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.User;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;

public class LoginAction extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		User user = login(request);
		if(user!=null) {
			if(!alreadyLoggedIn(user,request)) {
				@SuppressWarnings("unchecked")
				List<User> loggedInUsers = (List<User>)request.getServletContext().getAttribute("loggedInUsers");
				loggedInUsers.add(user);
				request.setAttribute("user", user);
				return WebConstant.PAGE_HOME;
			}else {
				request.setAttribute("error", "User with that username is already logged in!");
				return WebConstant.PAGE_INDEX;
			}
		}else {
			request.setAttribute("error", "User with that username/password doesn't exist.");
			return WebConstant.PAGE_INDEX;
		}
	}

	private User login(HttpServletRequest request) {
		List<User> users = new ArrayList<User>(); 
		users = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager().createQuery("from User", User.class).getResultList();
		User user = null;
		System.out.println(users);
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+ " " + password);
		
		for(User u : users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				user=u;
				break;
			}
		}
		
		return user;
	}
	
	private boolean alreadyLoggedIn(User user,HttpServletRequest req) {
		boolean loggedIn = false;
		@SuppressWarnings("unchecked")
		List<User> loggedInUsers = (List<User>)req.getServletContext().getAttribute("loggedInUsers");
		
		for(User u : loggedInUsers) {
			if(u.getUsername().equals(user.getUsername()))
				loggedIn=true;
		}
		return loggedIn;
	}

}
