package Generics;

import java.util.List;
import java.util.Set;
import static Generics.Genutils.*;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1=List.of(10, 20, 30, 40, 50);
		Set<Double> dset=Set.of(1.02, 2.35, 3.21, 2.52, 4.32);
		
		System.out.println("Sum:- "+findSqrt(l1));
		System.out.println("Sum:- "+findSqrt(dset));
	
	
	}

}
