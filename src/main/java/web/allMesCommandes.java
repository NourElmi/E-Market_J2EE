package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import Beans.Commande;
import Beans.ProdADonnerBean;
import DAO.CommandeInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class allMesCommandes
 */
public class allMesCommandes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DAOFactory daoFactory ;

	private CommandeInterf commandeInterf;

  
    public allMesCommandes() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.commandeInterf= daoFactory.getCommandeInterf();

    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);  		
		int IdClient = (int) session.getAttribute("IdClient");
		
		List<Commande> listCommandeValidee=commandeInterf.getAllMesCommandes(IdClient);
		request.setAttribute("listCommandeValidee", listCommandeValidee);

		//0n transmet l'objet requete et l'objet reponce a la JSP		
		this.getServletContext().getRequestDispatcher("/Panier/allMesCommandes.jsp").forward( request, response );

	}


}
