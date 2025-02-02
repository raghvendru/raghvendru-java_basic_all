package Heap;
import java.util.*;

public class ImplMInHeap {
    private List<Integer> arr; // list to store the min-heap
    private int count; // to store the count of elements in min-heap
    public ImplMInHeap() {
        arr = new ArrayList<>();
        count = 0;
    }
    private void heapifyUp(List<Integer> arr, int ind) {
        int parentInd = (ind - 1)/2;
        if(ind > 0 && arr.get(ind) < arr.get(parentInd)) {
            int temp = arr.get(ind);
            arr.set(ind, arr.get(parentInd));
            arr.set(parentInd, temp);
            heapifyUp(arr, parentInd);
        }

        return;
    }
    private void heapifyDown(List<Integer> arr, int ind) {
        int n = arr.size(); // Size of the array
        int smallestInd = ind;
        int leftChildInd = 2*ind + 1;
        int rightChildInd = 2*ind + 2;
        if(leftChildInd < n && arr.get(leftChildInd) < arr.get(smallestInd))
            smallestInd = leftChildInd;
        if(rightChildInd < n && arr.get(rightChildInd) < arr.get(smallestInd))
            smallestInd = rightChildInd;
        if(smallestInd != ind) {
            int temp = arr.get(smallestInd);
            arr.set(smallestInd, arr.get(ind));
            arr.set(ind, temp);
            heapifyDown(arr, smallestInd);
        }

        return;
    }
    public void initializeHeap(){
        arr.clear();
        count = 0;
    }
    public void insert(int key){
        arr.add(key);
        heapifyUp(arr, count);
        count = count+1; // Increment the counter;

        return;
    }
    public void changeKey(int index, int new_val){
        if(arr.get(index) > new_val) {
            arr.set(index, new_val);
            heapifyUp(arr, index);
        }
        else {
            arr.set(index, new_val);
            heapifyDown(arr, index);
        }
        return;
    }
    public void extractMin(){
        int ele = arr.get(0); // minimum value in the heap
        // Swap the top value with the value at last index
        int temp = arr.get(count - 1);
        arr.set(count - 1, arr.get(0));
        arr.set(0, temp);
        arr.remove(count - 1); // Pop the minimum value from the list
        count = count - 1; // Decrement the counter
        if(count > 0) {
            heapifyDown(arr, 0);
        }
    }
    public boolean isEmpty(){
        return (count == 0);
    }
    public int getMin(){
        return arr.get(0);
    }
    public int heapSize(){
        return count;
    }
    public static void main(String[] args) {
        ImplMInHeap heap = new ImplMInHeap();
        heap.initializeHeap();
        heap.insert(4); System.out.println("Inserting 4 in the min-heap");
        heap.insert(5); System.out.println("Inserting 5 in the min-heap");
        heap.insert(10); System.out.println("Inserting 10 in the min-heap");
        System.out.println("Minimum value in the min-heap is: " + heap.getMin());
        System.out.println("Size of min-heap is: " + heap.heapSize());
        System.out.println("Is heap empty: " + heap.isEmpty());
        System.out.println("Extracting minimum value from the heap");
        heap.extractMin();
        System.out.println("Changing value at index 0 to 10");
        heap.changeKey(0, 10);
        System.out.println("Minimum value in the min-heap is: " + heap.getMin());
    }
}
