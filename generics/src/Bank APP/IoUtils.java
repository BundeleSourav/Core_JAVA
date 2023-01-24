package bank;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class IoUtils {
	
	private static double Min_bal;
	
	static 
	{
		Min_bal=5000;
	}
	public static Map<Integer,Account> populate()
	{
		Map<Integer,Account> acts=new HashMap<>();
		Account a1=new Account("Drax",ACType.SAVING,80000,LocalDate.parse("2015-08-10"),"Dr@77");
		Account a2=new Account("Groot",ACType.CURRENT,60000,LocalDate.parse("2018-12-31"),"Groot@54");
		Account a3=new Account("Thor",ACType.DEMAT,90000,LocalDate.parse("2016-02-11"),"God@44");
		Account a4=new Account("Tony",ACType.SAVING,75000,LocalDate.parse("2019-01-18"),"Iron@23");
		Account a5=new Account("Zoro",ACType.FD,60000,LocalDate.parse("2020-10-25"),"Tst@56");
		acts.put(a1.getActno(),a1 );
		acts.put(a2.getActno(),a2 );
		acts.put(a3.getActno(),a3 );
		acts.put(a4.getActno(),a4 );
		acts.put(a5.getActno(),a5 );
		
		return acts;
	}
	
	public static double validatebal(double amount) throws BankException
	{
		if(amount<Min_bal)
			throw new BankException("Insufficients Funds");
		
		else
			return amount;
	}

}
