package engineering.it.web.webapp.actionFactory;



import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.action.home.HomeAction;
import engineering.it.web.webapp.action.login.LoginAction;
import engineering.it.web.webapp.action.mesto.AddMestoAction;
import engineering.it.web.webapp.action.proizvodjac.AddNewProizvodjacGetAction;
import engineering.it.web.webapp.action.proizvodjac.AddNewProizvodjacPostAction;
import engineering.it.web.webapp.action.proizvodjac.ProizvodjaciAction;
import engineering.it.web.webapp.constant.WebConstant;

public class ActionFactory {

	public static AbstractAction createAction(String method, String path) {
		AbstractAction action = null;
		
		System.out.println(path);
		switch(path) {
		case "/login":
			action = new LoginAction();
			break;
		case "/home":
			action = new HomeAction();
			break;
		case WebConstant.PATH_ADD_NEW_PROIZVODJAC:
			System.out.println("Method za add new proizvodjac je:" + method);
			if(method.equalsIgnoreCase("GET"))
				action = new AddNewProizvodjacGetAction();
			if(method.equalsIgnoreCase("POST"))
				action = new AddNewProizvodjacPostAction();
			break;
		case WebConstant.PATH_PROIZVODJACI:
			action = new ProizvodjaciAction();
			break;
		case WebConstant.PATH_ADD_MESTO:
			action = new AddMestoAction();
			break;
			
		default:
			break;
		}
		
		return action;
	}

}
