package engineering.it.web.webapp.action.proizvodjac;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Proizvodjac;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;

@Component
public class ProizvodjaciAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		@SuppressWarnings("unchecked")
		List<Proizvodjac> proizvodjaci = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager().createQuery("from Proizvodjac").getResultList();
		request.setAttribute("proizvodjaci", proizvodjaci);
		return WebConstant.PAGE_PROIZVODJACI;
	}

}
