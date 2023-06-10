package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import DAO.BeneficiaireInterf;
import DAO.DonInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class BeneficiaireAdd
 */
public class beneficiaireAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOFactory daoFactory ;

	private BeneficiaireInterf beneficiaireInterf;
       
  
    public beneficiaireAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.beneficiaireInterf= daoFactory.getBeneficiaireInterf();
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		HttpSession session = request.getSession(false);  		
//		int idAsso_benef = (int) session.getAttribute("IdAsso"); 
//		//int idAsso_benef=1;
		
		PrintWriter out = response.getWriter();
		String nomBenefi =request.getParameter( "nomBenefi" ) ;
		String prenomBenefi =request.getParameter( "prenomBenefi" ) ;
		String login =request.getParameter( "login" ) ;
		String password =request.getParameter( "password" ) ;
		int numTel =Integer.parseInt(request.getParameter( "numTel" )) ;
		String adresse =request.getParameter( "adresse" ) ;
		String genre =request.getParameter( "genre" ) ;
		String dateNaissance =request.getParameter( "dateNaissance" ) ;
		
		//out.println(typeDon+"   " +nbrProd+ "   " +categories+ "   " +description + "   " +dateDon);
		beneficiaireInterf.addBeneficiaire(nomBenefi, prenomBenefi, login,password,numTel,adresse,genre,dateNaissance);
		
		
		
		response.sendRedirect("/AssociationMarket/Beneficiaire/beneficiaireLogin.jsp");
		//faut creer all
	
	}

}
