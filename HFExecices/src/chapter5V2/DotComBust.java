package chapter5V2;

import java.util.ArrayList;
import java.util.Iterator;

import utils.GameHelper;

public class DotComBust {

	private ArrayList<DotCom> targetShips = new ArrayList<DotCom>();
	private GameHelper helper = new GameHelper();
	private int numOfGuesses = 0;


	public static void main(String[] args) {
		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
		//simpleDotComTestDrive();
	}



	
	private void setUpGame() {
		
		targetShips.add(new DotCom("Go2.com"));
		targetShips.add(new DotCom("Pets.com"));
		targetShips.add(new DotCom("eToys.com")); 
		
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink them all in the fewest number of guesses");
		System.out.println("00 for Exit Game!");

		targetShips.forEach(ship -> ship.printPositions());

	}	
		
	
	private void startPlaying() {	
		// loop until kill all ships
		while (!targetShips.isEmpty()) {
			String guess = helper.getUserInput("Enter a position [A-G][0-6]");
			guess = guess.toUpperCase();

			if (!checkUserInput(guess)) continue;
			
			if (guess.equals("00")) {
				System.out.println("Bye!");
				return;
			}
			numOfGuesses++;

			String result = "miss";
			// Use Iterator's remove method to safely remove the element
			Iterator<DotCom> iter = targetShips.iterator(); // check 3 ships
			while (iter.hasNext()) {
				DotCom ship = iter.next();
				if (ship.isAlive() && ship.checkMyself(guess)) { // hit
					ship.removePositionAt(guess);
					result = "hit";
					System.out.println("You hit " + ship.getName());
					if (!ship.isAlive()) {
						targetShips.remove(ship);
						result = "kill";
						System.out.println("and killed " + ship.getName());	
						break; // error if continue loop
					} 
					
				}
				
			}
			
			if (result.equals("miss")) System.out.println(result);
			if (targetShips.isEmpty()) break;
		}

		finishGame();
		
	}


	private boolean checkUserInput(String input){
		
		int axisX = Integer.parseInt(separateCharsAndDigits(input, null));
		if (axisX < 0 || axisX > 6) {
			System.out.println("Out of range X");
			return false;
		}
		char myChar = separateCharsAndDigits(input, 1).charAt(0);
		if (myChar < 'A' || myChar > 'G') {
			System.out.println("Out of range Y");
			return false;
		}
		return true;
	}


	public String separateCharsAndDigits(String input, Integer separate) {
        StringBuilder characters = new StringBuilder();
        StringBuilder digits = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            } else {
                characters.append(c);
            }
        }
        //System.out.println("Characters: " + characters.toString());
        //System.out.println("Digits: " + digits.toString());
		return separate == null ? digits.toString() : characters.toString();
    }

	private void finishGame() {
		System.out.println("All Ships are dead! Your stock is now worthless.");
		System.out.println("It only took you " + numOfGuesses + " guesses.");
	}

}


	// TEST DotCom
//helper.printGrid(targetShips, "0123456", "ABCDEFG");
/*
for (DotCom ship : targetShips) {
	ship.printPositions();
}
System.out.printf("DotCom.totalShip() %d", DotCom.totalShip());
System.out.printf("\ntargetShips.get(1).isAlive() %s", targetShips.get(1).isAlive());
System.out.println();
targetShips.get(1).printPositions();
System.out.println("targetShips.get(1).getName() " + targetShips.get(1).getName());
System.out.println("targetShips.get(1).checkMyself(\"C5\") " + targetShips.get(1).checkMyself("C5"));


List<Character> chars = new ArrayList<>();
List<Character> digits = new ArrayList<>();

chapter5V2.GameHelper.splitNumbersAndChars("C54", chars, digits);
System.out.println(chapter5V2.GameHelper.convertCharsToString(chars));
System.out.println(chapter5V2.GameHelper.convertDigitsToNumber(digits));
*/
	
	
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