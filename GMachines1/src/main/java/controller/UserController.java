package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;

import beans.Machine;
import beans.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import service.UserService;

/**
 *
 *
 */
@WebServlet(urlPatterns = { "/UserController" })
public class UserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService ms = new UserService();

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("op") != null) {
			if (request.getParameter("op").equals("register")) {
				String nom = request.getParameter("nom");
				String email = request.getParameter("email");
				String mdp = request.getParameter("mdp");
				String sexe = request.getParameter("sexe");

				if (ms.findUser(email)) {
				if (ms.create(new User(nom, email, mdp, sexe, false))) {

					response.setContentType("application/json");
					Gson json = new Gson();
					
					response.getWriter().write(json.toJson(0));
				} else {
					Gson json = new Gson();
					
					response.getWriter().write(json.toJson(1));
				}
			}
				else {
					Gson json = new Gson();
					
					response.getWriter().write(json.toJson(2));
				}

			} else if (request.getParameter("op").equals("load")) {
				int id = Integer.parseInt(request.getParameter("idU"));
				response.setContentType("application/json");
				List<User> users = ms.findAllExepect(id);
				Gson json = new Gson();
				response.getWriter().write(json.toJson(users));
			} else if (request.getParameter("op").equals("delete")) {
				int id = Integer.parseInt(request.getParameter("id"));
				ms.delete(ms.findById(id));
				response.setContentType("application/json");
				List<User> users = ms.findAll();
				Gson json = new Gson();
				response.getWriter().write(json.toJson(users));
			} else if (request.getParameter("op").equals("update")) {
				int id = Integer.parseInt(request.getParameter("id"));
				User m = ms.findById(id);
				response.sendRedirect("GestionUtilisateur.jsp?id=" + m.getId() + "&nom=" + m.getNom() + "&email="
						+ m.getEmail() + "&mdp=" + m.getMdp() + "&sexe=" + m.getSexe() + "&superAdmin=" + m.isType());
			}

		} else if (!request.getParameter("id").equals("")) {
			String nom = request.getParameter("nom");
			String email = request.getParameter("email");
			String mdp = request.getParameter("mdp");
			String sexe = request.getParameter("sexe");
			System.out.println(request.getParameter("id"));
			int id = Integer.parseInt(request.getParameter("id"));

			boolean superAdmin;
			if (request.getParameter("superAdmin") == null) {
				superAdmin = false;
			} else {
				superAdmin = Boolean.parseBoolean(request.getParameter("superAdmin"));
			}
			User m = ms.findById(id);
			if(ms.findEmailExceptId(email,id)) {
			m.setNom(nom);
			m.setEmail(email);
			m.setMdp(mdp);
			m.setSexe(sexe);
			m.setType(superAdmin);
			ms.update(m);
			response.setContentType("application/json");
        	int idU = Integer.parseInt(request.getParameter("idU"));
            List<User> users = ms.findAllExepect(idU);
		    Gson Gson = new Gson();
		    response.getWriter().print(Gson.toJson(users));
			
		}else {
			response.setContentType("application/json");
        	int idU = Integer.parseInt(request.getParameter("idU"));
            List<User> users = ms.findAllExepect(idU);
		    JSONObject json = new JSONObject();
		    Gson Gson = new Gson();
		    json.put("machine",Gson.toJson(users));
		    json.put("type",0);
		    response.getWriter().print(json);
		}
		} else {
			String nom = request.getParameter("nom");
			String email = request.getParameter("email");
			String mdp = request.getParameter("mdp");
			String sexe = request.getParameter("sexe");
			boolean superAdmin = Boolean.parseBoolean(request.getParameter("superAdmin"));
			if (nom == "" || email == "" || mdp == "" || sexe == "") {

			} else if (ms.findUser(email)) {
				ms.create(new User(nom, email, mdp, sexe, superAdmin));
				response.setContentType("application/json");
				int id = Integer.parseInt(request.getParameter("idU"));
				List<User> users = ms.findAllExepect(id);
				Gson json = new Gson();
				response.getWriter().write(json.toJson(users));
			} else {
				response.setContentType("application/json");
				int id = Integer.parseInt(request.getParameter("idU"));
				List<User> users = ms.findAllExepect(id);
				JSONObject json = new JSONObject();
				Gson Gson = new Gson();
				json.put("machine", Gson.toJson(users));
				json.put("type", 0);
				response.getWriter().print(json);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}