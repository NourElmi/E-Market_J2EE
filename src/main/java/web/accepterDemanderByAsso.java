package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import DAO.DemandeInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class accepterDemanderByAsso
 */
public class accepterDemanderByAsso extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOFactory daoFactory ;

	private DemandeInterf demandeInterf;
    
    public accepterDemanderByAsso() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.demandeInterf= daoFactory.getDemandeInterf();
    	
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();		
//		out.println("eeeee");
		int idDemande =Integer.parseInt(request.getParameter( "idDemande" )) ;
		
		HttpSession session = request.getSession(false);  		
		int idAsso = (int) session.getAttribute("IdAsso");
		
		demandeInterf.accepterDemande(idDemande);
		
//		out.println("eeeee");
		response.sendRedirect("/AssociationMarket/allProdADonner");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
