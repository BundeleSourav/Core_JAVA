package CustomManagement;
import static CustomManagement.IOUtils.populate;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static CustomManagement.CtUtils.*;

public class Tester {

	public static void main(String[] args) throws CustomException {
		try(Scanner sc=new Scanner(System.in))
		{
			List<Customer> lists=populate();
			
			boolean flag=false;
			while(!flag)
			{
				System.out.println("\n1.Press To LOGIN \n2.Exit");
				switch(sc.nextInt())
				{
				case 1:
					boolean exit=false;
				
				System.out.println("Enter Login Id and Password");
				Customer c1=login(validateEmail(sc.next()), validatepswd(sc.next()), lists);
				if(lists.contains(c1))
					System.out.println("LogedIn Successfully");
				else
					System.out.println("Invalid Details");
				System.out.println();
				while(!exit)
				{
				
				System.out.println("\nOptions:- \n1.Add Customer \n2.Display all Customers \n3.Display all customer having specific plan \n4.UnSubscribe plan for a Customer \n5.Change Password \n6.Find Customer by Date \n10.Exit");
				System.out.println("Enter Your Choice");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Enter Customer Details");
					lists.add(new Customer(validatename(sc.next()), checkdup(validateEmail(sc.next()),lists),validatepswd(sc.next()),validatedate(sc.next()),validateplan(sc.next())));
					System.out.println("Added Successfully");
					break;
				case 2:
					System.out.println("All Customer's Details");
					for(Customer c:lists)
					{
						System.out.println(c);
					}
					break;
				case 3:
					System.out.println("Enter Service Plan ");
					Services s=validateplan(sc.next());
					for(Customer r:lists)
					{
						if(r.getPlan().equals(s))
							System.out.println(r);
					}
					break;
				case 4:
					System.out.println("Enter Email");
					String em=sc.next();
					
					Customer c3=new Customer(em);
					if(lists.remove(c3))
						System.out.println("UnSubscribe Successfully");
					else
						throw new CustomException("Invalid Credentials");
					
					
					break;
				case 5:
					System.out.println("Enter Login Id and Password");
					Customer c6=login(validateEmail(sc.next()), validatepswd(sc.next()), lists);
					if(lists.contains(c6)) {
						System.out.println("LogedIn Successfully");
						System.out.println("Enter New Password");
						c6.setPswd(validatepswd(sc.next()));
						System.out.println("Password changed successfully");
					}
					else
						System.out.println("Invalid Details");
					break;
				case 6:
					System.out.println("Enter Date");
					findbyDate(sc.next(),sc.next(), lists);
					break;
				case 10:
					exit=true;
					break;
				}
				}
				break;
				case 2:
					flag=true;
					break;
			}
			}
		}
	}

}
