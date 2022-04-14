package engineering.it.web.webapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import engineering.it.web.webapp.action.AbstractAction;
import engineering.it.web.webapp.actionFactory.ActionFactory;

public class ApplicationController {
	public String processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		String path = request.getPathInfo();
		System.out.println(method + " " + path);
		AbstractAction action = ActionFactory.createAction(method,path);
		return action.execute(request, response);
	}
}
