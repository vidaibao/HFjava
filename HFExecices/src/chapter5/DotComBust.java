package chapter5;

import java.util.ArrayList;
import utils.GameHelper;

public class DotComBust {

	public static void main(String[] args) {
		sinkDotCom();
		//simpleDotComTestDrive();
	}

	
	private static void sinkDotCom() {
		ArrayList<String> locations = new ArrayList<String>();
		DotComShip shipGoto = new DotComShip("Go2.com");
		DotComShip shipPets = new DotComShip("Pets.com");
		DotComShip shipAskMe = new DotComShip("AskMe.com"); 
		
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		
		boolean isAlive = true;
		while (isAlive) {
			String guess = helper.getUserInput("Enter a position [A-G][0-6]");
			
			
			
			
			
			
			
			
		}
		
		
		
	}

/*
	private static void simpleDotComTestDrive() {
		// TODO Auto-generated method stub
		SimpleDotCom sg = new SimpleDotCom();
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		
		int randomNum = (int) (Math.random() * 5);	// 0 1 2 3 4
		int[] locations = {randomNum, randomNum + 1, randomNum + 2};
		sg.setLocationCells(locations);
		
		
		boolean isAlive = true;
		
		while (isAlive) {
			String guess = helper.getUserInput("Enter a number");
			
			String result = sg.checkYouself(guess);
			
//			if (result.equals("hit")) {
//				MyArrayList myAl = new MyArrayList();
//				//sg.setLocationCells(myAl.removeElementFromArray(locations, guess)); 
//			}
			numOfGuesses++;
			
			if (result.equals("kill")) {
				isAlive = false;
				System.out.println("You took " + numOfGuesses + " guesses");
			}
			
		}
		
		
		
		
	}
*/

	

}


class DotComShip {
	private String name;
	private ArrayList<String> postions;
	
	
	public String getName() {
		return name;
	}

	public ArrayList<String> getPostions() {
		return postions;
	}

	public DotComShip(String name) {
		super();
		this.name = name;
		this.postions = randomPositions();
	}

	private ArrayList<String> randomPositions() {
		String verticalAxis = "ABCDEFG";
		ArrayList<String> locs = new ArrayList<String>();
		int randomDirection, randomY, randomX;
		randomDirection = (int) (Math.random() * 2); // 0 1
		if (randomDirection == 1) { // Vertical
			randomY = (int) (Math.random() * 5);	// 0 1 2 3 4 == A B C D E
			randomX = (int) (Math.random() * 7);	// 0 - 6
			locs.add(verticalAxis.charAt(randomX) + String.valueOf(randomX));
			locs.add(verticalAxis.charAt(randomX + 1) + String.valueOf(randomX));
			locs.add(verticalAxis.charAt(randomX + 2) + String.valueOf(randomX));
		} else { // Horizontal
			randomX = (int) (Math.random() * 5);	// 0 1 2 3 4 == A B C D E
			randomY = (int) (Math.random() * 7);	// 0 - 6
			locs.add(verticalAxis.charAt(randomY) + String.valueOf(randomX));
			locs.add(verticalAxis.charAt(randomY) + String.valueOf(randomX + 1));
			locs.add(verticalAxis.charAt(randomY) + String.valueOf(randomX + 2));
		}
		return locs;
	}
	
	public boolean removePositionAt(String element) {
		if (postions.isEmpty()) return false;
		return postions.removeIf(pos -> pos.equals(element));
	}
	
	public String toString() {
		return String.join(", ", postions);
	}
}

/*
class DotCom {
	private ArrayList<String> locationCells = new ArrayList<String>();
	
	String checkYourself(String strGuess) {
		String result = "miss";
		
		int index = locationCells.indexOf(strGuess);
		if (index >= 0) {
			locationCells.remove(index);
			if (locationCells.isEmpty()) return "kill"; 
			return "hit";
		}
		return result;
	}
	
	void setLocationCells(ArrayList<String> locs) {
		locationCells = new ArrayList<String>(locs);
	}
}



class SimpleDotCom {
	private int[] locationCells;
	int countOfHit;
	
	String checkYouself(String strGuess) {
		int guess = Integer.parseInt(strGuess);
		String result = "miss";
		
		for (int i = 0; i < locationCells.length; i++) {
			if (guess == locationCells[i]) {
				result = "hit";
				locationCells[i] = Integer.MIN_VALUE;
				countOfHit++;
				break;
			}
		}
		
		if (countOfHit == locationCells.length) {
			result = "kill";
		}
		System.out.println(result);
		return result;
	}
	
	
	void setLocationCells(int[] locs) {
		this.locationCells = locs;
		//numOfHits = this.locationCells.length;
		System.out.println(Arrays.toString(locs));
	}
}*/