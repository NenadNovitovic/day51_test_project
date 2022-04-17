package engineering.it.web.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.actionFactory.ActionFactory;

public class ApplicationController {
	public String processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbstractAction action = ActionFactory.createAction(request);
		return action.execute(request, response);
	}
}
