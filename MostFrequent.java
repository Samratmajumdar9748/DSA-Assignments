import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class MostFrequent {
    public static int mostFrequentElement(int[] arr) {

        // Write code here
        Map<Integer,Integer> countMap= new HashMap<>();

        for (int i: arr){
            if (countMap.containsKey(i)){
                int val= countMap.get(i)+1;
                countMap.put(i,val);
            }
            else {
                countMap.put(i,1);
            }
        }

        Iterator iterator= countMap.entrySet().iterator();

        int max=Integer.MIN_VALUE, maxi=-1;


        while (iterator.hasNext()){
            Map.Entry entry= (Map.Entry) iterator.next();

            if (max < (int)entry.getValue())
            {
                max=(int)entry.getValue();
                maxi=(int)entry.getKey();
            }
        }
        return maxi;

    }


    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(mostFrequentElement(arr));
    }
}
