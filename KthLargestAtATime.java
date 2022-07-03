import java.util.Scanner;

public class KthLargestAtATime {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int k = sc.nextInt();

        int stream[] = new int[n];

        for (int i = 0; i < n; i++) {

            int key = stream[i] = sc.nextInt();

            int j=i-1;

            while (j>=0 && stream[j]>key){
                stream[j+1]= stream[j];
                j--;
            }
            stream[j+1]=key;

            if (i+1<k){
                System.out.println("None");
            }
            else
                System.out.println(k+ " largest number is "+ stream[i-k+1]);

        }


// Write code here
    }
}
