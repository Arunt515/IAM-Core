/**
 * Ce fichier est la propriété de Thomas BROUSSARD Code application : Composant :
 */
package fr.epita.iam.launcher;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.datamodel.Login;
import fr.epita.iam.exceptions.EntityCreationException;
import fr.epita.iam.exceptions.EntityDeletionException;
import fr.epita.iam.exceptions.EntitySearchException;
import fr.epita.iam.exceptions.EntityUpdateException;
import fr.epita.iam.services.identity.IdentityDAO;
import fr.epita.iam.services.identity.IdentityDAOFactory;
import fr.epita.iam.ui.ConsoleOperations;

/**
 * <h3>Description</h3>
 * <p>
 * This class allows to ...
 * </p>
 *
 * <h3>Usage</h3>
 * <p>
 * This class should be used as follows:
 *
 * <pre>
 * <code>${type_name} instance = new ${type_name}();</code>
 * </pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 *         ${tags}
 */
public class Launcher {

	/**
	 *
	 * <h3>Description</h3>
	 * <p>
	 * This methods allows to ...
	 * </p>
	 *
	 * <h3>Usage</h3>
	 * <p>
	 * It should be used as follows :
	 *
	 * <pre>
	 * <code> ${enclosing_type} sample;
	 *
	 * //...
	 *
	 * sample.${enclosing_method}();
	 *</code>
	 * </pre>
	 * </p>
	 *
	 * @since $${version}
	 * @see Voir aussi $${link}
	 * @author ${user}
	 *
	 *         ${tags}
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		// initialize resources
		IdentityDAO dao = null;
		try {
			dao = IdentityDAOFactory.getDAO();
		} catch (final Exception e) {
			// TODO log

			return;
		}
		final ConsoleOperations console = new ConsoleOperations();
		// Welcome\
		
		// Authentication
		Login login=console.authenticate();
		
		
		try {
		
			if(dao.searchLogin(login))
			{
			System.out.println("Successfully logged in.");
		int ch=0;
			while(ch!=4) {
			
			ch =Integer.parseInt(console.getMenu());
			
				switch(ch) {
				
					case 1 :
						
						final Identity identity = console.readIdentityFromConsole();
						try {
						
							dao.create(identity);
							System.out.println("Identity Successfully Created.");
						} catch (final EntityCreationException ece) {
							System.out.println(ece.getMessage());
						}
					// Search?
						
						break;
						
					case 2 : //search
				
						final Identity criteria = null  ;
						List<Identity> resultList;
						try {
							resultList = dao.search(criteria);
							console.displayIdentitiesInConsole(resultList);
							int choice=Integer.parseInt(console.readCriteriaFromConsole());
							switch(choice)
							{
							case 1 :
								Identity iden= console.readUpdatedCriteriaFromConsole();
								try {
									dao.update(iden);
									System.out.println("Identity Successfully Updated.");
								} catch (EntityUpdateException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							case 2 :Identity idens = console.readToDeleteCriteriaFromConsole();
								try {
									dao.delete(idens);
									System.out.println("Identity Successfully deleted.");
								} catch (EntityDeletionException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								break;
							case 3 :
								break;
							}
						} catch (final EntitySearchException e) {
							System.out.println(e.getMessage());
						}
						break;
						
					case 3 : ArrayList<String> user = console.createUser();
					try {
						dao.createLoginUser(user.get(0), user.get(1));
						console.userCreated();
					} catch (EntityCreationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
										break;
									
					case 4 : console.getExitMenu();
										break;
								
								
							
					}
				
				
				}
			
			}
		} catch (EntitySearchException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		console.releaseResources();

		

}}
