package LibraryManagement;

import java.util.HashMap;
import java.util.Map;
import static java.time.LocalDate.parse;
public class IOUtils {
	
	public static Map<Integer,Book> populatebook()
	{
		Map<Integer,Book> map=new HashMap<>(); 
		map.put(121, new Book(121,"IKIGAI","IDK",parse("2019-05-12")));
		map.put(107, new Book(107,"ALCHEMIST","DK",parse("2018-11-24")));
		map.put(93, new Book(93,"AFTER","FDI",parse("2020-12-18")));
		map.put(88, new Book(88,"ENTREPRENUER","JDK",parse("2022-10-14")));
		map.put(97, new Book(97,"MOON","KKM",parse("2015-08-05")));
		return map;
	}

}
