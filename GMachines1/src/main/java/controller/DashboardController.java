package controller;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import beans.Machine;
import service.MachineService;
import service.MarqueService;

/**
 * Servlet implementation class DashboardController
 */
@WebServlet("/DashboardController")
public class DashboardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MachineService ms = new MachineService();
	MarqueService mms = new MarqueService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DashboardController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	if (request.getParameter("hey") != null) {
    		if(request.getSession(false)!=null) {
    			response.sendRedirect("machines.jsp");
    		}
    		else {
    			response.sendRedirect("Login.jsp");
    		}
    		
    	}
		if (request.getParameter("id") == null) {
			if(request.getParameter("marque")== null) {
			Map<String,Integer> m = ms.findMachinesLesPlusAchete();		
			Gson json = new Gson();
			response.getWriter().write(json.toJson(m));
			}
			else {
				System.out.println("fghjkl");
				String marque = request.getParameter("marque");
				Map<Integer,Integer> mm = ms.findMachinesByMarque(mms.findByLib(marque).getId());	
				Gson json = new Gson();
				response.getWriter().write(json.toJson(mm));
			}
			
		}
		else {
			Map<String,Integer> m = ms.findVariationMarque();		
			Gson json = new Gson();
			response.getWriter().write(json.toJson(m));
		}
    }
		
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
