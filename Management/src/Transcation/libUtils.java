package Transcation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import static Transcation.IoUtils.*;
public class libUtils {

	
	public static void display(String filename,List<Summary> list) throws IOException
	{
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(filename)))
		{
			out.writeObject(list);
			System.out.println("Elements added succesfully");
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public static List<Summary> restoredetails(String filename) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File f1=new File(filename);
		if(f1.isFile() && f1.canRead())
		{
			try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(f1)))
					{
						return (List<Summary>) in.readObject();
					}
			
			
		}
		return populate();
	}
	
	
}
