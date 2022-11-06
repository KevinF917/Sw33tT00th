package Hackathon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Candy {
	private String name;
	
	public Candy() {
		name = null;
	}
	
	public Candy(String accountName) {
		name = accountName;
	}
	
	public String getName() {
		return name;
	}
	
	public String[] generateCandy(int arrSize) {
		String[] candyBalance = new String[arrSize];
		Integer[] numOfCandy = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		String[] candy = {"skittles", "jolly ranchers", "tootsie pops", "hersheys", "sour patch kids", "milky ways", "kit kats", "m&ms", "twizzlers", "twix"};
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		for(int i = 0; i < numOfCandy.length; i++) {
			map.put(numOfCandy[i], candy[i]);
		}
		
		for(int i = 0; i < candyBalance.length; i++) {
			List<Integer> valuesList = new ArrayList<Integer>(map.keySet());
			int randomIndex = new Random().nextInt(valuesList.size());
			Integer randomValue = valuesList.get(randomIndex);
			
			candyBalance[i] = map.get(randomValue);
		}

		return candyBalance;
	}
}
