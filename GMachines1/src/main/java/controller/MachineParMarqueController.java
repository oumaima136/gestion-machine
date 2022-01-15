package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import beans.Machine;
import beans.Marque;
import service.MachineService;
import service.MarqueService;

/**
 * Servlet implementation class MachineParMarqueController
 */
@WebServlet("/MachineParMarqueController")
public class MachineParMarqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MachineService ms = new MachineService();
	private MarqueService mrs = new MarqueService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MachineParMarqueController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        if (request.getParameter("op") != null) {
            if (request.getParameter("op").equals("load")) {
                response.setContentType("application/json");
                List<Machine> machines = ms.findAll();
                Gson json = new Gson();
                response.getWriter().write(json.toJson(machines));
            }
            else if(request.getParameter("op").equals("add")) {
                String Marque = request.getParameter("marque");
                Marque mar= mrs.findByLib(Marque);
                List<Machine> m = ms.findMachineParMarque(mar);
    			response.setContentType("application/json");
                Gson json = new Gson();
                response.getWriter().write(json.toJson(m));
            }
        }

  
    }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
