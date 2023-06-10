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

import DAO.CommandeInterf;
import DAO.LigneCommandeInterf;
import DAO.ProdADonnerDAO;
import DAO.ProduitVenteInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class ajouterAuPanier
 */
//C'est la meme chose que creer une ligne de commande 
public class ajouterAuPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOFactory daoFactory ;

	private CommandeInterf commandeInterf;
	private LigneCommandeInterf ligneCommandeInterf;
//	private ProduitVenteInterf produitVenteInterf;
       
  
    public ajouterAuPanier() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.commandeInterf= daoFactory.getCommandeInterf();
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
		PrintWriter out = response.getWriter();		
		
		
		
		int quantite=Integer.parseInt(request.getParameter("quantite"));
		int idProdVente_ligneCom=Integer.parseInt(request.getParameter("idProdVente"));
		
//		out.println(quantite+"    "+ idProdVente_ligneCom);
		HttpSession session = request.getSession(false);  		
		int IdClient = (int) session.getAttribute("IdClient");
		
		int idCommandeNonValide= commandeInterf.findCommande(IdClient);
		
		if( idCommandeNonValide == 0 ) 
		{
			LocalDate dateObj = LocalDate.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        String date = dateObj.format(formatter);
			out.println("Creer commande");
			out.println(quantite+"    "+ idProdVente_ligneCom);
			idCommandeNonValide=commandeInterf.createCommande(0,"","",date,IdClient, 0);
			ligneCommandeInterf.addLigneCommande(quantite,idProdVente_ligneCom ,idCommandeNonValide, IdClient);
			
		}else{
			out.println("commandeNonValideExiste");
			ligneCommandeInterf.addLigneCommande(quantite,idProdVente_ligneCom ,idCommandeNonValide, IdClient);
		}
//		out.println(quantite+"    "+ idProdVente_ligneCom);
		response.sendRedirect("/AssociationMarket/afficherPanier_AllLigneCom");


}
}
