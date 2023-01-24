package libraryMan;

import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.util.Date;

public class libUtils {
	
	public static Map<String,Book> populatebook()
	{
		Map<String,Book> cp=new HashMap<>();
		cp.put("IKIGAI", new Book("IKIGAI","UTKARSH",200,142,LocalDate.parse("2022-04-12"),5));
		cp.put("ALCHEMIST", new Book("ALCHEMIST","TANMAY",400,156,LocalDate.parse("2022-08-24"),8));
		cp.put("THE ANCIENTS", new Book("THE ANCIENTS","AKASH",350,122,LocalDate.parse("2023-08-19"),6));
		cp.put("THE PACIFISTAS", new Book("THE PACIFISTAS","AKASHAY",350,178,LocalDate.parse("2024-12-16"),9));
		cp.put("AFTER", new Book("AFTER","AKASHOBHYA",3000,198,LocalDate.parse("2024-01-18"),10));
		
		return cp;
	}

}
