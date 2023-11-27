package utils;

import java.util.ArrayList;

//Custom class to hold the result
public class Result2List {
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


