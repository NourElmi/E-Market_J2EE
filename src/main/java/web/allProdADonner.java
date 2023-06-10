
package web;




import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import Beans.ProdADonnerBean;
//import dAO.ProdADonnerDaoImpl;
import DAO.ProdADonnerDAO;
import DAO_properties.DAOFactory;


/**
 * Servlet implementation class allAbonn
 */
@WebServlet(name = "allProdADonner", urlPatterns = {"/allProdADonner"})

public class allProdADonner extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private DAOFactory daoFactory ;
	private ProdADonnerDAO ProdADonnerDAo;
    public allProdADonner() {
        super();
    }
    /**
     * Cette method est appele au moment du chargement de la servlet avant meme la method doGet ou la method doPost 
     * cette meth va creer un objet DAOFactory qui sera connecter BD
     */ 
    
        public void init() throws ServletException 
        {
        	this.daoFactory = DAOFactory.getInstance();
        	this.ProdADonnerDAo= daoFactory.getProdADonnerDao();
        }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();		
//		out.println();
		HttpSession session = request.getSession(false);  		
		int idAssociation = (int) session.getAttribute("IdAsso");
		
		List listallProdADonner_EtatDemande_ByAsso=ProdADonnerDAo.getAllProdADonner(idAssociation);
		request.setAttribute("listallProdADonner_EtatDemande_ByAsso", listallProdADonner_EtatDemande_ByAsso);

		//0n transmet l'objet requete et l'objet reponce a la JSP		
//      request.getRequestDispatcher("./Association/home_association.jsp").forward(request, response);
//		this.getServletContext().getRequestDispatcher("/allProdADonner.jsp").forward( request, response );
		this.getServletContext().getRequestDispatcher("/ProdADonner/prodADonnerMarket.jsp").forward( request, response );
//		response.sendRedirect("./ProdADonner/prodADonnerMarket.jsp ");

	}



}
