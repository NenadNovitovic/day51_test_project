package engineering.it.web.webapp.actionFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.action.home.HomeAction;
import engineering.it.web.webapp.action.index.IndexAction;
import engineering.it.web.webapp.action.login.LoginAction;
import engineering.it.web.webapp.action.logout.LogoutAction;
import engineering.it.web.webapp.action.mesto.AddMestoGetAction;
import engineering.it.web.webapp.action.mesto.AddMestoPostAction;
import engineering.it.web.webapp.action.mesto.MestaAction;
import engineering.it.web.webapp.action.proizvodjac.AddNewProizvodjacGetAction;
import engineering.it.web.webapp.action.proizvodjac.AddNewProizvodjacPostAction;
import engineering.it.web.webapp.action.proizvodjac.ProizvodjaciAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.User;

public class ActionFactory {

	public static AbstractAction createAction(HttpServletRequest request) {
		AbstractAction action = null;

		String method = request.getMethod();
		String path = request.getPathInfo();
		System.out.println(method + " " + path);

		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");

		if (user != null || path.equals(WebConstant.PATH_LOGIN)) {
			switch (path) {
			case WebConstant.PATH_LOGIN:
				action = new LoginAction();
				break;
			case WebConstant.PATH_LOGOUT:
				action = new LogoutAction();
				break;
			case WebConstant.PATH_HOME:
				action = new HomeAction();
				break;
			case WebConstant.PATH_ADD_NEW_PROIZVODJAC:
				if (method.equalsIgnoreCase("GET"))
					action = new AddNewProizvodjacGetAction();
				if (method.equalsIgnoreCase("POST"))
					action = new AddNewProizvodjacPostAction();
				break;
			case WebConstant.PATH_PROIZVODJACI:
				action = new ProizvodjaciAction();
				break;
			case WebConstant.PATH_ADD_MESTO:
				if (method.equalsIgnoreCase("GET"))
					action = new AddMestoGetAction();
				if (method.equalsIgnoreCase("POST"))
					action = new AddMestoPostAction();
				break;
			case WebConstant.PATH_MESTA:
				action = new MestaAction();
			default:
				break;
			}
		}else {
			action = new IndexAction();
		}

		return action;
	}

}
