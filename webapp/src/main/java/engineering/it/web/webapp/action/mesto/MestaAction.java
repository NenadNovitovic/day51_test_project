package engineering.it.web.webapp.action.mesto;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;
import engineering.it.web.webapp.service.MestoService;
import engineering.it.web.webapp.service.impl.MestoServiceImpl;

public class MestaAction extends AbstractAction {

	private MestoService mestoService;

	public MestaAction() {
		super();
		this.mestoService = new MestoServiceImpl();
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		@SuppressWarnings("unchecked")
		List<Mesto> mesta = mestoService.getAll();
		request.setAttribute("mesta", mesta);

		return WebConstant.PAGE_MESTA;
	}

}
