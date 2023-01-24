package Transcation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IoUtils {
	
	public static List<Summary> populate()
	{
		List<Summary> lists=new ArrayList<>();
		
		lists.add(new Summary(LocalDate.parse("2022-01-01"),Narration.Salary_Credit,0,50000));
		lists.add(new Summary(LocalDate.parse("2022-01-01"),Narration.Mobile_Recharge,300,0));
		lists.add(new Summary(LocalDate.parse("2022-01-02"),Narration.DTH_Recharge,1000,0));
		lists.add(new Summary(LocalDate.parse("2022-01-02"),Narration.Rent_Transfer,11000,0));
		lists.add(new Summary(LocalDate.parse("2022-01-02"),Narration.CashBack_Paytm,0,1000));
		lists.add(new Summary(LocalDate.parse("2022-01-05"),Narration.Shopping,5000,0));
		lists.add(new Summary(LocalDate.parse("2022-01-10"),Narration.Shopping,7000,0));
		lists.add(new Summary(LocalDate.parse("2022-01-15"),Narration.CashBack_Paytm,0,3000));
		lists.add(new Summary(LocalDate.parse("2022-01-25"),Narration.Mobile_purchase,10000,0));
		lists.add(new Summary(LocalDate.parse("2022-01-31"),Narration.Dinning,1200,0));
		
		
		
		
		return lists;
	}

}
