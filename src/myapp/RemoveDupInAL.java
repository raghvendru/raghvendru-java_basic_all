package myapp;

import java.util.*;
import java.util.List;

public class RemoveDupInAL {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>();
        al.add("raghu");
        al.add("Akash");
        al.add("nikhita");
        al.add("raghu");
        al.add("nikhita");
        System.out.println(al);

        Set<String>  lhs = new LinkedHashSet<>(al);
        al.clear();
        al.addAll(lhs);
        System.out.println(al);
    }
}
