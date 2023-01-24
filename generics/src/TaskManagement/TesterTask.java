package TaskManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static TaskManagement.IOutils.*;
import static TaskManagement.libUtils.*;

public class TesterTask {

	public static void main(String[] args) {
		try(Scanner sc=new Scanner(System.in))
		{
			
			Map<Integer,Task> tasks=populate();
			
			boolean exit=false;
			while(!exit)
			{
				System.out.println("\nSelect From Choices");
				System.out.println("1.Add new Task \n2.Delete a Task \n3.Update Task Status \n4.Display all Pending Task \n5.Display all Pending Task for today \n6.Display all Task sorted by date \n7.Exit");
				System.out.println("Enter Your Choice ");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println("Enter Task name, Description, and Date");
					Task t1=new Task(sc.next(), sc.next(), LocalDate.parse(sc.next()));
					
					//System.out.println();
					
					tasks.put(t1.getTaskid(),t1 );
					System.out.println("Successfully Registered");
					break;
				case 2:
					System.out.println("Enter TaskId");
//					Task t2=tasks.remove(sc.nextInt());
//					if(t2==null)
//					{
//						throw new TaskException("Invalid TaskId");
//					}
//					else
//						System.out.println("Removed Task:- "+t2);
					int i1=sc.nextInt();
					Task q1=tasks.get(i1);
					if(q1==null)
						throw new TaskException("Already task is removed");
					else if(tasks.containsKey(i1))
					{
						q1.setActive(false);
						System.out.println("Task is Removed successfully");
					}
						
					break;
				case 3:
					System.out.println("Enter TaskId");
					int t=sc.nextInt();
					//Task q=new Task(t);
					Task t3=tasks.get(t);
					if(t3==null)
						throw new TaskException("Enter Valid TaskId");
					else if(tasks.containsValue(t3))
					{
						System.out.println("Enter Task Name");
						t3.setStatus(validatestatus(sc.next()));
						System.out.println("Changed successfully");
					}
					else
					{
						throw new TaskException("Invalid TaskId");
					}
					
					break;
				case 4:
					System.out.println("Task Details");
					for(Task a:tasks.values())
					{
						if(a.getStatus().equals(Status.PENDING))
							System.out.println(a);
					}
					break;
				case 5:
					System.out.println("Enter Date");
					LocalDate k= findbydate(sc.next(), tasks);
					for(Task z:tasks.values())
					{
						if(z.getdate().equals(k))
							System.out.println(z);
					}
					break;
				case 6:
					ArrayList<Task> lists=new ArrayList<Task>(tasks.values());
					//Collections.sort(lists,new Comparator<Task>() {
//						@Override
//						public int compare(Task m,Task n)
//						{
//							return m.getdate().compareTo(n.getdate());
//						}
						
					//});
					lists.stream().sorted((a,b)->a.getdate().compareTo(b.getdate())).forEach(a->System.out.println(a));
					break;
				case 7:
					System.out.println("Thank You!!");
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
