package practice;

import java.util.Comparator;

public class Basics{
    public static Comparator<Integer> getComp(){
        return new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                if(o1<o2){
                    return 1;
                }
                else if(o1>o2){
                    return -1;
                }
                return 0;

            }
        };
    }
}
