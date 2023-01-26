package LibraryManagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import static LibraryManagement.IOUtils.*;
import static LibraryManagement.LibUtils.*;
import LibraryManagement.Category;
public class Testerlib {

	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException, HandlingExceptions {
		
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter Filename ");
			String fs=sc.nextLine();
			
			Map<Integer,Book> library=restoredetails(fs);
			boolean flag=false;
			while(!false)
			{
				try
				{
				System.out.println("1.ADMIN 2.READER 3.EXIT");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Enter Login Name");
					String name=sc.next();
					validatename(name);
					System.out.println("Enter Password");
					String password=sc.next();
					validatepwd(password);
					boolean a=false;
					while(!a)
					{
					System.out.println("\n1.Display All Book  \n2.Add a Book \n3.Remove a Book 4.Exit");
					switch(sc.nextInt())
					{
					case 1:
						System.out.println("Librry Contains");
						for(Book k:library.values())
							System.out.println(k);
						break;
					case 2:
						
						break;
					case 3:
						System.out.println("Enter Book id");
						
					case 4:
						a=true;
						break;
					}
					}
					break;
				case 2:
					System.out.println("Enter Login Name");
					validatename(sc.next());
					System.out.println("Enter Password");
					validatepwd(sc.next());
					break;
				case 3:
					flag=true;
					break;
				}
			}catch(Exception e)
				{
				e.printStackTrace();
				}
			}
		}

	}

}
