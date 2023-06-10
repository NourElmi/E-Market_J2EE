package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import Beans.Association;
import Beans.Beneficiaire;
import DAO.BeneficiaireInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class beneficiaireProfile
 */
public class beneficiaireProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOFactory daoFactory ;

	private BeneficiaireInterf beneficiaireInterf;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public beneficiaireProfile() {
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
		HttpSession session = request.getSession(false);  		
		String login = (String) session.getAttribute("login");
//		String email ="sara@gmail.com";
		Beneficiaire beneficiaire =beneficiaireInterf.getBeneficiaireByLogin(login);
		request.setAttribute("beneficiaire ", beneficiaire );
		
		//PrintWriter out = response.getWriter();
	      //out.println(login+" "+beneficiaire.getNomBenefi());
		
	
		
		this.getServletContext().getRequestDispatcher("/Beneficiaire/profileBeneficiaire.jsp").forward( request, response );
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
