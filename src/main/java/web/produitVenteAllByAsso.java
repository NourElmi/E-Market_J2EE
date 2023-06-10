package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Beans.ProduitVente;
import DAO.ProduitVenteInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class produitVenteAllByAsso
 */
public class produitVenteAllByAsso extends HttpServlet {
       
	private static final long serialVersionUID = 1L;
	private DAOFactory daoFactory ;
	private ProduitVenteInterf produitVenteInterf;
  
    public produitVenteAllByAsso() {
        super();
    }

    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.produitVenteInterf= daoFactory.getProduitVenteInterf();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();		
//		out.println("dfrki");
		
		HttpSession session = request.getSession(false);  		
		int idAssociation = (int) session.getAttribute("IdAsso");
		
		List<ProduitVente> listProduitVente=produitVenteInterf.getAllProduitVenteByAsso(idAssociation);
		request.setAttribute("listProduitVente", listProduitVente);

		//0n transmet l'objet requete et l'objet reponce a la JSP		
		this.getServletContext().getRequestDispatcher("/ProduitVente/produitVenteMarket.jsp").forward( request, response );

	}

}
