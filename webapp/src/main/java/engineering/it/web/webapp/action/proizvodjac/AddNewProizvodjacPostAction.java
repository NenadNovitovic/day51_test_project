package engineering.it.web.webapp.action.proizvodjac;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.domain.Proizvodjac;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;

public class AddNewProizvodjacPostAction extends AbstractAction {
	String error;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		if (correctInput(request))
			if (updatedDatabase(request))
				return WebConstant.PAGE_HOME;

		List<Mesto> mesta = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager()
				.createQuery("from Mesto", Mesto.class).getResultList();
		request.setAttribute("mesta", mesta);
		request.setAttribute("error", error);
		return WebConstant.PAGE_ADD_NEW_PROIZVODJAC;

	}

	private boolean updatedDatabase(HttpServletRequest request) {
		boolean updated = true;
		// update DB
		Long pib = Long.parseLong(request.getParameter("pib"));
		Long maticniBroj = Long.parseLong(request.getParameter("maticniBroj"));
		EntityManager em = MyEntityManagerFactory.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		List<Proizvodjac> p = em
				.createQuery("SELECT p FROM Proizvodjac p where pib = " + pib + " OR maticniBroj=" + maticniBroj).getResultList();
		if(p.isEmpty()) {
			String adresa = request.getParameter("adresa");
			Long idMesta = Long.parseLong(request.getParameter("mesto"));
			//Mesto mesto = (Mesto) em.createQuery("SELECT m FROM Mesto m where naziv like :n").setParameter("n", nazivMesta).getSingleResult();
			Mesto mesto = em.find(Mesto.class, idMesta);
			Proizvodjac newProizvodjac = new Proizvodjac(pib,maticniBroj,adresa,mesto);
			System.out.println("Stigao do ovde..");
			System.out.println(newProizvodjac);
			em.persist(newProizvodjac);
			em.getTransaction().commit();
		}else {
			error = "Postoji vec taj pib/maticni broj";
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
