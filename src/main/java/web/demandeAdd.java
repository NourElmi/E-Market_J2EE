package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;

import Beans.ProdADonnerBean;
import DAO.CommandeInterf;
import DAO.DemandeInterf;
import DAO_properties.DAOFactory;

/**
 * Servlet implementation class demandeAdd
 */
public class demandeAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DAOFactory daoFactory ;

	private DemandeInterf demandeInterf;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public demandeAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException 
    {
    	this.daoFactory = DAOFactory.getInstance();
    	this.demandeInterf= daoFactory.getDemandeInterf();
    	
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
		HttpSession session = request.getSession(false);  		
		int idBenef_demande = (int) session.getAttribute("idBeneficiaire");
		
		String dateDemande =request.getParameter( "dateDemande" ) ;
		
		int idProd_Demande =Integer.parseInt(request.getParameter( "idProd_Demande" )) ;
		
		//int idProd_Demande= ProdADonnerBean.getIdProduit();
		
		demandeInterf.addDemande(dateDemande, idBenef_demande,  idProd_Demande);
		response.sendRedirect("/AssociationMarket/beneficiaireProdAdonner");
		
	}

}
