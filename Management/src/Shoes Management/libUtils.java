package ShoesManagement;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Map;
import static ShoesManagement.IOUtils.*;

public class libUtils {
	
	private static LocalDate begindate;
	private static LocalDate enddate;
	
	static
	{
		begindate=LocalDate.parse("2022-01-01");
		enddate=LocalDate.parse("2022-12-31");
	}

	public static void display(String filename,Map<Integer,Shoes> map) throws FileNotFoundException, IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
		{
			 out.writeObject(filename);
			 
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Map<Integer,Shoes> restoredetails(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File f1=new File(filename);
		if(f1.isFile() && f1.canRead())
		{
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(f1)))
		{
			return (Map<Integer,Shoes>) in.readObject();
		}
		}
		
		return populate();
	}
	
	public static Category validatetype(String type,Map<Integer,Shoes> maps) throws ShoesException
	{
		try
		{
			return Category.valueOf(type.toUpperCase());
		}catch(IllegalArgumentException e)
		{
			StringBuilder sb=new StringBuilder("Choose from availabe category");
			sb.append(Arrays.toString(Category.values())+"\n");
			sb.append("Choose your Category");
			
			throw new ShoesException(sb.toString());
			
		}
	}
	
	public static boolean validate(LocalDate date)
	{
		LocalDate md2=date.minusMonths(4);
		if(md2.isBefore(date))
			return true;
		
		return false;
	}
	
	public static boolean validate2(LocalDate date)
	{
		LocalDate md2=date.minusMonths(6);
		if(md2.isBefore(date))
			return true;
		
		return false;
	}
	
	//public static boolean validateqty
	
}
