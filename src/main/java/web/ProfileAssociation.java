package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Beans.Association;
import DAO.AssociationInterf;
import DAO.DonInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class ProfileAssociation
 */
public class ProfileAssociation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOFactory daoFactory ;

	private AssociationInterf associationInterf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileAssociation() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.associationInterf= daoFactory.getAssociationInterf();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(false);  		
		String email = (String) session.getAttribute("Email");
//		String email ="sara@gmail.com";
		Association association=associationInterf.getAssociationByEmail(email);
		request.setAttribute("association", association);
		
		this.getServletContext().getRequestDispatcher("/Association/profilAssociation.jsp").forward( request, response );
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
