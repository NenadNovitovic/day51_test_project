package engineering.it.web.webapp.action.mesto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.service.MestoService;
import engineering.it.web.webapp.service.impl.MestoServiceImpl;

@Component
public class DeleteMestoAction extends AbstractAction {

	@Autowired
	private MestoService mestoService;

	public DeleteMestoAction() {
		super();
		//this.mestoService = new MestoServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("ptt"));
		
		
		if( mestoService.deleteMesto(id)) {
			request.setAttribute("mesta", mestoService.getAll());
			request.setAttribute("error", "Uspesno obrisao mesto");
			return WebConstant.PAGE_MESTA;
		}else {
			request.setAttribute("mesta", mestoService.getAll());
			request.setAttribute("error", "Doslo je do greske prilikom brisanja mesta");
			return WebConstant.PAGE_MESTA;
		}
		

	}

}
