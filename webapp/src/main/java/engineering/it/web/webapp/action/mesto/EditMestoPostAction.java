package engineering.it.web.webapp.action.mesto;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.service.MestoService;
import engineering.it.web.webapp.service.impl.MestoServiceImpl;

public class EditMestoPostAction extends AbstractAction {

	private MestoService mestoService;

	public EditMestoPostAction() {
		super();
		this.mestoService = new MestoServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String btn = request.getParameter("btn-action");

		System.out.println(btn);
		if("Edit".equals(btn)) {
			String naziv = request.getParameter("naziv");
			Long id = Long.parseLong(request.getParameter("pttBroj"));
			Mesto m = mestoService.getMesto(id);
			m.setNaziv(naziv);
			if (mestoService.editMesto(m)) {
				request.setAttribute("mesta", mestoService.getAll());
				request.setAttribute("error", "Mesto je izmenjeno");
				return WebConstant.PAGE_MESTA;
			} else {
				request.setAttribute("mesto", m);
				request.setAttribute("error", "Doslo je do greske");
				return WebConstant.PAGE_EDIT_MESTO;
			}
		}else {
			request.setAttribute("mesta", mestoService.getAll());
			return WebConstant.PAGE_MESTA;
		}
		

	}
}
