package Transaction;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TUtils {
	
	public static Double sumofall() throws IOException
	{
		String[] arr=new String[4];
		String str;
		Double d1=0.0;
		BufferedReader br=new BufferedReader(new FileReader("F:\\Submmited\\Transaction.txt"));
		while((str=br.readLine())!=null)
		{
			arr=str.split(",");
			d1=d1+Double.parseDouble(arr[3]);
		}
		return d1;
	}
	
	public static double max() throws NumberFormatException, IOException
	{
		String[] arr1=new String[4];
		String str;
		double deposit=0.0;
		BufferedReader br1=new BufferedReader(new FileReader("F:\\\\Submmited\\\\Transaction.txt"));
		while((str=br1.readLine())!=null)
		{
			arr1=str.split(",");
			if(deposit<Double.parseDouble(arr1[3]))
				deposit=Double.parseDouble(arr1[3]);
		}
		return deposit;
	}
	
	
	public static double shoppingexpenses() throws NumberFormatException, IOException
	{
		String[] arr2=new String[4];
		String shop="Shopping";
		String str2;
		double wdraw=0.0;
		BufferedReader br2=new BufferedReader(new FileReader("F:\\Submmited\\Transaction.txt"));
		while((str2=br2.readLine())!=null)
		{
			arr2=str2.split(",");
			if(shop.equals(arr2[1]))
				wdraw=wdraw+Double.parseDouble(arr2[2]);
		}
		return wdraw;
	}
}
