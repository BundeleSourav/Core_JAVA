package libraryMan;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Map;

import static libraryMan.libUtils.populatebook;

public class IOUtils {
	
	public static LocalDate begindate;
	public static LocalDate enddate;
	
	static
	{
		begindate=LocalDate.parse("2022-01-01");
		enddate=LocalDate.parse("2025-12-31");
	}
	
	public static void display(String filename,Map<String,Book> map) throws IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
		{
			out.writeObject(map);
			System.out.println("Stored Books Successfully....");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,Book> restoreDetails(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File f1=new File(filename);
		if(f1.isFile() && f1.canRead())
		{
			try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(f1)))
			{
				return (Map<String,Book>) in.readObject();
			}
		}
		System.out.println("Invalid files.......");
		return populatebook();
	}
	
	public static String validatepaswd(String pswd) throws HandlingException
	{
		String str="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[#@$*%]).{5,10}";
		if(pswd.matches(str))
			return pswd;
		
		throw new HandlingException("Invalid Password!!!");
	}
	
	public static String validatename(String name) throws HandlingException
	{
		String str="[A-Z][a-z]*";
		if(name.matches(str))
			return name;
		
		throw new HandlingException("Enter Correct Name!!!!");
	}
	
	public static void validatedate(String date,Map<String,Book> maps) throws HandlingException
	{
		LocalDate md= LocalDate.parse(date);
		for(Book n:maps.values())
		{
		if(md.isBefore(begindate) || md.isAfter(enddate))
		{
			throw new HandlingException("Invalid Date Input");
		}
		else if(n.getdate().equals(md))
			System.out.println(n);
		}
	}
	
	public static void findbyauthor(String author,Map<String,Book> hmaps) throws HandlingException
	{
		boolean flag=false;
		for(Book c:hmaps.values())
		{
			if(c.getAuthor().equals(author))
			{
				System.out.println(c);
				flag=true;
			}
		}
		if(flag)
			System.out.println("Available Details");
		else
			throw new HandlingException("Author name is unrecognized");
	}
	
}
