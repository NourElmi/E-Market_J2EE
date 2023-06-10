package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import Beans.Association;
import DAO.AssociationInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class login_Association
 */
public class login_Association extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
    

	
    private DAOFactory daoFactory ;
	private AssociationInterf associationInterf;
	
    public login_Association() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.associationInterf= daoFactory.getAssociationInterf();
    }
	
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
//		request.getRequestDispatcher("./Association/login_association.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		//1) lire les donnés saisie
		PrintWriter out = response.getWriter();
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		Association association=new Association();
		
		boolean flag=associationInterf.Check_login_ass(email, password);
		if(flag) {
			
			
			association = associationInterf.getAssociationByEmail(email);
			
			out.println("dfgrhtjyukujhgfd");
			 HttpSession session = request.getSession();             
			 
             session.setAttribute("IdAsso", association.getIdAsso()); 
             session.setAttribute("NomAsso", association.getNomAsso());
             session.setAttribute("NomRespo", association.getNomRespo()); 
             session.setAttribute("PrenomRespo", association.getPrenomRespo());
             session.setAttribute("Email", association.getEmail()); 
             session.setAttribute("Password", association.getPassword());
             session.setAttribute("TelephoneAsso", association.getTelephoneAsso()); 
             session.setAttribute("Localisation", association.getLocalisation());
             session.setAttribute("Ville", association.getVille()); 
             session.setAttribute("Secteur", association.getSecteur());
             session.setAttribute("NbrJourRecuProd", association.getNbrJourRecuProd());
             
             response.sendRedirect("/AssociationMarket/ProfileAssociation" );
  
// 			request.getRequestDispatcher("/frontend/loginAssociation.jsp").forward(request, response);

		}
		else {
//			out.println("ohhhh nooooo");
			 response.sendRedirect("/AssociationMarket/Association/associationLogin.jsp");
//			response.sendRedirect("/AssociationMarket/frontend/loginAssociation.jsp");
//			request.getRequestDispatcher("/frontend/loginAssociation.jsp").forward(request, response);
		}
		


}

}



