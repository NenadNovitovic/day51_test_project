package engineering.it.web.webapp.action.mesto;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;

public class AddMestoPostAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		Long ptt = Long.parseLong(request.getParameter("pttBroj"));
		String naziv = request.getParameter("naziv");
		
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		Mesto m = new Mesto(ptt,naziv);
		em.persist(m);
		System.out.println(m);
		
		em.getTransaction().commit();
		em.close();
		return WebConstant.PAGE_HOME;
	}

}
