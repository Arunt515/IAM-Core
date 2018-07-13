/**
 * Ce fichier est la propriété de Thomas BROUSSARD
 * Code application :
 * Composant :
 */
package fr.epita.iam.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.epita.iam.datamodel.Identity;
import fr.epita.iam.datamodel.Login;

/**
 * <h3>Description</h3>
 * <p>This class allows to ...</p>
 *
 * <h3>Usage</h3>
 * <p>This class should be used as follows:
 *   <pre><code>${type_name} instance = new ${type_name}();</code></pre>
 * </p>
 *
 * @since $${version}
 * @see See also $${link}
 * @author ${user}
 *
 * ${tags}
 */
public class ConsoleOperations {

	private final Scanner scanner;

	public ConsoleOperations() {
		scanner = new Scanner(System.in);
	}
	
	public Login authenticate()
	{
		System.out.println("-------------------Welcome to IdentityDatabase---------------");
		boolean authenticate = false;
		
		System.out.print("please enter your Username : ");
		String uname= scanner.nextLine();
		System.out.print("please enter your Password : ");
		String pass= scanner.nextLine();
		System.out.println("Authenticating..........");
		final Login login = new Login();
		login.setUserName(uname);
		login.setPassword(pass);
		
		
		return login;
	}
	
	public String getMenu()
	{
		System.out.println("--------------- Home Page-------------");
		System.out.println("1. Create an Identity");
		System.out.println("2. Search Identity");
		System.out.println("3. Create User(login user)");
		System.out.println("4. Exit");
		System.out.print("please enter your choice : ");
		
		return scanner.nextLine();
	}
	
	public void getExitMenu() {
		System.out.println("You chosed to exit.");
		System.out.println("------------Thank you-----Bye ......Bye.....---------");
	}

	public Identity readIdentityFromConsole() {
		
		final Identity identity = new Identity();
		String line="";
		System.out.println("--------------- Idenity Creation Page-------------");
		System.out.println("please input the display name : ");
		line = scanner.nextLine();
		identity.setDisplayName(line);
		System.out.println("please input the email");
		line = scanner.nextLine();
		identity.setEmail(line);
		System.out.println("please input uid");
		line = scanner.nextLine();
		identity.setUid(line);
		return identity;
	}

	public String readCriteriaFromConsole() {
		
		System.out.println("1.UPDATE");
		System.out.println("2.DELETE");
		System.out.println("3.back");
		System.out.println("PLEASE ENTER YOUR CHOICE:");
		String line = scanner.nextLine();
		return line;
	}

	public Identity readUpdatedCriteriaFromConsole() {
	
		System.out.println("--------------- Update Identity Page-------------");
		final Identity identity = new Identity();
		System.out.println("Enter the UID for the Identity you want to update : ");
		String line = scanner.nextLine();
		identity.setUid(line);
		System.out.println("please input the new name for display name : ");
		line = scanner.nextLine();
		identity.setDisplayName(line);
		System.out.println("please input the new email for email : ");
		line = scanner.nextLine();
		identity.setEmail(line);

		return identity;
	}
	
	public Identity readToDeleteCriteriaFromConsole() {
		
		System.out.println("--------------- Delete Identity Page-------------");
		final Identity identity = new Identity();
		System.out.println("Enter the UID for the Identity you want to delete : ");
		String line = scanner.nextLine();
		identity.setUid(line);
		

		return identity;
	}
	
	public ArrayList<String> createUser() {
		
		System.out.println("--------------- Login User Creation Page-------------");
		System.out.println("Enter the User Name ");
		String name = scanner.nextLine();
		System.out.println("Enter the password");
		String password = scanner.nextLine();
		ArrayList<String> user = new ArrayList<String>();
		user.add(name);
		user.add(password);
		
	
		

		return user;
	}
	public void userCreated()
	{
		System.out.println("New User successfully created.");
	}
	
	public void displayIdentitiesInConsole(List<Identity> identities) {
		int i = 1;
		System.out.println("--------------- Search Page-------------");
		System.out.println("Identity Name \t|\t Email \t|\t UID");
		for (final Identity identity : identities) {
			System.out.print(i++ +"\t");
			System.out.println(identity.getDisplayName()+"\t|\t"+identity.getEmail()+"\t|\t"+identity.getUid());
			
		}
	}

	public void releaseResources() {
		scanner.close();
	}
}
