 package DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.AssociationInterf;
import DAO_properties.DAOException;
import DAO_properties.DAOFactory;
import Beans.Association;

public class AssociationImpl implements AssociationInterf {
	
	
	private DAOFactory daoFactory;


	public AssociationImpl ( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
    
	
	private static Association map( ResultSet resultSet ) throws SQLException 
	{
		 Association association = new Association();
		 
		 	association.setIdAsso(resultSet.getInt("idAsso"));
			association.setNomAsso(resultSet.getString("nomAsso"));
			association.setNomRespo(resultSet.getString("nomRespo"));
			association.setPrenomRespo(resultSet.getString("prenomRespo"));
			association.setEmail(resultSet.getString("email"));
			association.setPassword(resultSet.getString("password"));
			association.setTelephoneAsso(resultSet.getString("telephoneAsso"));
			association.setLocalisation(resultSet.getString("localisation"));
			association.setVille(resultSet.getString("ville"));
			association.setSecteur(resultSet.getString("secteur"));
			association.setNbrJourRecuProd(resultSet.getInt("nbrJourRecuProd"));			
		return association;
	}
    
    public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	    for ( int i = 0; i < objets.length; i++ ) {
	        preparedStatement.setObject( i + 1, objets[i] );
	    }
	    return preparedStatement;
	}
    
    
    @Override
	public void insertAssociation(String nomAsso,String secteur,String nomRespo,String prenomRespo,String email,String password,String telephoneAsso,String ville,String localisation,int nbrJourRecuProd) throws DAOException{
	
	final String SQL_Insert = "insert into association values(?,?,?,?,?,?,?,?,?,?,?);";
	Connection connexion = null;
	PreparedStatement preparedStatement = null;

//    Association association = null;
		
		try{
			 connexion = daoFactory.getConnection();
		     preparedStatement = initRequestPrepare( connexion, SQL_Insert, null,nomAsso, nomRespo, prenomRespo, email, password, localisation, secteur, nbrJourRecuProd , telephoneAsso, ville);
		     preparedStatement.executeUpdate();
	         
	     }catch(SQLException e){
	         e.printStackTrace();
	     }

	}

    public boolean Check_login_ass(String email, String password) throws DAOException {
	
	boolean flag=false;
	
    final String SQL_SELECT_PAR_NOM = "SELECT idAsso, nomAsso FROM association WHERE email=? AND password=?";
	
	Connection connexion = null;
	PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

	try{
		/* Récupération d'une connexion depuis la Factory */
        connexion = daoFactory.getConnection();
        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, email, password );
        resultSet = preparedStatement.executeQuery();
    	 
         if(resultSet.next()) {
    		flag=true; 
         }
         preparedStatement.close();
         
     }catch(SQLException e){
         e.printStackTrace();
     }
	return flag;
}

	  @Override
	  public Association getAssociationByEmail(String email) throws DAOException {
		  
		  final String SQL_SELECT_By_Email = "SELECT * FROM association WHERE email=? ";
		  Connection connexion = null;
		  PreparedStatement preparedStatement = null;
		  ResultSet resultSet = null;
		  Association association = null;
		    System.out.println(email);
	  	try {
	  		
	  		connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_By_Email, email );
	        resultSet = preparedStatement.executeQuery();
	  		if ( resultSet.next() ) {
	  			association = map( resultSet );
	        }
	  	} catch (Exception e) {
	  		 e.printStackTrace();
	  	}
	  	System.out.println(association.getIdAsso());
	  	return association;
	  }

	  @Override
	  public  List<Association> getAllAssociation() throws DAOException {
		  
		  List<Association> listAllAsso= new ArrayList<Association>();
		  
		  final String SQL_SELECT= "SELECT * FROM association ";
		  Connection connexion = null;
		  PreparedStatement preparedStatement = null;
		  ResultSet resultSet = null;
		  Association association = null;
		   
	  	try {
	  		
	  		connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT);
	        resultSet = preparedStatement.executeQuery();
	  		while ( resultSet.next() ) 
	  		{
	  			association = map( resultSet );
	  			listAllAsso.add(association);
	        }
	  	} catch (Exception e) {
	  		 e.printStackTrace();
	  	}
	  
	  	return listAllAsso;
	  }


@Override
public boolean updateAssociation(AssociationInterf ass) throws DAOException {
	// TODO Auto-generated method stub
	return false;
}


@Override
public AssociationInterf getAssociationById(int id) throws DAOException {
	// TODO Auto-generated method stub
	return null;
}



//
//@Override
//public Association getAssociationById(int id) {
//	Connection connection= SingletonConnection.getConnection();
//	String query = "SELECT * FROM ASSOCIATION WHERE ass_id=" + id;
//	try {
//		PreparedStatement ps=connection.prepareStatement(query);
//		ResultSet rs = ps.executeQuery(query);
//		while(rs.next()) {
//			Association ass=new Association();
//			ass.setIdAss(rs.getInt("ass_id"));
//            ass.setNomAss(rs.getString("ass_name"));
//            ass.setEmailAss(rs.getString("ass_email"));
//            ass.setPasswordAss(rs.getString("ass_password"));
//            ass.setTelephoneAss(rs.getString("ass_telephone"));
//            ass.setAdresseAss(rs.getString("ass_adresse"));
//            ass.setVilleAss(rs.getString("ass_ville"));
//            ass.setDescriptionAss(rs.getString("ass_description"));
//            ass.setRibAss(rs.getString("ass_rib"));
//            return ass;
//		}
//		
//		
//		
//		
//	} catch (Exception e) {
//		 e.printStackTrace();
//	}
//	return null;
//}
//
//@Override
//public boolean updateAssociation(Association ass) {
//	 boolean rowUpdatedd;
//	 Connection connection= SingletonConnection.getConnection();   
//	 String Query = "UPDATE ASSOCIATION SET ass_name=?,ass_email=?,ass_password=?,ass_telephone=?,ass_adresse=?,ass_description=?, ass_ville=?, ass_rib=? WHERE ass_id=?";
//	 try {
//		 PreparedStatement ps = connection.prepareStatement(Query);
//		 ps.setString(1,ass.getNomAss());
//         ps.setString(2,ass.getEmailAss());
//         ps.setString(3,ass.getPasswordAss());
//         ps.setString(4,ass.getTelephoneAss());
//         ps.setString(5,ass.getAdresseAss());
//         ps.setString(6,ass.getDescriptionAss());
//         ps.setString(7,ass.getVilleAss());
//         ps.setString(8,ass.getRibAss());
//         ps.setInt(9, ass.getIdAss());
//         
//         ps.executeUpdate();
//         rowUpdatedd=ps.executeUpdate()>0;
//         return rowUpdatedd ;
//		
//	} catch (Exception e) {
//		 e.printStackTrace();
//	}
//	return false;
//
//}

}
	
	

