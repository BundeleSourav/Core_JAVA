package Generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Genutils {
	
	 
		public static void printDetails(Collection<?> collection)
		{
			Iterator<?> itr=collection.iterator();
			while(itr.hasNext())
				System.out.println(itr.next());
		}
		
		public static <T> void printDetails1(Collection<T> collection)
		{
			Iterator<T> itr=collection.iterator();
			while(itr.hasNext())
				System.out.println(itr.next());
		}
		
		public static void displayTests(List<? extends Fruit> basket)
		{
			Iterator<? extends Fruit> itr=basket.iterator();
			while(itr.hasNext())
				System.out.println(itr.next().taste());
		}
		
		public static double findSqrt(Collection<? extends Number> collection)
		{
			double sum=0;
			for( Number o:collection)
				sum+=o.doubleValue();
			
			return Math.sqrt(sum);
		}

}
