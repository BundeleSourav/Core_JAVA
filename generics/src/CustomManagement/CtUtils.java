package CustomManagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class CtUtils {

	
	public static LocalDate checkdate;
	static 
	{
		checkdate=LocalDate.parse("2015-12-09");
	}
	
	public static String validateEmail(String email) throws CustomException
	{
		String s="^[\\w\\.-]+@[\\w\\.-]+(com|org|net)$";
		if(email.matches(s))
			return email;
		
		throw new CustomException("Invalid login Id...!!!!!!");
	}
	
	public static String validatepswd(String paswd) throws CustomException
	{
		String ss="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[#@$*%]).{5,10}";
		if(paswd.matches(ss))
			return paswd;
		
		throw new CustomException("Invalid Password....!!!!!!!!!!");
	}
	
	public static String validatename(String name) throws CustomException
	{
		String e="[A-Z][a-z]*";
		if(name.matches(e))
			return name;
		
		throw new CustomException("Invalid Name....!!!!!");
	}
	
	public static LocalDate validatedate(String date) throws CustomException
	{
		LocalDate dd=LocalDate.parse(date);
		if(dd.isAfter(checkdate))
			return dd;
		
		throw new CustomException("Invalid Date please check Date");
	}
	
	public static Services validateplan(String plan) throws CustomException
	{
		try
		{
			return Services.valueOf(plan.toUpperCase());
		}catch(IllegalArgumentException e)
		{
			StringBuilder sb=new StringBuilder("Available Plans...");
			sb.append(Arrays.toString(Services.values())+"\n");
			sb.append("Choose Correct Plan!!");
			
			throw new CustomException(sb.toString());
		}
	}
	
	public static String checkdup(String email,List<Customer> clst) throws CustomException
	{
		Customer c=new Customer(email);
		if(clst.contains(c))
			throw new CustomException("Duplicate Email Detected...!!!!");
		
		return email;
	}
	
	public static Customer validatedetails(String name,String email,String pswd,String date,String plan,List<Customer> slists) throws CustomException
	{
		validatename(name);
		checkdup(validateEmail(email), slists);
		validatepswd(pswd);
		LocalDate d1=validatedate(date);
		
		Services svc=Services.valueOf(plan.toUpperCase());
		
		return new Customer(name,email,pswd,d1,svc);
		
	}
	
	public static Customer findbyemail(String email,List<Customer> lists) throws CustomException
	{
		Customer c1=new Customer(email);
		int index=lists.indexOf(c1);
		if(index==-1)
			throw new CustomException("Duplicate Email detected");
	
		return lists.get(index);
	}
	
	public static Customer login(String email,String pswd,List<Customer> list) throws CustomException
	{
		String e=validateEmail(email);
		String p1=validatepswd(pswd);
		Customer p=findbyemail(e, list);
		if(p.getPswd().equals(p1))
			return p;
		
		throw new CustomException("Invalid Login Credentials..!!!!!!");
	}
	
	public static void findbyDate(String date1,String date2,List<Customer> clist) throws CustomException
	{
		LocalDate bdate=LocalDate.parse(date1);
		LocalDate edate=LocalDate.parse(date2);
		boolean flag=false;
		for(Customer c:clist)
		{
			if(c.getDate().isAfter(bdate) && c.getDate().isBefore(edate))
			{	System.out.println(c.getName());
				flag=true;
			}
		}
		if(flag)
		{
			System.out.println("Thank You!");
		}
		else
			throw new CustomException("Given Date is not in range");
		
	}
}
