package engineering.it.web.webapp.action.proizvodjac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Proizvodjac;
import engineering.it.web.webapp.service.ProizvodjacService;
import engineering.it.web.webapp.service.impl.ProizvodjacServiceImpl;

public class ViewProizvodjacAction extends AbstractAction {
	
	ProizvodjacService service;
	
	

	public ViewProizvodjacAction() {
		super();
		this.service = new ProizvodjacServiceImpl();
	}



	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String pib = request.getParameter("pib");
		Proizvodjac p = service.getProizvodjac(pib);
		request.setAttribute("proizvodjac", p);
		return WebConstant.PAGE_VIEW_PROIZVODJAC;
		
	}

}
