package engineering.it.web.webapp.action.mesto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.service.MestoService;
import engineering.it.web.webapp.service.impl.MestoServiceImpl;

public class ViewMestoAction extends AbstractAction {

	private MestoService mestoService;

	public ViewMestoAction() {
		super();
		this.mestoService = new MestoServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("ptt"));
		
		Mesto m = mestoService.getMesto(id);
		request.setAttribute("mesto", m);
		
		return WebConstant.PAGE_VIEW_MESTO;
	}

}
