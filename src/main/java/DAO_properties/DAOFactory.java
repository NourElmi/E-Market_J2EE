package DAO_properties;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.xdevapi.ClientImpl;

import DAO.AdminInterf;
import DAO.AssociationInterf;
import DAO.BeneficiaireInterf;
import DAO.CategorieInterf;
import DAO.ClientInterf;
import DAO.CommandeInterf;
import DAO.DemandeInterf;
import DAO.DonInterf;
import DAO.LigneCommandeInterf;
import DAO.ProdADonnerDAO;
import DAO.ProduitVenteInterf;
import DAOImpl.AdminImpl;
import DAOImpl.AssociationImpl;
import DAOImpl.BeneficiaireImpl;
import DAOImpl.CategorieImpl;
import DAOImpl.ClientImplement;
import DAOImpl.CommandeImpl;
import DAOImpl.DemandeImpl;
import DAOImpl.DonImpl;
import DAOImpl.LigneCommandeImpl;
import DAOImpl.ProdADonnerDaoImpl;
import DAOImpl.ProduitVenteImpl;
import DAOImpl.ProduitVenteImpl;

public class DAOFactory {

    private static final String FICHIER_PROPERTIES       = "/DAO_properties/dao.properties";
    private static final String PROPERTY_URL             = "url";
    private static final String PROPERTY_DRIVER          = "driver";
    private static final String PROPERTY_NOM_UTILISATEUR = "nomutilisateur";
    private static final String PROPERTY_MOT_DE_PASSE    = "motdepasse";

    private String              url;
    private String              username;
    private String              password;

    DAOFactory( String url, String username, String password ) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /*
     * Méthode chargée de récupérer les informations de connexion à la base de données,
     * ainsi que charger le driver JDBC et retourner une instance de la Factory
     */
    public static DAOFactory getInstance() throws DAOConfigurationException {
        Properties properties = new Properties();
        String url;
        String driver;
        String nomUtilisateur;
        String motDePasse;

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream fichierProperties = classLoader.getResourceAsStream( FICHIER_PROPERTIES );

        if ( fichierProperties == null ) {
            throw new DAOConfigurationException( "Le fichier properties " + FICHIER_PROPERTIES + " est introuvable." );
        }
        
        //  recupe les infos de cnx BD
        try {
            properties.load( fichierProperties );
            url = properties.getProperty( PROPERTY_URL );
            driver = properties.getProperty( PROPERTY_DRIVER );
            nomUtilisateur = properties.getProperty( PROPERTY_NOM_UTILISATEUR );
            motDePasse = properties.getProperty( PROPERTY_MOT_DE_PASSE );
        } catch ( IOException e ) {
            throw new DAOConfigurationException( "Impossible de charger le fichier properties " + FICHIER_PROPERTIES, e );
        }
        
        // charger diriver
        try {
            Class.forName( driver );
        } catch ( ClassNotFoundException e ) {
            throw new DAOConfigurationException( "Le driver est introuvable dans le classpath.", e );
        }
        
        // Instancier Factory : se connecter a la BD
        DAOFactory instance = new DAOFactory( url, nomUtilisateur, motDePasse );
        return instance;
    }

    /* Méthode chargée de fournir une connexion à la base de données */
    // Permet de reccuperer a tout moment la cnx a la BD, utiliser dans l'implementation
     /* package */ public Connection getConnection() throws SQLException {
        return DriverManager.getConnection( url, username, password );
    }

    /*
     * Méthodes de récupération de l'implémentation des différents DAO (un seul
     * pour le moment)
     */
	/**
	 * cette method nous return une instanciation/un objet de la classe FreelancerDaoImpl 
	 * elle fait appel au constructeur qui comme parametre daoFactory : public FreelancerDaoImpl( DAOFactory daoFactory)
	 * tant que nous somme dans la classe  DAOFactory, alors on met 'this' a la place d'ecrire ( DAOFactory daoFactory)
	 * cette 'this' segnifie l'objet courant cad l'objet de cette classe (l'ensemble des variable et des attribut de cette classe)
	 */
     
     public AdminInterf getAdminInterf() {
         return new AdminImpl(this );
      }
  
     public AssociationInterf getAssociationInterf() {
         return new AssociationImpl( this );
     }
     
     public ProdADonnerDAO getProdADonnerDao() {
        return new ProdADonnerDaoImpl(this );
     }
     
  
     public ProduitVenteInterf getProduitVenteInterf() {
         return new ProduitVenteImpl(this );
      }
     

     public ClientInterf getClientInterf() {
         return new ClientImplement(this );
      }
     
     public CommandeInterf getCommandeInterf() {
         return new CommandeImpl( this );
     }
     
     public LigneCommandeInterf getLigneCommandeInterf() {
         return new LigneCommandeImpl( this );
     }
     public DonInterf getDonInterf() {
         return new DonImpl( this );
     }
     public BeneficiaireInterf getBeneficiaireInterf() {
         return new BeneficiaireImpl( this );
     }
     
     public DemandeInterf getDemandeInterf() {
         return new DemandeImpl( this );
     }
    
     public CategorieInterf getCategorieInterf() {
         return new CategorieImpl( this );
     }
//    public OffreDAO getOffreDao() {
//        return new OffreDaoImpl(this);
//    }
    
}