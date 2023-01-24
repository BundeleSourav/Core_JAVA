package Generics;
import java.util.List;
import java.util.Set;

import static Generics.Genutils.*;
public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1=List.of(10, 20, 30, 40, 40);
		
		printDetails(l1);
		System.out.println("------------");
		printDetails1(l1);
		
		
		Set<Double> dset=Set.of(1.00, 2.34, 3.20, 2.52, 4.23);
		printDetails(dset);
		System.out.println("---------");
		printDetails1(dset);
	}

}
