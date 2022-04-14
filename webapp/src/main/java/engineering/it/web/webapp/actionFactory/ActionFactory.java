package engineering.it.web.webapp.actionFactory;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.action.home.HomeAction;
import engineering.it.web.webapp.action.login.LoginAction;

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
		default:
			break;
		}
		
		return action;
	}

}
