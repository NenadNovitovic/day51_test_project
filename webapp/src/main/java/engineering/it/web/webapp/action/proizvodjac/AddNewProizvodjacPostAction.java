package engineering.it.web.webapp.action.proizvodjac;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;

public class AddNewProizvodjacPostAction extends AbstractAction {
	String error;
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if(correctInput(request)){
			updateDatabase(request);
			return WebConstant.PAGE_HOME;
		}else {
			List<Mesto> mesta = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager().createQuery("from Mesto", Mesto.class).getResultList();
			request.setAttribute("mesta", mesta);
			request.setAttribute("error", error);
			return WebConstant.PAGE_ADD_NEW_PROIZVODJAC;
		}
		
		
	}

	private void updateDatabase(HttpServletRequest request) {
		// update DB
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		
		
		
		em.getTransaction().commit();
		em.close();
	}

	private boolean correctInput(HttpServletRequest request) {
		boolean correct = true;
		// prazna polja
		return correct;
	}

	
	
}
