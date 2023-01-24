package bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static bank.libUtils.*;

public class Tester {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
		
			System.out.println("Enter Filename");
			String filename=sc.nextLine();
			HashMap<Integer,Account> lists=new HashMap<>(restoredetails(filename));
			display(filename, lists);
			boolean exit=false;
			while(!exit)
			{
				System.out.println("Enter Your Choice");
				System.out.println("\n1.Log in \n2.Display Accounts \n3.Exit");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Enter Account Number And Password");
					Account a1=login(sc.nextInt(), validatepswd(sc.next()), lists);
					System.out.println(a1);
					if(lists.containsValue(a1)) {
						System.out.println("LogedIn Successfully");
						boolean f=false;
						System.out.println("\n1.Withdraw Amount \n2.Deposit Amount \n3.Total Balance \n10.Exit");
						while(!f)
						{
							switch(sc.nextInt())
							{
							case 1:
								System.out.println("Enter Account number");
								int i=sc.nextInt();
								Account ac=lists.get(i);
								System.out.println(ac);
								for(Account c:lists.values())
								{
										if(lists.containsValue(ac))
									{
										System.out.println("Enter Amount");
										c.withdraw(sc.nextDouble());
										System.out.println("Transaction Successfull");
										break;
									}
								}
								break;
							case 2:
								System.out.println("Enter Account number");
								Account ac1=new Account(sc.nextInt());
								for(Account q:lists.values())
								{
									if(lists.containsKey(ac1))
									{
										System.out.println("Enter Amount");
										ac1.withdraw(sc.nextDouble());
										System.out.println("Transaction Successfull");
									}
								}
								break;
							case 10:
								f=true;
								break;
							}
						}
					}
					else
						System.out.println("Invalid Details");
					
					break;
				case 2:
					System.out.println("Details of All Bank Accounts");
					for(Account a:lists.values())
					{
						System.out.println(a);
					}
					break;
				case 3:
					exit=true;
					break;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
