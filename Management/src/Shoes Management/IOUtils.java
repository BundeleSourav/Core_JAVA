package ShoesManagement;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class IOUtils {

	
	public static Map<Integer,Shoes> populate()
	{
		Map<Integer,Shoes> map=new HashMap<>();
		
		Shoes s1=new Shoes(Category.MENS_RUNNING,LocalDate.parse("2022-04-08"),850, LocalDate.parse("2022-10-15"),7,1200,"Black", 10);
		Shoes s2=new Shoes(Category.WOMEN_RUNNING,LocalDate.parse("2022-05-20"),500, LocalDate.parse("2022-09-23"),8,1000,"White", 15);
		Shoes s3=new Shoes(Category.MENS_WALKING,LocalDate.parse("2022-06-19"),700, LocalDate.parse("2022-09-05"),9,900,"Blue", 12);
		Shoes s4=new Shoes(Category.MENS_SNEAKER,LocalDate.parse("2022-07-11"),1500, LocalDate.parse("2022-08-12"),8,1500,"Red", 20);
		Shoes s5=new Shoes(Category.WOMEN_WALKING,LocalDate.parse("2022-10-12"),400, LocalDate.parse("2022-11-01"),7,800,"Black", 20);
		Shoes s6=new Shoes(Category.MENS_RUNNING,LocalDate.parse("2022-01-30"),250, LocalDate.parse("2022-10-30"),7,1000,"White", 30);
		
		map.put(s1.getSid(), s1);
		map.put(s2.getSid(), s2);
		map.put(s3.getSid(), s3);
		map.put(s4.getSid(), s4);
		map.put(s5.getSid(), s5);
		map.put(s6.getSid(), s6);
		
		return map;
	
	}
}
