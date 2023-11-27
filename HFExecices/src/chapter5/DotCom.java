package chapter5;

import java.util.ArrayList;
import java.util.Arrays;

public class DotCom {
	private static int numOfShip = 0;
	private int id = 1;
	private String name;
	private ArrayList<String> positions;
	private ArrayList<Integer> iPositions;
	
	
	public static int totalShip() {
		return numOfShip;
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<String> getPostions() {
		return positions;
	}

	public ArrayList<Integer> getiPostions() {
		return iPositions;
	}

	public DotCom(String name) {
		super();
		this.name = name;
		this.id = numOfShip++;
		Result2List result = randomPositions();
		this.positions = result.getListString();
		this.iPositions = result.getListInt();
	}

	private Result2List randomPositions() {
		String verticalAxis = "ABCDEFG";
		ArrayList<String> locs = new ArrayList<String>();
		ArrayList<Integer> ilocs = new ArrayList<Integer>();
		int randomDirection, randomY, randomX;
		randomDirection = (int) (Math.random() * 2); // 0 1
		if (randomDirection == 1) { // Vertical
			randomY = (int) (Math.random() * 5);	// 0 1 2 3 4 == A B C D E
			randomX = (int) (Math.random() * 7);	// 0 - 6
			locs.add(verticalAxis.charAt(randomY) + String.valueOf(randomX));
			locs.add(verticalAxis.charAt(randomY + 1) + String.valueOf(randomX));
			locs.add(verticalAxis.charAt(randomY + 2) + String.valueOf(randomX));
			//ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(randomY, randomX));
			ilocs.addAll(Arrays.asList(id, randomY, randomX));
			ilocs.addAll(Arrays.asList(id, randomY + 1, randomX));
			ilocs.addAll(Arrays.asList(id, randomY + 2, randomX));
		} else { // Horizontal
			randomY = (int) (Math.random() * 7);	// 0 1 2 3 4  5 6 == A B C D E F G
			randomX = (int) (Math.random() * 5);	// 0 - 4
			locs.add(verticalAxis.charAt(randomY) + String.valueOf(randomX));
			locs.add(verticalAxis.charAt(randomY) + String.valueOf(randomX + 1));
			locs.add(verticalAxis.charAt(randomY) + String.valueOf(randomX + 2));
			ilocs.addAll(Arrays.asList(id, randomY, randomX));
			ilocs.addAll(Arrays.asList(id, randomY, randomX + 1));
			ilocs.addAll(Arrays.asList(id, randomY, randomX + 2));
		}
		return new Result2List(ilocs, locs);
	}
	
	public boolean checkMyself(String element) {
		return positions.contains(element);
	}
	
	public boolean isAlive() {
		return positions.isEmpty();
	}
	
	public boolean removePositionAt(String element) {
		if (positions.isEmpty()) return false;
		return positions.removeIf(pos -> pos.equals(element));
	}
	
	public String toString() {
		return String.join(", ", positions);
	}

	public int getId() {
		return id;
	}
}



//Custom class to hold the result
class Result2List {
  private final ArrayList<Integer> list1;
  private final ArrayList<String> list2;

  public Result2List(ArrayList<Integer> list1, ArrayList<String> list2) {
      this.list1 = list1;
      this.list2 = list2;
  }

  public ArrayList<Integer> getListInt() {
      return list1;
  }

  public ArrayList<String> getListString() {
      return list2;
  }
}