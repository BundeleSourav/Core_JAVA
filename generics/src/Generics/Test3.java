package Generics;

import java.util.List;
import static Generics.Genutils.*;

public class Test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Orange> oranges=List.of(new Orange(),new Orange(),new Orange());
		displayTests(oranges);
	}

}
