package engineering.it.web.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;


public abstract class AbstractAction {
	public abstract String execute(HttpServletRequest request, HttpServletResponse response);
}
