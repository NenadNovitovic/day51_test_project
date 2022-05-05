package engineering.it.web.webapp.action.proizvodjac;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.domain.Proizvodjac;
import engineering.it.web.webapp.domain.User;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;
import engineering.it.web.webapp.service.ProizvodjacService;

@Component
public class EditProizvodjacGetAction extends AbstractAction {
	@Autowired
	ProizvodjacService service;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if("Edit".equals(request.getParameter("btn-action"))) {
			String pib = request.getParameter("pib");
			Proizvodjac p = service.getProizvodjac(pib);//get iz baze
			request.setAttribute("proizvodjac", p);
			
			List<Mesto> mesta = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager().createQuery("from Mesto", Mesto.class).getResultList();
			request.setAttribute("mesta", mesta);
			return WebConstant.PAGE_EDIT_PROIZVODJAC;
		}else {
			request.setAttribute("proizvodjaci", service.getAll());
			return WebConstant.PAGE_PROIZVODJACI;
		}

	}

}
