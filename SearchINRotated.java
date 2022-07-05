import java.util.Scanner;

public class SearchINRotated {
    public static int search(int arr[], int left, int right, int key) {

        if (left>right)
            return -1;

        // find mid and match key
        int mid= (left+right)/2;

        if( arr[mid]==key)
            return mid;

        if ( arr[mid]>= arr[left] ){
            // left side is sorted
            if (key>=  arr[left] && key<= arr[mid]){
                //search in  first half
                return search(arr,left,mid-1,key);
            }
            // else search in second half
            return search(arr, mid+1, right, key);

        }
        // if l-mid is not sorted then mid+1-right might be sorted
        if (arr[mid]<=key && arr[right]>=key){
            return search(arr,mid+1,right,key);
        }
        return search( arr, left, mid-1,key );

    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        int i = search(arr, 0, n - 1, key);
        if (i != -1) {
            System.out.println(i);
        } else {
            System.out.println("-1");
        }
    }
}
