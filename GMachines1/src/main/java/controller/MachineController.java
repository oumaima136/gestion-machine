package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.google.gson.Gson;

import beans.Machine;
import beans.Marque;
import service.MachineService;
import service.MarqueService;

/**
 * Servlet implementation class MachineController
 */
@WebServlet("/MachineController")
public class MachineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MachineService ms = new MachineService();
	private MarqueService mrs = new MarqueService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MachineController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			if (request.getParameter("op") != null) {
				if (request.getParameter("op").equals("load")) {
					response.setContentType("application/json");
					List<Machine> machines = ms.findAll();
					Gson json = new Gson();
					response.getWriter().write(json.toJson(machines));
				} else if (request.getParameter("op").equals("loadMarque")) {
					response.setContentType("application/json");
					List<Marque> machines = mrs.findAll();
					Gson json = new Gson();
					response.getWriter().write(json.toJson(machines));
				} else if (request.getParameter("op").equals("delete")) {
					int id = Integer.parseInt(request.getParameter("id"));
					ms.delete(ms.findById(id));
					response.setContentType("application/json");
					List<Machine> machines = ms.findAll();
					Gson json = new Gson();
					response.getWriter().write(json.toJson(machines));
				}

			} else if (!request.getParameter("id").equals("")) {
			
				String reference = request.getParameter("reference");
				double prix = Double.parseDouble(request.getParameter("prix"));
				Date dateAchat = new Date(request.getParameter("dateAchat").replace("-", "/"));
				String Marque = request.getParameter("marque");
				int id = Integer.parseInt(request.getParameter("id"));
				Machine m = ms.findById(id);
				if(ms.findReferenceExceptId(reference,id)) {
					m.setReference(reference);
					m.setPrix(prix);
					m.setDateAchat(dateAchat);
					m.setMarque(mrs.findByLib(Marque));
					ms.update(m);
					response.setContentType("application/json");
					List<Machine> machines = ms.findAll();
					Gson json = new Gson();
					response.getWriter().write(json.toJson(machines));
				}else {
					response.setContentType("application/json");
	    			List<Machine> machines = ms.findAll();
				    JSONObject json = new JSONObject();
				    Gson Gson = new Gson();
				    json.put("machine",Gson.toJson(machines));
				    json.put("type",0);
				    response.getWriter().print(json);
				}
				
				
			} else {     
	            String reference = request.getParameter("reference");
	            double prix = Double.parseDouble(request.getParameter("prix"));
	            Date dateAchat = new Date(request.getParameter("dateAchat").replace("-", "/"));
	            String Marque = request.getParameter("marque");
	            if(ms.findReference(reference)) {
	            	ms.create(new Machine(reference, dateAchat, prix,mrs.findByLib(Marque)));
				    response.setContentType("application/json");
				    List<Machine> machines = ms.findAll();
				    Gson json = new Gson();
				    response.getWriter().write(json.toJson(machines));
	            }
	            else {
	            	response.setContentType("application/json");
	    			List<Machine> machines = ms.findAll();
				    JSONObject json = new JSONObject();
				    Gson Gson = new Gson();
				    json.put("machine",Gson.toJson(machines));
				    json.put("type",0);
				    response.getWriter().print(json);
	            }
		}
		}else {
			response.sendRedirect("Login.jsp");
		}


	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
