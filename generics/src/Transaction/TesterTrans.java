package Transaction;

import static Transaction.TUtils.*;
import java.util.Scanner;

public class TesterTrans {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			boolean exit=false;
			while(!exit)
			{
			System.out.println("\n1.Sum of all deposits \n2.Max deposit \n3.Shopping expenses \n4.Exit");
			System.out.println("Enter Your Choice");
			switch(sc.nextInt())
			{
			case 1:
				System.out.println("Sum of all Deposits:- "+sumofall());
				break;
			case 2:
				System.out.println("Maximum Deposited Amount:- "+max());
				break;
			case 3:
				System.out.println("Shopping Expenses:- "+shoppingexpenses());
				break;
			case 4:
				System.out.println("Thank You");
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
