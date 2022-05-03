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
public class ViewMestoAction extends AbstractAction {

	@Autowired
	private MestoService mestoService;

	public ViewMestoAction() {
		super();
		//this.mestoService = new MestoServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("ptt"));
		
		Mesto m = mestoService.getMesto(id);
		request.setAttribute("mesto", m);
		
		return WebConstant.PAGE_VIEW_MESTO;
	}

}
