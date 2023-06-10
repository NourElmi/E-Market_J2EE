package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import Beans.Commande;
import DAO.CommandeInterf;
import DAO.LigneCommandeInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class acheterValiderCommander
 */
public class acheterValiderCommander extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOFactory daoFactory ;

	private CommandeInterf commandeInterf;

  
    public acheterValiderCommander() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.commandeInterf= daoFactory.getCommandeInterf();
//    	this.ligneCommandeInterf= daoFactory.getLigneCommandeInterf();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	    HttpSession session = request.getSession(false);  		
		int montantCommande = (int) session.getAttribute("montantCommande");
		
		this.getServletContext().getRequestDispatcher("/Panier/validerComModePaiem.jsp").forward( request, response );

    }
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();		
		
		int montantCommande=Integer.parseInt(request.getParameter("montantCommande"));
		String modePaiement= request.getParameter("modePaiement");
		String commantaire= request.getParameter("commantaire");
		String dateCommande= request.getParameter("dateCommande");
		
		HttpSession session = request.getSession(false);  		
		int idClient_Com = (int) session.getAttribute("IdClient");
		
		
		int idCommandeNonValide= commandeInterf.findCommande(idClient_Com);
		
//		out.println("Creer commande");
			LocalDate dateObj = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String date = dateObj.format(formatter);
			idCommandeNonValide=commandeInterf.createCommande(0,"","",date,idClient_Com, 0);
			
		Commande commandeValidee=commandeInterf.updateCommande(idCommandeNonValide, montantCommande , modePaiement , commantaire , dateCommande , idClient_Com);
//		out.println(commande.getEtatCommande()+" "+ commande.getModePaiement());
		request.setAttribute("commandeValidee", commandeValidee);

		this.getServletContext().getRequestDispatcher("/Panier/afficherRecuCom.jsp").forward( request, response );
	
			
//		response.sendRedirect("/AssociationMarket/afficherRecuCom");

	}

}
