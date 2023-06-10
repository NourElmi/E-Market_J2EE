package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import Beans.Client;
import DAO.ClientInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class client_Login
 */
public class client_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	
    private DAOFactory daoFactory ;
	private ClientInterf ClientInterf;
	
    public client_Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.ClientInterf= daoFactory.getClientInterf();
    }
	
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
//		request.getRequestDispatcher("./Client/login_Client.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//1) lire les donnés saisie
		PrintWriter out = response.getWriter();
		
		String login=request.getParameter("login");
		String password=request.getParameter("password");

		out.println("clientt   "+login+"    "+ password);
		Client Client=new Client();
		
		boolean flag=ClientInterf.Check_login_Client(login, password);
		if(flag) {
			
			
			 Client = ClientInterf.getClientByEmail(login);
			 HttpSession session = request.getSession();             
			 
             session.setAttribute("IdClient", Client.getIdClient()); 
             session.setAttribute("NomClient", Client.getNomClient());
             session.setAttribute("PrenomClient", Client.getPrenomClient()); 
             session.setAttribute("Login", Client.getLogin());
             session.setAttribute("Password", Client.getPassword()); 
             session.setAttribute("passwordAsso", Client.getPassword());
             session.setAttribute("NumTel", Client.getNumTel()); 
             session.setAttribute("Adresse", Client.getAdresse());
             session.setAttribute("Genre", Client.getGenre()); 
             session.setAttribute("DateNaissance", Client.getDateNaissance());
            
             

             response.sendRedirect("/AssociationMarket/produitVenteByCat?idCategorie_ProdVen=3" );
		}
		else {
			
//			out.println("clientt   "+login+"    "+ password);
//			out.println("ohhhh nooooo clientttt");
			 response.sendRedirect("./Client/clientLogin.jsp");
//			response.sendRedirect("/ClientMarket/frontend/loginClient.jsp");
//			request.getRequestDispatcher("/frontend/loginClient.jsp").forward(request, response);
		}
		


}
}
