import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FindIternary {


    public static void findItinerary(Map<String, String> tickets) {
        // Write code here

        String source = null;

        for (String key : tickets.keySet()){
            if (!tickets.containsValue(key)){
                source = key;
                break;
            }
        }

       // System.out.println();
        if (source==null){
            System.out.println("Invalid Input!");
            return;
        }
        while (tickets.containsKey(source)){
            System.out.println(source + "->" + tickets.get(source) );
            source= tickets.get(source);
        }


    }

    public static void main(String[] args) {
        Map<String, String> tickets = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            tickets.put(sc.next(),sc.next());
        }
        findItinerary(tickets);
    }
}
