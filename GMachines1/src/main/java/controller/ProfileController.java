package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.google.gson.Gson;

import beans.User;
import service.UserService;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/ProfileController")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService ms = new UserService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 			throws ServletException, IOException {
    	 String nom = request.getParameter("nom");
         String email = request.getParameter("email");
         String mdp = request.getParameter("mdp");
         String sexe = request.getParameter("sexe");
         System.out.println(request.getParameter("id"));
			int id = Integer.parseInt(request.getParameter("id"));
			
			User m = ms.findById(id);
			if (ms.findUser(email)) {
    			m.setNom(nom);
    			m.setEmail(email);
    			m.setMdp(mdp);
    			
    			if(ms.update(m)) {
    				HttpSession session = request.getSession(false);
    				if(session != null) {
    					session.setAttribute("nom", nom);
    					session.setAttribute("email", email);
    					session.setAttribute("mdp", mdp);
    					response.setContentType("application/json");
    			         List<User> users = ms.findAll();
    			         Gson json = new Gson();
    			         response.getWriter().write(json.toJson(users));
    				}
    			}
    	}
    	else {
    		response.setContentType("application/json");
    		List<User> users = ms.findAll();
		    JSONObject json = new JSONObject();
		    Gson Gson = new Gson();
		    json.put("machine",Gson.toJson(users));
		    json.put("type",0);
		    response.getWriter().print(json);
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
