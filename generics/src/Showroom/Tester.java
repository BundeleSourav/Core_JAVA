package Showroom;
import java.time.LocalDate;
import java.util.Scanner;
import static Showroom.ShowUtils.*;
public class Tester {

	public static void main(String[] args) throws ShowroomException {
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter Number of Vehicles");
			Vehicle[] varr=new Vehicle[sc.nextInt()];
			
			int index=0;
			boolean flag=false;
			
			while(!flag)
			{
				System.out.println("\nOptions:- \n1.Add a vehicle \n2.Display All Vehicles  \n3.DisplayAll Vehicles by Color \n4.Apply Discount to a Vehicle \n6.Exit");
				System.out.println("Enter Your Choice");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Enter Name,Color,Price,Manufactured Date,Company Name");
					if(index<varr.length)
					{
						Vehicle v1=new Vehicle(sc.next(),validatecolor(sc.next().toUpperCase()),validateprice(sc.nextDouble()),LocalDate.parse(sc.next()),sc.next());
						System.out.println(v1);
						varr[index++]=v1;
					}
					System.out.println("Added Successfully");
					break;
				case 2:
					for(Vehicle c:varr)
					{
						System.out.println(c);
					}
					break;
				case 3:
					System.out.println("Enter Color ");
					Color cr=validatecolor(sc.next().toUpperCase());
					boolean f=false;
					for(Vehicle b:varr)
					{
						if(b!=null && b.getColor().equals(cr)) {
							System.out.println(b);
						f=true;
						break;
						}
					}
					if(f)
					{
						System.out.println("Thank You!!");
					}
					else
						throw new ShowroomException("Invalid Input");
					break;
				case 4:
					System.out.println("Enter a Vehicle Chasis No.");
					Vehicle vr=validatechasino(sc.next(), varr);
					System.out.println(vr);
					break;
				case 6:
					flag=true;
					break;
				}
			}
		}

	}

}
