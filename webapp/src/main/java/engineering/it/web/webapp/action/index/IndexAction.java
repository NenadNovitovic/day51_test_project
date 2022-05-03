package engineering.it.web.webapp.action.index;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.constant.WebConstant;

@Component
public class IndexAction extends AbstractAction {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("error", "Morate biti ulogovani da biste videli tu stranicu!");
		return WebConstant.PAGE_INDEX;
	}

}
