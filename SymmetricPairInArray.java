import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SymmetricPairInArray {
    public static void symmetricPair(int[][] arr) {
        // Write code here
        int n= arr.length;

        Map<Integer,Integer> pair= new LinkedHashMap<>();

        for (int i=0; i<n;i++){
            pair.put(arr[i][0],arr[i][1]);
        }

        Iterator<Map.Entry<Integer,Integer>> iterator = pair.entrySet().iterator();

        while (iterator.hasNext()){

            Map.Entry<Integer,Integer> entry= iterator.next();

            int key= entry.getKey();
            int val= entry.getValue();

            if (pair.containsKey(val) && pair.get(val)==key ){
                System.out.println( key + " " + val);
                iterator.remove();
            }

        }

//        for (int key : pair.keySet()){
//
//
//                if ( pair.containsKey( pair.get(key) ) && pair.get( pair.get(key) )== key ){
//                    System.out.println( key + " " + pair.get(key));
//
//                    int val= pair.get(key);
//                    pair.remove(val,key);
//                }
//
//
//
//
//        }


    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int arr[][] = new int[row][2];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < 2 ; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        symmetricPair(arr);
    }
}
