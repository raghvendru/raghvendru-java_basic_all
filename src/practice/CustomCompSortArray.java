package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static practice.Basics.getComp;

public class CustomCompSortArray {
    public static void main(String[] args) {
        List<Integer> al  = new ArrayList<>();
        al.add(6);
        al.add(5);
        al.add(3);
        al.add(8);
        Collections.sort(al,getComp());

    }
}
