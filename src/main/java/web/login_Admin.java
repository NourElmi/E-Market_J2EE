package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import Beans.Admin;
import DAO.AdminInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class login_Admin
 */
public class login_Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOFactory daoFactory ;

	private AdminInterf AdminInterf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_Admin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.AdminInterf= daoFactory.getAdminInterf();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//1) lire les donnés saisie
				PrintWriter out = response.getWriter();
				
				String login=request.getParameter("login");
				String password=request.getParameter("password");
				
				Admin admin=new Admin();
				
				boolean flag=AdminInterf.Check_login_Admin(login, password);
				if(flag) {
					
					
					admin = AdminInterf.getAdminByLogin(login);
					 HttpSession session = request.getSession();             
					 
		             session.setAttribute("IdAdmin", admin.getIdAdmin()); 
		             session.setAttribute("NomAdmin", admin.getNomAdmin());
		             session.setAttribute("PrenomAdmin", admin.getPrenomAdmin()); 
		             session.setAttribute("Login", admin.getLogin());
		             session.setAttribute("NumTel", admin.getNumTel());
		             session.setAttribute("Adresse", admin.getAdresse()); 
		             
		             
		             response.sendRedirect("/AssociationMarket/ProfileClient" );
		  
//		 			request.getRequestDispatcher("/frontend/loginAssociation.jsp").forward(request, response);

				}
				else {
//					out.println("ohhhh nooooo");
					 response.sendRedirect("/AssociationMarket/Admin/adminLogin.jsp");
//					response.sendRedirect("/AssociationMarket/frontend/loginAssociation.jsp");
//					request.getRequestDispatcher("/frontend/loginAssociation.jsp").forward(request, response);
				}
				


	}


}
