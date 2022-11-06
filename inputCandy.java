package Hackathon;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;


public class inputCandy {
	
	//making an empty hashmap to hold all of the candy data
	static Map<String, String[]> candyDatabase = new HashMap<String, String[]>();
	static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean hasName = false;
		boolean trade = false;
		
		System.out.println("How many default users do you want to add? Use an Int between 1 and 20 please. ");
		int numUsers = Integer.parseInt(keyboard.nextLine());
		
		System.out.println("How many pieces of candy did each user get? Use an Int please. ");
		int numCandy = Integer.parseInt(keyboard.nextLine());
		
		while(numUsers > 0) {
			generateData(numCandy);
			numUsers--;
		}
		
		for(String key : candyDatabase.keySet()) {
			System.out.println(key + " " + Arrays.toString(candyDatabase.get(key)));
		}
		
		System.out.println("\nPress 1 to enter your own candy and 2 to randomly generate what you get. ");
		int numChoice = Integer.parseInt(keyboard.nextLine());
		
		if(numChoice == 1) {
			makeCandy();
		} else if (numChoice == 2) {
			//Scanner nameInput = new Scanner(System.in);
			System.out.println("What is your name? ");
			String name = keyboard.nextLine();
			genOne(name, numCandy);
		}
		
		keyboard.reset();
		System.out.println("The candy database right now looks like \n");
		for(String key : candyDatabase.keySet()) {
			System.out.println(key + " " + Arrays.toString(candyDatabase.get(key)));
		}
		
		System.out.println("\nDo you want to try and trade with other users? Please answer with a yes or no. ");
		//Scanner candyAns = new Scanner(System.in);
		String ans = keyboard.nextLine();
		
		if(ans.toLowerCase().equals("yes")) trade = true;
		if(trade == true) trading();
		
		System.out.println("Thank you so much for trying our project!");
	}
	
	public static void genOne(String name, int numCandy) {
		Candy acc = new Candy(name);
		String[] candy = acc.generateCandy(numCandy);

		candyDatabase.put(acc.getName(), candy);	
	}
	
	public static void generateData(int numCandy) {
		int tempNumCandy = numCandy;
		Random generate = new Random();
		String[] listOfNames = {"Kevin", "Luis", "Izam", "Luke", "Chris", "Fred", "Liam", "Delila", "Lily", "Dina", "Lillia", "Miona", "Olivia", "Emma", "Charlotte", "Amelia", "Ava", "Sophia", "Isabella", "Mia"};
		
		Candy acc = new Candy(listOfNames[generate.nextInt(20)].toLowerCase());
		String[] candy = acc.generateCandy(numCandy);
		if(!(candyDatabase.containsKey(acc.getName()))) {
			candyDatabase.put(acc.getName(), candy);
		} else {
			generateData(tempNumCandy);
		}
			
	}
	
	public static void trading() {
		boolean hasCandy = true;
		boolean continueTrading = true;
		//Scanner scannersSuck = new Scanner(System.in);
		
		while(continueTrading == true) {
			System.out.println("Please enter your name again. ");
			String myName = keyboard.nextLine();
			
			System.out.println("What are you willing to trade? ");
			String give = keyboard.nextLine();
			
			System.out.println("Who do you want to trade with? ");
			String tradeName = keyboard.nextLine();
			
			System.out.println("What candy do you want from them? ");
			String want = keyboard.nextLine();
			
			//creating a reference to the array of the person that has the candy we want
			String partnerArr[] = candyDatabase.get(tradeName.toLowerCase());
			
			if(Arrays.asList(partnerArr).contains(want)) {
				for(int i = 0; i < partnerArr.length; i++) {
					//changing what they are giving us to what we are giving them
					if(partnerArr[i].equals(want)) {
						partnerArr[i] = give;
						break;
					} 
				}
			} else {
				System.out.println("The user did not have the candy you wanted");
				System.out.println("Do you want to continue trading? Please input yes or no. ");
				
				String ans = keyboard.nextLine();
				
				if(ans.toLowerCase().equals("yes")) continueTrading = true;
				continue;
			}
			
			String[] myArr = candyDatabase.get(myName.toLowerCase());
			
			for(int i = 0; i < myArr.length; i++) {
				if(myArr[i].equals(give)) {
					myArr[i] = want;
					break;
				}
			}
			
			for(String key : candyDatabase.keySet()) {
				System.out.println(key + " " + Arrays.toString(candyDatabase.get(key)));
			}
			
			System.out.println("Do you want to continue trading? Please input yes or no. ");
			String ans = keyboard.nextLine();
			if(ans.toLowerCase().equals("yes")) continueTrading = true;
			else break;
			
			if(!(continueTrading)) break;
		}
	}
	
	public static void makeCandy() {
		System.out.println("What is your name? ");
		//Scanner nameInputHelp = new Scanner(System.in);
		String name = keyboard.nextLine();
		
		System.out.println("How many pieces of candy did you get for Halloween? Use an Int please. ");
		int num = Integer.parseInt(keyboard.nextLine());
		
		String[] allCandy = new String[num];
		
		System.out.println("Enter in a piece of candy then press enter");
		for(int i = 0; i < allCandy.length; i++) {
			Scanner keyboard = new Scanner(System.in);
			String candy = keyboard.nextLine();
			allCandy[i] = candy;
		}
				
		candyDatabase.put(name, allCandy);
		
		for(String key : candyDatabase.keySet()) {
			System.out.println(key + " " + Arrays.toString(candyDatabase.get(key)));
		}
		
		keyboard.reset();
	}
}
