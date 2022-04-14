package engineering.it.web.webapp.action.login;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.User;

public class LoginAction extends AbstractAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		User user = login(request);
		if(user!=null) {
			request.setAttribute("user", user);
			return WebConstant.PAGE_HOME;
		}else {
			request.setAttribute("error_user_not_found", "User with that username/password doesn't exist.");
			return WebConstant.PAGE_INDEX;
		}
	}

	private User login(HttpServletRequest request) {
		List<User> users = new ArrayList<User>(); // pozovi userStorage i vrati listu usera
		users.add(new User("admin","admin","admin"));
		User user = null;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+ " " + password);
		for(User u : users) {
			if(u.getUsername().equals(username) && u.getPassword().equals(password)) {
				user = u;
				break;
			}
		}
		//proveri da li je user loginovan vec, appcontext pa prolaz kroz usere i samo username proveriti
		
		return user;
	}

}
