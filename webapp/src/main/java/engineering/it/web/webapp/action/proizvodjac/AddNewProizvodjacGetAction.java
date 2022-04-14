package engineering.it.web.webapp.action.proizvodjac;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.domain.User;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;

public class AddNewProizvodjacGetAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		List<Mesto> mesta = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager().createQuery("from Mesto", Mesto.class).getResultList();
		request.setAttribute("mesta", mesta);
		return WebConstant.PAGE_ADD_NEW_PROIZVODJAC;
	}

}
