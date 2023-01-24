package TaskManagement;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class libUtils {
	
	public static Status validatestatus(String status) throws TaskException
	{
		try 
		{
			return Status.valueOf(status.toUpperCase());
		}catch(IllegalArgumentException i)
		{
			StringBuilder sb=new StringBuilder("Choose from available status");
			sb.append(Arrays.toString(Status.values())+"\n");
			sb.append("Choose correct status");
			
			throw new TaskException(sb.toString());
		}
	}
	
	public static LocalDate findbydate(String date, Map<Integer,Task> maps) throws TaskException
	{
		try
		{
			return LocalDate.parse(date);
		}catch(Exception e) {
			throw new TaskException("Invalid");
		}
	}

}
