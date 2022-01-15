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
import service.MachineService;
import service.MarqueService;

/**
 * Servlet implementation class machineAcheterController
 */
@WebServlet("/machineAcheterController")
public class machineAcheterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MachineService ms = new MachineService();
	MarqueService mms = new MarqueService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public machineAcheterController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("op") != null) {

		} else {
			Date date1 = new Date(request.getParameter("date1").replace("-", "/"));
			Date date2 = new Date(request.getParameter("date2").replace("-", "/"));
			response.setContentType("application/json");
			System.out.println(ms.findMachineBetweenTwoDates(date1, date2));
			List<Machine> machines = ms.findMachineBetweenTwoDates(date1, date2);
			Gson json = new Gson();
			response.getWriter().write(json.toJson(machines));
			
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
