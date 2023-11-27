package chapter5V2;

import java.util.ArrayList;

public class DotCom {
	private static int numOfShip = 0;
	
	private int id;
	private String name;
	private ArrayList<String> positions;
	
	
	public static int totalShip() {
		return numOfShip;
	}
	
	public String getName() {
		return name;
	}

	public ArrayList<String> getPostions() {
		return positions;
	}

	public DotCom(String name) {
		super();
		this.name = name;
		this.id = ++numOfShip;
		this.positions = GameHelper.randomPositions(this.id);
	}

	
	
	public boolean checkMyself(String element) {
		return positions.contains(element);
	}
	
	public boolean isAlive() {
		return (positions.size() != 0);
	}
	
	public boolean removePositionAt(String element) {
		if (positions.isEmpty()) return false;
		return positions.removeIf(pos -> pos.equals(element));
	}
	
	public void printPositions() {
		System.out.println(positions);
	}

	public int getId() {
		return id;
	}
}



