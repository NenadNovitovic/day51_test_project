package engineering.it.web.webapp.actionFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.action.home.HomeAction;
import engineering.it.web.webapp.action.index.IndexAction;
import engineering.it.web.webapp.action.login.LoginAction;
import engineering.it.web.webapp.action.logout.LogoutAction;
import engineering.it.web.webapp.action.mesto.AddMestoGetAction;
import engineering.it.web.webapp.action.mesto.AddMestoPostAction;
import engineering.it.web.webapp.action.mesto.DeleteMestoAction;
import engineering.it.web.webapp.action.mesto.EditMestoGetAction;
import engineering.it.web.webapp.action.mesto.EditMestoPostAction;
import engineering.it.web.webapp.action.mesto.MestaAction;
import engineering.it.web.webapp.action.mesto.ViewMestoAction;
import engineering.it.web.webapp.action.proizvodjac.AddNewProizvodjacGetAction;
import engineering.it.web.webapp.action.proizvodjac.AddNewProizvodjacPostAction;
import engineering.it.web.webapp.action.proizvodjac.DeleteProizvodjacGetAction;
import engineering.it.web.webapp.action.proizvodjac.DeleteProizvodjacPostAction;
import engineering.it.web.webapp.action.proizvodjac.EditProizvodjacGetAction;
import engineering.it.web.webapp.action.proizvodjac.EditProizvodjacPostAction;
import engineering.it.web.webapp.action.proizvodjac.ProizvodjaciAction;
import engineering.it.web.webapp.action.proizvodjac.ViewProizvodjacAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.User;

@Component
public class ActionFactory {
	
	@Autowired
	private MestaAction mestaAction;
	@Autowired
	private LoginAction loginAction;
	@Autowired
	private LogoutAction logoutAction;
	@Autowired
	private HomeAction homeAction;
	@Autowired
	private AddNewProizvodjacGetAction addNewProizvodjacGetAction;
	@Autowired
	private AddNewProizvodjacPostAction addNewProizvodjacPostAction;
	@Autowired
	private ProizvodjaciAction proizvodjaciAction;
	@Autowired
	private AddMestoGetAction addMestoGetAction;
	@Autowired
	private AddMestoPostAction addMestoPostAction;
	@Autowired
	private ViewMestoAction viewMestoAction;
	@Autowired
	private DeleteMestoAction deleteMestoAction;
	@Autowired
	private EditMestoGetAction editMestoGetAction;
	@Autowired
	private EditMestoPostAction editMestoPostAction;
	@Autowired
	private DeleteProizvodjacGetAction deleteProizvodjacGetAction;
	@Autowired
	private DeleteProizvodjacPostAction deleteProizvodjacPostAction;
	@Autowired
	private ViewProizvodjacAction viewProizvodjacAction;
	@Autowired
	private EditProizvodjacGetAction editProizvodjacGetAction;
	@Autowired
	private EditProizvodjacPostAction editProizvodjacPostAction;
	
	public ActionFactory() {
		System.out.println("ActionFactory conts : MestaAction: " +mestaAction);
	}

	public  AbstractAction createAction(HttpServletRequest request) {
		AbstractAction action = null;

		String method = request.getMethod();
		String path = request.getPathInfo();
		System.out.println(method + " " + path);

		HttpSession session = request.getSession(true);
		User user = (User) session.getAttribute("user");

		if (user != null || path.equals(WebConstant.PATH_LOGIN)) {
			switch (path) {
			case WebConstant.PATH_LOGIN:
				action = loginAction;
				break;
			case WebConstant.PATH_LOGOUT:
				action = logoutAction;
				break;
			case WebConstant.PATH_HOME:
				action = homeAction;
				break;
			case WebConstant.PATH_ADD_NEW_PROIZVODJAC:
				if (method.equalsIgnoreCase("GET"))
					action = addNewProizvodjacGetAction;
				if (method.equalsIgnoreCase("POST"))
					action = addNewProizvodjacPostAction;
				break;
			case WebConstant.PATH_PROIZVODJACI:
				action = proizvodjaciAction;
				break;
			case WebConstant.PATH_ADD_MESTO:
				if (method.equalsIgnoreCase("GET"))
					action = addMestoGetAction;
				if (method.equalsIgnoreCase("POST"))
					action = addMestoPostAction;
				break;
			case WebConstant.PATH_MESTA:
				//action = new MestaAction();
				action = mestaAction;
				break;
			case WebConstant.PATH_VIEW_MESTO:
				action = viewMestoAction;
				break;
			case WebConstant.PATH_DELETE_MESTO:
				action = deleteMestoAction;
				break;
			case WebConstant.PATH_EDIT_MESTO:
				if(method.equalsIgnoreCase("GET"))
					action = editMestoGetAction;
				if(method.equalsIgnoreCase("POST"))
					action = editMestoPostAction;
				break;
			case WebConstant.PATH_DELETE_PROIZVODJAC:
				if(method.equalsIgnoreCase("GET"))
					action = deleteProizvodjacGetAction;
				if(method.equalsIgnoreCase("POST"))
					action = deleteProizvodjacPostAction;
				break;
			case WebConstant.PATH_VIEW_PROIZVODJAC:
				action = viewProizvodjacAction;
				break;
			case WebConstant.PATH_EDIT_PROIZVODJAC:
				if(method.equalsIgnoreCase("GET"))
					action = editProizvodjacGetAction;
				if(method.equalsIgnoreCase("POST"))
					action = editProizvodjacPostAction;
				break;
			default:
				break;
			}
		}else {
			action = new IndexAction();
		}

		return action;
	}

}
