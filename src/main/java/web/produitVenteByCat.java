package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Beans.ProduitVente;
import DAO.ProduitVenteInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class produitVenteByCat
 */
public class produitVenteByCat extends HttpServlet {
    
	private static final long serialVersionUID = 1L;
	private DAOFactory daoFactory ;
	private ProduitVenteInterf produitVenteInterf;
  
	  public produitVenteByCat() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.produitVenteInterf= daoFactory.getProduitVenteInterf();
    }
  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
				
	
		int idCategorie_ProdVen =Integer.parseInt( request.getParameter("idCategorie_ProdVen")) ;
//		out.println(idCategorie_ProdVen);	
		List<ProduitVente> listProduitVente=produitVenteInterf.getAllProduitVenteByCat(idCategorie_ProdVen);
		request.setAttribute("listProduitVente", listProduitVente);

		
		//0n transmet l'objet requete et l'objet reponce a la JSP		
		this.getServletContext().getRequestDispatcher("/Client/shopClient.jsp").forward( request, response );

	}

	

}
