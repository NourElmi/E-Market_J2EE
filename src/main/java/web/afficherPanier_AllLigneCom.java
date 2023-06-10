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

import Beans.LigneCommande;
import DAO.LigneCommandeInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class afficherPanier_AllLigneCom
 */
public class afficherPanier_AllLigneCom extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOFactory daoFactory;

	  private LigneCommandeInterf ligneCommandeInterf;
 
	  public afficherPanier_AllLigneCom() {
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
		
		HttpSession session = request.getSession(false);  		
		int IdClient = (int) session.getAttribute("IdClient");

		List listallLigneCommande_ProdVente_Total=ligneCommandeInterf.showPanier_AllLigneCommande(IdClient);
//		if (listallLigneCommande_ProdVente_Total.size() != 0) {
		request.setAttribute("listallLigneCommande_ProdVente_Total", listallLigneCommande_ProdVente_Total);
//		PrintWriter out = response.getWriter();		
//		out.println("asdfghjklpoiuytrewq");
		
        session.setAttribute("montantCommande",listallLigneCommande_ProdVente_Total.get(listallLigneCommande_ProdVente_Total.size()-1)); 
 
		//0n transmet l'objet requete et l'objet reponce a la JSP
		this.getServletContext().getRequestDispatcher("/Panier/afficherPanier.jsp").forward( request, response );
//		response.sendRedirect(" /allProdADonner.jsp ");
	}

}
