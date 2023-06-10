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
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class ProfileClient
 */
public class ProfileClient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileClient() {
        super();
        // TODO Auto-generated constructor stub
    }


		
		private DAOFactory daoFactory ;

		private AssociationInterf associationInterf;
	
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
			
			
			String email ="admin@gmail.com";
			Association association=associationInterf.getAssociationByEmail(email);
			request.setAttribute("association", association);
			
			this.getServletContext().getRequestDispatcher("/Admin/profilAssociation.jsp").forward( request, response );
			
	}
	}

