package engineering.it.web.webapp.action.proizvodjac;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.domain.Proizvodjac;
import engineering.it.web.webapp.service.MestoService;
import engineering.it.web.webapp.service.ProizvodjacService;

@Component
public class EditProizvodjacPostAction extends AbstractAction {
	
	@Autowired
	private ProizvodjacService proizvodjacService;
	@Autowired
	private MestoService mestoService;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String pib = request.getParameter("pib");
		
		String btnAction = request.getParameter("btn-action");
		if("Edit".equals(btnAction)) {
			
			Proizvodjac proizvodjac = proizvodjacService.getProizvodjac(pib);
			System.out.println("============ EditProizvodjacPostAction execute: proizvodjac: "+proizvodjac);
			proizvodjac.setAdresa(request.getParameter("adresa"));
			proizvodjac.setMesto(mestoService.getMesto(Long.parseLong(request.getParameter("mesto"))));
			System.out.println("============ EditProizvodjacPostAction execute: proizvodjac AFTER EDITS: "+proizvodjac);
			if(proizvodjacService.editProizvodjac(proizvodjac)) {
				request.setAttribute("proizvodjaci", proizvodjacService.getAll());
				request.setAttribute("error", "Proizvodjac sa PIB: " + pib + " uspesno izmenjen!");
				return WebConstant.PAGE_PROIZVODJACI;
			}else {
				request.setAttribute("proizvodjac", proizvodjac);
				request.setAttribute("error", "Doslo je do greske pri izmeni proizvodjaca");
				return WebConstant.PAGE_EDIT_PROIZVODJAC;
			}
			
		}else {
			request.setAttribute("proizvodjaci", proizvodjacService.getAll());
			return WebConstant.PAGE_PROIZVODJACI;
		}
		
	}

}
