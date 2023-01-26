package LibraryManagement;

import static LibraryManagement.IOUtils.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Map;
import LibraryManagement.HandlingExceptions;

public class LibUtils {
	
	public static LocalDate begindate;
	public static LocalDate enddate;
	static
	{
		begindate=parse("01-01-2022");
		enddate=parse("31-12-2025");
	}
	public static void storedetails(String filename,Map<Integer,Book> books) throws FileNotFoundException, IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
		{
			out.writeObject(books);
			System.out.println("Stroed Books Succesfully");
		}
		
	}
	
	private static LocalDate parse(String string) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public static Map<Integer,Book> restoredetails(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File f1=new File(filename);
		if(f1.isFile() && f1.canRead())
		{
			try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(f1)))
			{
				return (Map<Integer,Book>) in.readObject();
			}
		}
		System.out.println("Entered Filename is incorrect");
		return populatebook();
	}
	
	
	public static String validatepwd(String pswd) throws HandlingExceptions
	{
		String s="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[#@$*%]).{5,10}";
		if(pswd.matches(s))
			return s;
		
		throw new HandlingExceptions("Invalid Password.....!!!!!!");
	}
	
	public static String validatename(String name) throws HandlingExceptions
	{
		String p="[A-Z][a-z]*";
		if(name.matches(p))
			return p;
		
		throw new HandlingExceptions("Invalid Name Please Check the input");
	}
	
	public static Map<Integer,Book> validatedate(String date)
	{
		LocalDate dl=parse(date);
		if(dl.isBefore(enddate)||dl.isAfter(begindate))
			
	}
	


}
