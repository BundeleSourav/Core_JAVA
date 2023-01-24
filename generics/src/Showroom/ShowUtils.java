package Showroom;

import java.time.LocalDate;
import java.util.Arrays;

public class ShowUtils {
	
	public static final double Min_price;
	public static final double Max_price;
	public static LocalDate begindate;
	public static LocalDate enddate;
	static 
	{
		Min_price=20000;
		Max_price=200000;
		begindate=LocalDate.parse("2020-10-01");
		enddate=LocalDate.parse("2026-10-01");
	}
	
	public static double validateprice(double price) throws ShowroomException
	{
		if(price<Min_price || price>Max_price)
		{
			throw new ShowroomException("Please enter correct price ");
		}
		else
			return price;
	}
	
	public static Color validatecolor(String color) throws ShowroomException
	{
		try
		{
			return Color.valueOf(color.toUpperCase());
		}catch(IllegalArgumentException e)
		{
			StringBuilder sb=new StringBuilder("Avavilable colors");
			sb.append(Arrays.toString(Color.values())+"\n");
			sb.append("Choose Correct Color");
		
			throw new ShowroomException(sb.toString());
		}
		
	}
	
	public static Vehicle validatechasino(String chasino,Vehicle[] varr) throws ShowroomException
	{
		Vehicle vn=new Vehicle(chasino);
		boolean t=false;
		for(Vehicle n:varr)
		{
			if(n!=null && n.equals(vn))
			{	
				//System.out.println(n);
				t=true;
			}
		}
		if(t)
		{
			return vn; 
		}
		else
			throw new ShowroomException("Invalid Cahsi No.");
	}
}
