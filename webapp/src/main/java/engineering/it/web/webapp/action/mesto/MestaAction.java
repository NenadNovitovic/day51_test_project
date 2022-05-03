package engineering.it.web.webapp.action.mesto;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;
import engineering.it.web.webapp.domain.Mesto;
import engineering.it.web.webapp.persistence.MyEntityManagerFactory;
import engineering.it.web.webapp.service.MestoService;
import engineering.it.web.webapp.service.impl.MestoServiceImpl;

@Component
public class MestaAction extends AbstractAction {

	@Autowired
	private MestoService mestoService;

	public MestaAction() {
		super();
		//System.out.println("MestaAction autowired?");
		//this.mestoService = new MestoServiceImpl();
		System.out.println("MestaAction const: MestoService: " + this.mestoService);
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		@SuppressWarnings("unchecked")
		List<Mesto> mesta = mestoService.getAll();
		request.setAttribute("mesta", mesta);

		return WebConstant.PAGE_MESTA;
	}

}
