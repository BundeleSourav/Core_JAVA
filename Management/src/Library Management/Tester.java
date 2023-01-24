package libraryMan;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import static libraryMan.libUtils.*;
import static libraryMan.IOUtils.*;
public class Tester {

	public static void main(String[] args) throws HandlingException, FileNotFoundException, ClassNotFoundException, IOException {
		
		try(Scanner sc=new Scanner(System.in))
		{
		System.out.println("Enter File Name");
		String filename=sc.nextLine();
		HashMap<String,Book> library= new HashMap<>(restoreDetails(filename));
		display(filename,library);
		boolean flag=false;
		while(!flag)
		{
			System.out.println("1.Reader 2.Admin 3.Exit");
			switch(sc.nextInt())
			{
			case 1:
				System.out.println("Enter Reader Name");
				String name=sc.next();
				validatename(name);
				System.out.println("Enter Password");
				String pswd=validatepaswd(sc.next());
				System.out.println("LogedIn Successfully!!!!!!!!");
				
				boolean f=false;
				while(!f) {
					System.out.println("\n1.Display All Books \n2.Issue a Book \n3.Display Books by Author \n4.Return a Book \n5.Search before and after a date \n6.Exit");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Library Contains");
					for(Book b:library.values())
						System.out.println(b);
					break;
				case 2:
					System.out.println("Enter a Book Title");
					String a=sc.next();
					Book b=library.get(a);
					System.out.println("Issued Book:- "+b);
					
					if(b==null)
						throw new HandlingException("Currently Book is not available please check later......");
					else if(library.containsValue(b)) {
						b.setCount(b.getCount()-1);
						//System.out.println(b.getCount());
					}
					break;
				case 3:
					System.out.println("Enter Author Name");
					findbyauthor(sc.next(), library);
					break;
				case 4:
					System.out.println("Enter a Book title");
					String s=sc.next();
					Book k=library.get(s);
					
					if(k==null)
						throw new HandlingException("Book already submitted");
					else if(library.containsValue(k)) {
						k.setCount(k.getCount()+1);
						System.out.println("Submitted Book:- "+k);
					}	
					break;
				case 5:
					System.out.println("Enter Date ");
					validatedate(sc.next(),library);
					break;
				case 6:
					f=true;
					break;
				}
				}
				break;
				
			case 2:
				System.out.println("Enter Admin Name");
				String name1=sc.next();
				validatename(name1);
				System.out.println("Enter Password");
				String pswd1=validatepaswd(sc.next());
				System.out.println("LogedIn Successfully!!!!!!!!");
				
				boolean a=true;
				while(a) {
					System.out.println("\n1.Display All Books \n2.Add a Book \n3.Remove a book \n4.Exit ");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Library Contains");
					for(Book b:library.values())
						System.out.println(b);
					break;
				case 2:
					System.out.println("Add a Book");
					System.out.println("Enter Book details");
					library.put(validatename(sc.next()), new Book(validatename(sc.next()),sc.next(),sc.nextDouble(),sc.nextInt(),LocalDate.parse(sc.next()),sc.nextInt()));
					System.out.println("Book Added Succesfully");
					
					break;
				case 3:
					System.out.println("Enter Book to remove");
					Book bk=library.remove(sc.next());
					if(bk==null)
						throw new HandlingException("Invalid Credentials!!!....Book Can't be removed");
					else
						System.out.println("Removed Book:- "+bk);
					break;
				case 4:
					a=false;
					break;
				}
				}
				break;
			case 3:
				flag=true;
				break;
				
			}
		}
		}
	
	}

}
