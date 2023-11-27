package chapter5V2;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import chapter5.DotCom;

public class GameHelper {
	public String getUserInput(String prompt) {
		String inputLine = null;
		System.out.print(prompt + "   ");
		try {
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0) return null; 
				
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		
		return inputLine;
	}
	
	
	public static ArrayList<String> randomPositions(int id) {
		String verticalAxis = "ABCDEFG";
		ArrayList<String> locs = new ArrayList<String>();
		//ArrayList<ArrayList<String>> locs = new ArrayList<>();
		//locs.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
		int randomDirection, randomY, randomX;
		randomDirection = (int) (Math.random() * 2); // 0 1
		if (randomDirection == 1) { // Vertical
			randomY = (int) (Math.random() * 5);	// 0 1 2 3 4 == A B C D E
			randomX = (int) (Math.random() * 7);	// 0 - 6
			locs.add(verticalAxis.charAt(randomY) + String.valueOf(randomX));
			locs.add(verticalAxis.charAt(randomY + 1) + String.valueOf(randomX));
			locs.add(verticalAxis.charAt(randomY + 2) + String.valueOf(randomX));
		} else { // Horizontal
			randomY = (int) (Math.random() * 7);	// 0 1 2 3 4 5 6 == A B C D E F G
			randomX = (int) (Math.random() * 5);	// 0 - 4
			locs.add(verticalAxis.charAt(randomY) + String.valueOf(randomX));
			locs.add(verticalAxis.charAt(randomY) + String.valueOf(randomX + 1));
			locs.add(verticalAxis.charAt(randomY) + String.valueOf(randomX + 2));
		}
		//System.out.println(locs.toString());
		return locs;
	}
	
	public void printGrid(ArrayList<DotCom> ships, String axisX, String axisY) {
		String[][] grid = new String[8][8];
		// print Axis
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = "";
				if (i == 0 && j >= 1) {
					grid[i][j] = axisX.split("")[j - 1];
				}
				if (j == 0 && i >= 1) {
					grid[i][j] = axisY.split("")[i - 1];
				}
			}
			
		}
		// print positions
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				
			}
		}
	}
	

	public static void splitNumbersAndChars(String input, List<Character> chars, List<Character> digits) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.add(c);
            } else {
                chars.add(c);
            }
        }
    }
	
	public static int convertDigitsToNumber(List<Character> digits) {
        // Ensure the list is not empty
        if (digits.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        int result = 0;
        for (Character digitChar : digits) {
            // Convert character to integer and add it to the result
            int digit = Character.getNumericValue(digitChar);
            result = result * 10 + digit;
        }

        return result;
    }
	
	public static String convertCharsToString(List<Character> chars) {
        // Ensure the list is not empty
        if (chars.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Character charValue : chars) {
            stringBuilder.append(charValue);
        }

        return stringBuilder.toString();
    }
	
}



