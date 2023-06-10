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

import Beans.ProdADonnerBean;
import DAO.ProdADonnerDAO;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class allProdemanderByBene
 */
public class allProdemanderByBene extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DAOFactory daoFactory ;
	private ProdADonnerDAO ProdADonnerDAo;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allProdemanderByBene() {
        super();
        // TODO Auto-generated constructor stub
    }

	        public void init() throws ServletException 
	        {
	        	this.daoFactory = DAOFactory.getInstance();
	        	this.ProdADonnerDAo= daoFactory.getProdADonnerDao();
	        }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
			PrintWriter out = response.getWriter();		
//			out.println();
			HttpSession session = request.getSession(false);  		
			int idBeneficiaire = (int) session.getAttribute("idBeneficiaire");
			
			List listallProdADonner_EtatDemande=ProdADonnerDAo.getProdADonnerDemanderByBenef(idBeneficiaire);
			request.setAttribute("listallProdADonner_EtatDemande", listallProdADonner_EtatDemande);

			//0n transmet l'objet requete et l'objet reponce a la JSP		
//	      request.getRequestDispatcher("./Association/home_association.jsp").forward(request, response);
//			this.getServletContext().getRequestDispatcher("/allProdADonner.jsp").forward( request, response );
			this.getServletContext().getRequestDispatcher("/Beneficiaire/ProdADonnerDemanderByBenef.jsp").forward( request, response );
//			response.sendRedirect("./ProdADonner/prodADonnerMarket.jsp ");

		}



	
}
