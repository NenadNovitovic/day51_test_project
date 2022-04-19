package engineering.it.web.webapp.action.proizvodjac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Proizvodjac;
import engineering.it.web.webapp.service.ProizvodjacService;
import engineering.it.web.webapp.service.impl.ProizvodjacServiceImpl;

public class DeleteProizvodjacGetAction extends AbstractAction {

	ProizvodjacService service;
	
	public DeleteProizvodjacGetAction() {
		super();
		this.service = new ProizvodjacServiceImpl();
	}
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String pib = request.getParameter("pib");
		Proizvodjac p = service.getProizvodjac(pib);//get iz baze
		request.setAttribute("proizvodjac", p);
		return WebConstant.PAGE_CONFIRM_DELETE_PROIZVODJAC;
	}

}
