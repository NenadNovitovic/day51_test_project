package engineering.it.web.webapp.action.logout;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.User;

public class LogoutAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		List<User> loggedInUsers = (List<User>)request.getServletContext().getAttribute("loggedInUsers");
		loggedInUsers.remove(user);
		HttpSession session = request.getSession(true);
		session.invalidate();
		request.setAttribute("error", "Uspesno ste se odjavili");
		return WebConstant.PAGE_INDEX;
	}

}
