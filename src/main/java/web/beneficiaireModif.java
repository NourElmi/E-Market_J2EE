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
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class beneficiaireModif
 */
public class beneficiaireModif extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOFactory daoFactory ;

	private BeneficiaireInterf beneficiaireInterf;
       
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public beneficiaireModif() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
//		out.println(ProdADonnerID);	
		
		HttpSession session = request.getSession(false);  		
		int idAsso_benef = (int) session.getAttribute("IdAsso"); 
		
		int  idBeneficiaire = Integer.parseInt(request.getParameter("idBeneficiaire"));
		
//	
		String nomBenefi =request.getParameter( "nomBenefi" ) ;
		String prenomBenefi =request.getParameter( "prenomBenefi" ) ;
		String login =request.getParameter( "login" ) ;
		String password =request.getParameter( "password" ) ;
		int  numTel = Integer.parseInt(request.getParameter( "numTel" )) ;
		String  adresse =request.getParameter( "adresse" ) ;
		String  genre =request.getParameter( "genre" ) ;
		String  dateNaissance =request.getParameter( "dateNaissance" ) ;
		
		
		//out.println(idBeneficiaire+"   "+nomBenefi);
		 beneficiaireInterf. modifBeneficiaire( nomBenefi,  prenomBenefi,  login,  password,  numTel,
					 adresse,  genre,  dateNaissance,  idAsso_benef,  idBeneficiaire);
//		PrintWriter out = response.getWriter();
//		out.println(CIN+ prenom + job + ProdADonnerID);	
//		request.getRequestDispatcher("/allProdADonner").forward( request, response );
		response.sendRedirect("/AssociationMarket/beneficiaireModif");
		
	}

}
