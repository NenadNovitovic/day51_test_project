package engineering.it.web.webapp.action.mesto;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;

public class AddMestoAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		Mesto m = new Mesto(24000l,"Subotica");
		em.persist(m);
		System.out.println(m);
		
		em.getTransaction().commit();
		em.close();
		System.out.println("Uspesno dodao grad");
		request.setAttribute("error", "Uspesno dodao grad");
		return "/index.jsp";
	}

}
