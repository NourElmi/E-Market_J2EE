package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DAO.BeneficiaireInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class beneficiaireSupp
 */
public class beneficiaireSupp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOFactory daoFactory ;

	private BeneficiaireInterf beneficiaireInterf;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public beneficiaireSupp() {
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
		int  idBeneficiaire = Integer.parseInt(request.getParameter("idBeneficiaire"));
		beneficiaireInterf.suppBeneficiaire(idBeneficiaire);
//		request.getRequestDispatcher("allProdADonner").forward( request, response );
		response.sendRedirect("/AssociationMarket//beneficiaireAllAssociation");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
