package engineering.it.web.webapp.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import engineering.it.web.webapp.controller.ApplicationController;


@Component
public class FrontControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ApplicationController applicationController;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontControllerServlet() {
		super();
		System.out.println("FrontControllerServlet const");
		System.out.println("FrontControllerServlet ApplicationController: " + applicationController);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = applicationController.processRequest(request, response);
		request.getRequestDispatcher(page).forward(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("Created ApplicationController!");
		
		ApplicationContext appContext = (ApplicationContext) config.getServletContext().getAttribute("app-context");
		AutowireCapableBeanFactory acbf = appContext.getAutowireCapableBeanFactory();
		acbf.autowireBean(this);
		System.out.println("AppControler: " + applicationController);
		//applicationController = new ApplicationController();
	}
}
