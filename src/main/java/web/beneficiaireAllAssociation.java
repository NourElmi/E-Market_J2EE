package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import Beans.Beneficiaire;
import Beans.Don;
import DAO.BeneficiaireInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class beneficiaireAllAssociation
 */
public class beneficiaireAllAssociation extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private DAOFactory daoFactory ;

	private BeneficiaireInterf beneficiaireInterf;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public beneficiaireAllAssociation() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.beneficiaireInterf= daoFactory.getBeneficiaireInterf();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		HttpSession session = request.getSession(false);  		
//		int IdAdmin = (int) session.getAttribute("IdAdmin");
		
				List<Beneficiaire> listallBeneficiaireAsso=beneficiaireInterf.getAllBeneficiaireAsso();
				request.setAttribute("listallBeneficiaireAsso", listallBeneficiaireAsso);

				//0n transmet l'objet requete et l'objet reponce a la JSP
				this.getServletContext().getRequestDispatcher("/Admin/beneficiaireAll.jsp").forward( request, response );
//				response.sendRedirect(" /allProdADonner.jsp ");	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
