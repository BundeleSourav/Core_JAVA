package TaskManagement;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class IOutils {
	
	public static Map<Integer,Task> populate()
	{
		Map<Integer,Task> map=new HashMap<>();
		Task t1=new Task();
		Task T1=new Task("Workout","Daily",LocalDate.parse("2022-04-25"));
		Task T2=new Task("Yoga","Daily",LocalDate.parse("2022-08-01"));
		Task T3=new Task("Meditation","Daily",LocalDate.parse("2022-01-28"));
		Task T4=new Task("Study","Daily",LocalDate.parse("2022-02-07"));
		Task T5=new Task("Sports","Weekly",LocalDate.parse("2022-01-01"));
		map.put(T1.getTaskid(), T1);
		map.put(T2.getTaskid(), T2);
		map.put(T3.getTaskid(), T3);
		map.put(T4.getTaskid(), T4);
		map.put(T5.getTaskid(), T5);
		
		return map;
	}

}
