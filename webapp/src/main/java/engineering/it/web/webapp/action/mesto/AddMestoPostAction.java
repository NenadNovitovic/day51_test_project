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
		
		try {
			Long ptt = Long.parseLong(request.getParameter("pttBroj"));
			String naziv = request.getParameter("naziv");
			
			EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
			
			
			Mesto existingMesto = em.find(Mesto.class, ptt);
			System.out.println("Existing mesto: " + existingMesto);
			if(existingMesto==null) {
				em.getTransaction().begin();
				Mesto m = new Mesto(ptt,naziv);
				System.out.println("novo Mesto: " + m);
				em.persist(m);
				System.out.println(m);
				em.getTransaction().commit();
				em.close();
				return WebConstant.PAGE_HOME;
			}else {
				request.setAttribute("error", "Mesto sa tim PTT vec postoji!");
				return WebConstant.PAGE_ADD_MESTO;
			}
		}catch(NumberFormatException e) {
			request.setAttribute("error", "PTT mora biti broj!");
			return WebConstant.PAGE_ADD_MESTO;
		}
		

	}

}
