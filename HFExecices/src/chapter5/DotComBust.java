package chapter5;

import utils.GameHelper;

public class DotComBust {

	public static void main(String[] args) {
		
		simpleDotComTestDrive();
	}

	
	private static void simpleDotComTestDrive() {
		// TODO Auto-generated method stub
		SimpleDotCom sg = new SimpleDotCom();
		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		int randomNum = (int) (Math.random() * 5);
		int[] locations = {randomNum, randomNum + 1, randomNum + 2};
		sg.setLocationCells(locations);
		
		boolean isAlive = true;
		
		while (isAlive) {
			String guess = helper.getUserInput("Enter a number");
			
			String result = sg.checkYouself(guess);
			
			numOfGuesses++;
			
			if (result.equals("kill")) {
				isAlive = false;
				System.out.println("You took " + numOfGuesses + " guesses");
			}
			
		}
		
		
		
		
	}

}

class SimpleDotCom {
	private int[] locationCells;
	int numOfHits;
	
	String checkYouself(String strGuess) {
		int guess = Integer.parseInt(strGuess);
		String result = "miss";
		
		for (int cell : locationCells) {
			if (guess == cell) {
				result = "hit";
				numOfHits++;
				break;
			}
		}
		
		if (numOfHits == locationCells.length) {
			result = "kill";
		}
		System.out.println(result);
		return result;
	}
	
	
	void setLocationCells(int[] locs) {
		this.locationCells = locs;
	}
}