package engineering.it.web.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.actionFactory.ActionFactory;

@Controller
public class ApplicationController {
	
	@Autowired
	private ActionFactory actionFactory;
	
	public ApplicationController() {
		System.out.println("ApplicationController const");

		System.out.println("ApplicationController ActionFactory: " + actionFactory);
	}
	
	public String processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//AbstractAction action = ActionFactory.createAction(request);
		AbstractAction action = actionFactory.createAction(request);
		return action.execute(request, response);
	}
}
