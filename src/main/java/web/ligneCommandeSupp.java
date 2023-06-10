package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DAO.LigneCommandeInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class ligneCommandeSupp
 */
public class ligneCommandeSupp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  private DAOFactory daoFactory;

	  private LigneCommandeInterf ligneCommandeInterf;
	  
    public ligneCommandeSupp() {
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
		int idLigneCom = Integer.parseInt(request.getParameter("idLigneCom"));
		ligneCommandeInterf.suppLigneCommande(idLigneCom);
//		request.getRequestDispatcher("allProdADonner").forward( request, response );
		response.sendRedirect("/AssociationMarket/ligneCommandeAll");	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
