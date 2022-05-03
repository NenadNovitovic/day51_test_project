package engineering.it.web.webapp.action.proizvodjac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.service.ProizvodjacService;
import engineering.it.web.webapp.service.impl.ProizvodjacServiceImpl;

@Component
public class DeleteProizvodjacPostAction extends AbstractAction {

	@Autowired
	ProizvodjacService proizvodjacService;

	public DeleteProizvodjacPostAction() {
		super();
		//this.proizvodjacService = new ProizvodjacServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String pib = request.getParameter("pib");

		if("Delete".equals(request.getParameter("btn-action"))) {
			if (proizvodjacService.deleteProizvodjac(pib)) {
				request.setAttribute("proizvodjaci", proizvodjacService.getAll());
				request.setAttribute("error", "Uspesno obrisao proizvodjaca");
				return WebConstant.PAGE_PROIZVODJACI;
			} else {
				request.setAttribute("proizvodjaci", proizvodjacService.getAll());
				request.setAttribute("error", "Doslo je do greske prilikom brisanja proizvodjaca");
				return WebConstant.PAGE_PROIZVODJACI;
			}
		}else {
			request.setAttribute("proizvodjaci", proizvodjacService.getAll());
			request.setAttribute("error", "");
			return WebConstant.PAGE_PROIZVODJACI;
		}
		
	}

}
