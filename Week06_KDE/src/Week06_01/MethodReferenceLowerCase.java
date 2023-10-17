package Week06_01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceLowerCase {
	public static void main(String[] args) {
		List<String> listOfNames = Arrays.asList(new String[]
				{"Apple", "Banana", "Cherry"});
		
		List<String> sublist = listOfNames.stream()
				.map(String::toLowerCase)
				.sorted()
				.collect(Collectors.toList());
		
		System.out.println(sublist);
	}
}
