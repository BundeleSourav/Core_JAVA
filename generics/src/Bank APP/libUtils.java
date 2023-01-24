package bank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Map;
import static bank.IoUtils.*;

public class libUtils {
	
	public static LocalDate begindate;
	public static LocalDate enddate;
	
	static 
	{
		begindate=LocalDate.parse("2000-12-08");
		enddate=LocalDate.parse("2030-12-31");
	}
	
	public static void display(String filename,Map<Integer,Account> maps) throws FileNotFoundException, IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
		{
			out.writeObject(maps);
			System.out.println("Account Registered");
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Map<Integer,Account> restoredetails(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File f1=new File(filename);
		if(f1.isFile() && f1.canRead())
		{
			try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(f1)))
			{
				return (Map<Integer,Account>) in.readObject();
			}
		}
		return populate();
	}
	
	public static String validatename(String name) throws BankException
	{
		String str="[A-Z][a-z]*";
		if(name.matches(str))
		{
			return name;
		}
		else
			throw new BankException("Invalid Name");
	}
	
	public static String validatepswd(String pswd) throws BankException
	{
		String pd="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[#@$*%]).{5,10}";
		if(pswd.matches(pd))
			return pswd;
		
		throw new BankException("Invalid Password");
	}
	public static Account findbyacno(int acno,Map<Integer,Account> hmap) throws BankException
	{
		boolean f=false;
		for(Account a:hmap.values())
		{
			if(hmap.containsKey(acno))
			{
				return a;
			}
		}	
		return null;
//		else
//			throw new BankException("Invalid Account Number");
	}
	public static Account login(int acno,String pswd,Map<Integer,Account> imap) throws BankException
	{
		//validatename(name);
		String p=validatepswd(pswd);
		Account a=findbyacno(acno,imap);
		for(Account q:imap.values())
		{
		if(imap.containsValue(a))
			return q;
		}
		return null;
//		else
//			throw new BankException("Invalid Credentials");
		
	}
	
}
