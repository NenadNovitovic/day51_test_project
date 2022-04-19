package engineering.it.web.webapp.constant;

public interface WebConstant {
	
	public final String PAGE_INDEX = "/index.jsp";
	
	public final String PATH_LOGIN = "/login";
	public final String PATH_LOGOUT = "/logout";

	public final String PATH_HOME = "/home";
	public final String PAGE_HOME = "/WEB-INF/pages/home.jsp";

	public final String PATH_ADD_NEW_PROIZVODJAC = "/proizvodjac/add";
	public final String PAGE_ADD_NEW_PROIZVODJAC = "/WEB-INF/pages/proizvodjac/add_new_proizvodjac.jsp";

	public final String PATH_PROIZVODJACI = "/proizvodjac/proizvodjaci";
	public final String PAGE_PROIZVODJACI = "/WEB-INF/pages/proizvodjac/proizvodjaci.jsp";

	public final String PATH_ADD_MESTO = "/mesto/add";
	public final String PAGE_ADD_MESTO = "/WEB-INF/pages/mesto/add_mesto.jsp";

	public final String PATH_MESTA = "/mesto/mesta";
	public final String PAGE_MESTA = "/WEB-INF/pages/mesto/mesta.jsp";

	public final String PATH_VIEW_MESTO = "/mesto";
	public final String PAGE_VIEW_MESTO = "/WEB-INF/pages/mesto/view_mesto.jsp";

	public final String PATH_DELETE_MESTO = "/mesto/delete";

	public final String PATH_EDIT_MESTO = "/mesto/edit";
	public final String PAGE_EDIT_MESTO = "/WEB-INF/pages/mesto/edit_mesto.jsp";
/////webapp/application/mesto/delete?pib=${proizvodjac.pib}
	
	public final String PATH_DELETE_PROIZVODJAC = "/proizvodjac/delete";
	public final String PAGE_CONFIRM_DELETE_PROIZVODJAC = "/WEB-INF/pages/proizvodjac/confirm_delete_proizvodjac.jsp";




}
