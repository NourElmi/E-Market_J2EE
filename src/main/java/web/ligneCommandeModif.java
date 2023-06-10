package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import DAO.LigneCommandeInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class ligneCommandeModif
 */
public class ligneCommandeModif extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  private DAOFactory daoFactory;

	  private LigneCommandeInterf ligneCommandeInterf;
	  
    public ligneCommandeModif() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException 
    {
       	this.daoFactory = DAOFactory.getInstance();
    	this.ligneCommandeInterf= daoFactory.getLigneCommandeInterf();
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		int idLigneCom=Integer.parseInt(request.getParameter("idLigneCom"));
	//out.println(idLigneCom+" "+quantite);
		String quantite =request.getParameter( "quantite" ) ;
		out.println(idLigneCom+" "+quantite);
		
		//ligneCommandeInterf.modifLigneCommande(quantite,idLigneCom);
		//response.sendRedirect("/AssociationMarket/ligneCommandeModif");

		

	}

}
