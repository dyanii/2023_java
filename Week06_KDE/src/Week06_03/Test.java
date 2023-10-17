package Week06_03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

enum Type{
	MEAT, FISH, OTHER
}

public class Test {
	public static void main(String[] args) {
		List<Food> foodList = new ArrayList<>();
		foodList.add(new Food("Salad", true, 150, Food.Type.OTHER));
		foodList.add(new Food("Steak", false, 500, Food.Type.MEAT));
		foodList.add(new Food("Soup", true, 200, Food.Type.OTHER));
		foodList.add(new Food("Fish&Chips", false, 800, Food.Type.FISH));
		
		List<String> filterdFood = foodList.stream()
				.filter(food-> food.isVege() && food.getCalories()<= 300)
				.map(Food::getName)
				.collect(Collectors.toList());
		
		System.out.println(filterdFood);
	}
}
