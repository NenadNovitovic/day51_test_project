package engineering.it.web.webapp.action.proizvodjac;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.domain.Proizvodjac;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;

@Component
public class AddNewProizvodjacPostAction extends AbstractAction {
	String error;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (correctInput(request))
			if (updatedDatabase(request)) {

				@SuppressWarnings("unchecked")
				List<Proizvodjac> proizvodjaci = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager().createQuery("from Proizvodjac").getResultList();
				request.setAttribute("proizvodjaci", proizvodjaci);
				return WebConstant.PAGE_PROIZVODJACI;
				//return new ProizvodjaciAction().execute(request, response);
			}

		List<Mesto> mesta = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager()
				.createQuery("from Mesto", Mesto.class).getResultList();
		request.setAttribute("mesta", mesta);
		request.setAttribute("error", error);
		return WebConstant.PAGE_ADD_NEW_PROIZVODJAC;

	}

	private boolean updatedDatabase(HttpServletRequest request) {
		boolean updated = true;
		// update DB
		String pib = request.getParameter("pib");
		String maticniBroj = request.getParameter("maticniBroj");
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		Proizvodjac existingProizvodjac = em.find(Proizvodjac.class, pib);
		if(existingProizvodjac==null) {
			
			String adresa = request.getParameter("adresa");
			Long pttMesta = Long.parseLong(request.getParameter("mesto"));
			Mesto mesto = em.getReference(Mesto.class, pttMesta);
			em.flush();
			Proizvodjac newProizvodjac = new Proizvodjac(pib,maticniBroj,adresa,mesto);
			System.out.println(newProizvodjac + "pred persist");
			em.persist(newProizvodjac);
			em.getTransaction().commit();
		}else {
			error = "Postoji vec taj pib";
			updated = false;
		}
		/*try {
			
			
			Proizvodjac p = (Proizvodjac) em
					.createQuery("SELECT * FROM Proizvodjac where pib = " + pib + " OR maticniBroj=" + maticniBroj)
					.getSingleResult();
			
			
		} catch (NoResultException e) {
			updated = false;
			em.getTransaction().commit();
		}*/
		em.close();
		return updated;
	}

	private boolean correctInput(HttpServletRequest request) {
		boolean correct = true;
		try {
			Long.parseLong(request.getParameter("pib"));
			Long.parseLong(request.getParameter("maticniBroj"));
		}catch(NumberFormatException e) {
			correct= false;
			error="PIB and maticni broj can't be blank and must be numbers!";
		}
		return correct;
	}

}
