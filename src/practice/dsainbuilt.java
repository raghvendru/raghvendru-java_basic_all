package practice;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import static practice.Basics.getComp;

public class dsainbuilt {
    public static void main(String[] args) {
//        Stack<Integer> st = new Stack<>();
//        st.push(2);
//        st.push(3);
//        st.push((5));
//        st.pop();
//        System.out.println( st.peek());
//        System.out.println(st);

        Deque<Integer> q = new ArrayDeque<>();
        q.offer(2);
        q.offer(5);
        q.offer(1);
        q.addFirst(6);//addLast,getFirst,getlast,remoiveFirst,removeLats
        System.out.println(q.peek());
        System.out.println(q);
        while(q.isEmpty() == false){
            System.out.println(q.peek());
            q.poll();
        }

        Queue<Integer> q1 = new PriorityQueue<>(getComp());
        q1.offer(2);
        q1.offer(5);
        q1.offer(1);
        System.out.println(q1.peek());

        System.out.println(q1);

        Map<Integer,Integer> hmm = new HashMap<>();
        hmm.put(1,2);
        hmm.put(2,3);
        hmm.put(3,4);
        System.out.println(hmm);

        System.out.println(hmm.remove(2));
        System.out.println(hmm.get(2));

        List<Integer> al = new ArrayList<>();
        al.add(3);
        al.add(2);
        al.add(5);
        al.add(0);
       // Collections.sort(al,(n1,n2)->n2-n1);
        System.out.println(al);

       Collections.sort(al,new Comparator<Integer>(){
           @Override
           public int compare(Integer o1,Integer o2){
               if(o1<o2){
                   return 1;
               }else if(o1>o2) {
                   return -1;
               }
               return 0;
           }
       });
        System.out.println(al);
    }
}
