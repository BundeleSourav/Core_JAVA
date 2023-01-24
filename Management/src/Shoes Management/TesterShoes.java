package ShoesManagement;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static ShoesManagement.IOUtils.*;
import static ShoesManagement.libUtils.*;
public class TesterShoes {

	public static void main(String[] args) {
		
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter Filename");
			String filename=sc.next();
			Map<Integer,Shoes> maps=new HashMap<>(restoredetails(filename));
			display(filename, maps);
			boolean exit=false;
			while(!exit)
			{
				System.out.println("\n1.Add a new Shoe \n2.Update price of a shoe \n3.Update stock of a shoe \n4.Remove shoe which are out of stock for past 4 months \n5.Remove shoes which are never sold in past 6 months \n6.Display Stock \n7.Exit");
				System.out.println("Enter Your Choice");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Enter New Shoes Details");
					Shoes s1=new Shoes(validatetype(sc.next(), maps),LocalDate.parse(sc.next()),sc.nextInt(),LocalDate.parse(sc.next()),sc.nextFloat(),sc.nextDouble(),sc.next(),sc.nextFloat());
					
					maps.put(s1.getSid(), s1);
					System.out.println("Shoes Enterd Successfully");
					break;
				case 2:
					System.out.println("Enter Shoes Id");
					int i=sc.nextInt();
					Shoes d=maps.get(i);
					if(maps.containsValue(d))
					{
						System.out.println("Enter Price");
						d.setPrice(sc.nextDouble());
						//d.setUpdate(LocalDate.now());
					}
					break;
				case 3:
					System.out.println("Enter Shoes Id");
					int i1=sc.nextInt();
					Shoes d1=maps.get(i1);
					if(maps.containsValue(d1))
					{
						System.out.println("Enter new Quantity");
						d1.setQuantity(sc.nextInt());
						d1.setUpdate(LocalDate.now());
					}
					break;
				case 4:
					System.out.println("Enter Shoes Id");
					int q1=sc.nextInt();
					Shoes d2=maps.get(q1);
					System.out.println(d2);
					
					//System.out.println(md);
					if(maps.containsValue(d2))
					{
						System.out.println(d2);
						if(validate(LocalDate.now()) && d2.getQuantity()==0)
						{
							
							maps.remove(q1);
							System.out.println("Removed successfully");
						}
					}
					
					break;
				case 5:
					System.out.println("Enter Shoes Id");
					int q2=sc.nextInt();
					Shoes d3=maps.get(q2);
					for(Shoes f1:maps.values())
					{
					//if(maps.containsKey(d3))
					{
						if(d3.getQuantity()==f1.getQuantity() && validate2(d3.getUpdate()))
						{
							maps.remove(q2);
							System.out.println("Removed successfully");
						}
					}
					}
					break;
				case 6:
					System.out.println("Showroom Contains");
					for(Shoes d8:maps.values())
					{
						System.out.println(d8);
					}
					break;
				case 7:
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
