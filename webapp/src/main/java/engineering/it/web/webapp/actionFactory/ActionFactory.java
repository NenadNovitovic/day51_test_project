package engineering.it.web.webapp.actionFactory;



import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.action.home.HomeAction;
import engineering.it.web.webapp.action.login.LoginAction;
import engineering.it.web.webapp.action.logout.LogoutAction;
import engineering.it.web.webapp.action.mesto.AddMestoGetAction;
import engineering.it.web.webapp.action.mesto.AddMestoPostAction;
import engineering.it.web.webapp.action.mesto.MestaAction;
import engineering.it.web.webapp.action.proizvodjac.AddNewProizvodjacGetAction;
import engineering.it.web.webapp.action.proizvodjac.AddNewProizvodjacPostAction;
import engineering.it.web.webapp.action.proizvodjac.ProizvodjaciAction;
import engineering.it.web.webapp.constant.WebConstant;

public class ActionFactory {

	public static AbstractAction createAction(String method, String path) {
		AbstractAction action = null;
		
		System.out.println(path);
		switch(path) {
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
			if(method.equalsIgnoreCase("GET"))
				action = new AddNewProizvodjacGetAction();
			if(method.equalsIgnoreCase("POST"))
				action = new AddNewProizvodjacPostAction();
			break;
		case WebConstant.PATH_PROIZVODJACI:
			action = new ProizvodjaciAction();
			break;
		case WebConstant.PATH_ADD_MESTO:
			if(method.equalsIgnoreCase("GET"))
				action = new AddMestoGetAction();
			if(method.equalsIgnoreCase("POST"))
				action = new AddMestoPostAction();
			break;
		case WebConstant.PATH_MESTA:
			action = new MestaAction();
		default:
			break;
		}
		
		return action;
	}

}
