package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.google.gson.Gson;

import beans.Machine;
import beans.Marque;
import service.MarqueService;

/**
 * Servlet implementation class MarqueController
 */
@WebServlet("/MarqueController")
public class MarqueController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MarqueService ms = new MarqueService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MarqueController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("load")) {
				response.setContentType("application/json");
				List<Marque> machines = ms.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(machines));
			} else if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				ms.delete(ms.findById(id));
				response.setContentType("application/json");
				List<Marque> machines = ms.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(machines));
			} else if (request.getParameter("op").equals("update")) {

				int id = Integer.parseInt(request.getParameter("id"));
				Marque m = ms.findById(id);
				response.sendRedirect(
						"gestion_marque.jsp?id=" + m.getId() + "&code=" + m.getCode() + "&libelle=" + m.getLibelle());
			}

		} else if (!request.getParameter("id").equals("")) {
			String code = request.getParameter("code");
			String libelle = request.getParameter("libelle");
			int id = Integer.parseInt(request.getParameter("id"));
			Marque m = ms.findById(id);
			if (ms.findCodeExceptId(code, id)) {
				m.setCode(code);
				m.setLibelle(libelle);
				ms.update(m);
				response.setContentType("application/json");
				List<Marque> machines = ms.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(machines));

			} else {
				response.setContentType("application/json");
				List<Marque> machines = ms.findAll();
				JSONObject json = new JSONObject();
				Gson Gson = new Gson();
				json.put("machine", Gson.toJson(machines));
				json.put("type", 0);
				response.getWriter().print(json);
			}
		}

		else {

			String code = request.getParameter("code");
			String libelle = request.getParameter("libelle");
			if (code == "" || libelle == "") {
			} else if (ms.findMarque(code)) {
				ms.create(new Marque(code, libelle));
				response.setContentType("application/json");
				List<Marque> marques = ms.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(marques));
			} else {
				response.setContentType("application/json");
				List<Marque> marques = ms.findAll();
				JSONObject json = new JSONObject();
				Gson Gson = new Gson();
				json.put("machine", Gson.toJson(marques));
				json.put("type", 0);
				response.getWriter().print(json);
			}
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
