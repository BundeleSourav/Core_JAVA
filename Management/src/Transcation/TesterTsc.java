package Transcation;
import static Transcation.IoUtils.*;
import static Transcation.libUtils.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class TesterTsc {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			ArrayList<Summary> list=new ArrayList<>(populate());
			boolean exit=false;
			while(!exit)
			{
				System.out.println("Enter Details");
				System.out.println("\n1.Sum of all Deposits \n2.Max deposit amount \n3.Shopping expenses \n4.Date on which maximum amount withdrawn \n5.Exit");
				System.out.println("Enter Your Choice");
				switch(sc.nextInt())
				{
				case 1:
					double amnt=0;
					for(Summary s:list)
					{
						if(s.getDeposit()>=0)
						{
							amnt=amnt+s.getDeposit();
						}
					}
					System.out.println("Sum of all Deposit= "+amnt);
					break;
				case 2:
					Summary s2=new Summary();
					double a=s2.getDeposit();
					for(Summary k:list)
					{
						if(a<k.getDeposit())
						{
							a=k.getDeposit();
						}
					}
					System.out.println("Max:- "+a);
					break;
				case 3:
					double amnt1=0;
					for(Summary s:list)
					{
						if(s.getTask().equals(Narration.Shopping))
							amnt1=amnt1+s.getWdraw();
					}
					System.out.println("Sum of Expenses= "+amnt1);
					break;
				case 4:
					Summary s3=new Summary();
					double a2=s3.getWdraw();
					for(Summary q:list)
					{
						if(a2<q.getWdraw())
						{
							a2=q.getWdraw();
							
						}
					}
					for(Summary k:list)
					{
						if(k.getWdraw()==a2)
						{
							System.out.println(k.getDate());
						}
					}
					break;
				case 5:
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
