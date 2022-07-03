import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class NearlySorted {
    private static void sortArray(int[] arr, int k) {

        // Write code here
        if(arr==null){
            return;
        }
        // declare a min heap using priority queue

        Queue<Integer> minHeap= new PriorityQueue<>();

        // if there are less than k elements in the array --> create min heap of size n and not k

        int heapSize= Integer.min(arr.length, k+1);

        // filling the heap with the first k elements
        for (int i=0; i< heapSize; i++){
            minHeap.add(arr[i]);
        }

        // removing the root element and adding it to array while adding the remaining elements to the heap

        int index=0;
        for (int i=k+1; i< arr.length;i++ ){
            arr[index++]= minHeap.poll();
            minHeap.offer(arr[i]);

        }

        // inserting remaining elements of the heap in the array
        Iterator<Integer> it= minHeap.iterator();

        while (it.hasNext()){
            arr[index++]= minHeap.poll();
        }


    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sortArray(arr, k);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
