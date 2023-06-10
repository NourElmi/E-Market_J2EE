package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import Beans.Beneficiaire;
import Beans.Don;
import DAO.BeneficiaireInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class beneficiaireFind
 */
public class beneficiaireFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOFactory daoFactory ;

	private BeneficiaireInterf beneficiaireInterf;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public beneficiaireFind() {
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
		int idBeneficiaire =Integer.parseInt(request.getParameter("idBeneficiaire"));
		Beneficiaire beneficiaire = beneficiaireInterf.find(idBeneficiaire);
		request.setAttribute("beneficiaire", beneficiaire);
	PrintWriter out = response.getWriter();
	out.println(beneficiaire.getNomBenefi());
	//	this.getServletContext().getRequestDispatcher("/Association/beneficiaireModif.jsp").forward( request, response );
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
