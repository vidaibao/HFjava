package utils;

import java.util.ArrayList;


//public interface myFilter<T> {
//	boolean filterFn();
//	T arrayFilter(T arrList, filterFn());
//}

public class MyArrayList {
	public int[] removeElementFromArray(int[] arr, String removeEl) {
		ArrayList<Integer> al = new ArrayList<>();
		int guess = Integer.parseInt(removeEl);
		for (int i : arr) {
			if (i != guess) al.add(i);
		}
		// (Integer i) -> i.intValue(). This operation is necessary because the toArray method 
		// expects an array of primitive int, not Integer objects
		return al.stream().mapToInt(Integer::intValue).toArray();
	}
}
