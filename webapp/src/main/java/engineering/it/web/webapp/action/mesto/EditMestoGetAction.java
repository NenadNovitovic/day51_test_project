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
public class EditMestoGetAction extends AbstractAction {

	@Autowired
	private MestoService mestoService;

	public EditMestoGetAction() {
		super();
		//this.mestoService = new MestoServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Long id = Long.parseLong(request.getParameter("pttBroj"));
		Mesto m = mestoService.getMesto(id);
		
		
		String btnAction = request.getParameter("btn-action");
		System.out.println("Btn action: " + btnAction + " CityEditAction");
		if("Edit".equals(btnAction)) {
			request.setAttribute("mesto", m);
			return WebConstant.PAGE_EDIT_MESTO;
		}else {
			request.setAttribute("mesta", mestoService.getAll());
			return WebConstant.PAGE_MESTA;
		}
		
	}
}
