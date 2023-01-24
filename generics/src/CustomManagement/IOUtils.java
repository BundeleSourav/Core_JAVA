package CustomManagement;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import CustomManagement.Services;

public class IOUtils {

	
	public static List<Customer> populate() throws CustomException
	{
		List<Customer> ctlist=new ArrayList<>();
		ctlist.add(new Customer("Akon","akon@gmail.com","Akon@77",LocalDate.parse("2022-12-08"),Services.GOLD));
		ctlist.add(new Customer("Groot","groot@kmail.com","Gru@45",LocalDate.parse("2020-06-23"),Services.DIAMOND));
		ctlist.add(new Customer("Matt","matt@lmail.com","Matt@63",LocalDate.parse("2026-07-17"),Services.SILVER));
		ctlist.add(new Customer("Damon","Damon@gmaiil.com","Damo@82",LocalDate.parse("2021-01-01"),Services.GOLD));
		ctlist.add(new Customer("Klaus","klaus@gmail.com","klaus@25",LocalDate.parse("2019-08-01"),Services.PLATINUM));
		
		return ctlist;
	}
}
