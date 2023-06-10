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
 * Servlet implementation class beneficiaire_Login
 */
public class beneficiaire_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOFactory daoFactory ;

	private BeneficiaireInterf beneficiaireInterf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public beneficiaire_Login() {
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
		//1) lire les donnés saisie
				PrintWriter out = response.getWriter();
				
				String login=request.getParameter("login");
				String password=request.getParameter("password");
				
				Beneficiaire beneficiaire=new Beneficiaire();
				
				boolean flag=beneficiaireInterf.Check_login_benef(login, password);
				if(flag) {
					
					
					beneficiaire = beneficiaireInterf.getBeneficiaireByLogin(login);
					
					out.println("dfgrhtjyukujhgfd");
					 HttpSession session = request.getSession();             
					 
		             session.setAttribute("idBeneficiaire", beneficiaire.getIdBeneficiaire()); 
		             session.setAttribute("nomBenefi", beneficiaire.getNomBenefi());
		             session.setAttribute("prenomBenefi", beneficiaire.getPrenomBenefi()); 
		             session.setAttribute("login", beneficiaire.getLogin());
		             session.setAttribute("password", beneficiaire.getPassword()); 
		             session.setAttribute("numTel", beneficiaire.getNumTel());
		             session.setAttribute("adresse", beneficiaire.getAdresse()); 
		             session.setAttribute("genre", beneficiaire.getGenre());
		             session.setAttribute("dateNaissance",  beneficiaire.getDateNaissance()); 
		             
		             
		             response.sendRedirect("/AssociationMarket/beneficiaireProdAdonner" );
		  
//		 			request.getRequestDispatcher("/frontend/loginAssociation.jsp").forward(request, response);

				}
				else {
//					out.println("ohhhh nooooo");
					 response.sendRedirect("/AssociationMarket/Beneficiaire/beneficiaireLogin.jsp");
//					response.sendRedirect("/AssociationMarket/frontend/loginAssociation.jsp");
//					request.getRequestDispatcher("/frontend/loginAssociation.jsp").forward(request, response);
				}
				


	}

}
