package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import beans.User;
import service.UserService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService ms = new UserService();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		Gson json = new Gson();
		User u = ms.authentification(email, mdp);
		PrintWriter out = response.getWriter();
		System.out.println(u);
		if (u != null) {

			HttpSession session = request.getSession();
			session.setAttribute("id", u.getId());
			session.setAttribute("nom", u.getNom());
			session.setAttribute("email", u.getEmail());
			session.setAttribute("mdp", u.getMdp());
			session.setAttribute("sexe", u.getSexe());
			session.setAttribute("type", u.isType());
			Cookie cookie = new Cookie("login", "false");
			cookie.setMaxAge(86400);
			response.addCookie(cookie);
			response.sendRedirect("DashboardController?hey=1");
		} else {

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
