package utils;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	
	public void printGrid00(ArrayList<DotCom> ships, String axisX, String axisY) {
		Map<String, String> pos = new HashMap<String, String>();

		for (DotCom ship : ships) {
			for (String p : ship.getPostions()) {
				pos.put(ship.getName(), p);
			}
		}
		
		// print Axis
		//ArrayList<String> locs = new ArrayList<String>();
		String str = "";
		for (int i = 0; i <= axisY.length(); i++) {
			if (i == 0) {
				str += "    " + StringHandling.createSpacedString(axisX, 4);
			} else {
				// findLocations()
				String s = findLocations(pos, axisX, axisY.charAt(i - 1));
				str += axisY.charAt(i - 1) + "  " + s;//
			}
			
			System.out.println(str);
			System.out.println();
			str = "";
		}
		
		// System.out.printf("	%4s  %4s  %4s  %4s", pos);
		
		
		
		
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
		ArrayList<ArrayList<Integer>> twoDArrayList = new ArrayList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				
			}
		}
	}
	

	private String findLocations(Map<String, String> pos, String axisX, char c) {
		String s = "";
		for (int i = 0; i < axisX.length(); i++) {
			s = String.valueOf(c) + axisX.charAt(i);
			if (pos.containsValue(s)) {
				
			} else {
				s = "    ";//4s
			}
		}
		
		return s;
	}
	
	// Function to find the key for a given value in a map
    private String getKeyByValue(Map<String, String> map, String value) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null; // If the value is not found
    }
}



